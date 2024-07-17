document.addEventListener("DOMContentLoaded", function() {
    const tableBody = document.querySelector("table tbody");
    const topCompaniesContainer = document.getElementById("top-companies-container");

    // Function to determine class based on positive or negative change
    function getClassForChange(change) {
        return change >= 0 ? "positive-change" : "negative-change";
    }

    // Function to populate the table with data
    function populateTable(stocksData) {
        tableBody.innerHTML = ""; // Clear existing rows
        stocksData.forEach((stock) => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${stock.symbol}</td>
                <td>${stock.companyName}</td>
                <td class="${getClassForChange(stock.priceChangePercent)}">$${stock.currentPriceChange.toFixed(2)} / ${stock.priceChangePercent.toFixed(2)}%</td>
                <td class="week-range">$${stock.weekRangeLow.toFixed(2)} - $${stock.weekRangeHigh.toFixed(2)}</td>
                <td>${stock.marketCap}</td>
            `;
            tableBody.appendChild(tr);
        });
    }

   // Function to populate the top companies' cards
   function populateTopCompanies(companiesData) {
    topCompaniesContainer.innerHTML = ""; // Clear existing cards
    companiesData.forEach((company) => {
        const div = document.createElement("div");
        div.classList.add("company-card");
        div.innerHTML = `
            <div class="icon">
                <span class="ri-${company.icon}-line"></span>
            </div>
            <div class="right">
                <div class="info">
                    <h2>${company.name}</h2>
                    <small class="text-muted">Last 24 hours</small>
                </div>
            </div>
        `;
        topCompaniesContainer.appendChild(div);
    });
}

    // Function to fetch data from the Spring Boot API
    function fetchData() {
        fetch('http://localhost:8080/api/stocks')
            .then(response => response.json())
            .then(data => {
                populateTable(data);
            })
            .catch(error => {
                console.error('Error fetching stock data:', error);
            });
    }

    // Function to fetch top companies data from the API
    function fetchTopCompaniesData() {
        fetch('http://localhost:8080/top-companies')
            .then(response => response.json())
            .then(data => {
                populateTopCompanies(data);
            })
            .catch(error => {
                console.error('Error fetching top companies data:', error);
            });
    }

    // Initial fetch
    fetchData();
    fetchTopCompaniesData();

    // Fetch data every 5 seconds
    setInterval(fetchData, 5000);
    setInterval(fetchTopCompaniesData, 5000);
});
