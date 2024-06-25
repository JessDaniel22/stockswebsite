document.addEventListener("DOMContentLoaded", function() {
    const tableBody = document.querySelector("table tbody");

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

    // Initial fetch
    fetchData();

    // Fetch data every 5 seconds
    setInterval(fetchData, 5000);
});
