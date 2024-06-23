
document.addEventListener("DOMContentLoaded", function() {
    const tableBody = document.querySelector("table tbody");

    // Clear existing rows in case of re-rendering
    tableBody.innerHTML = "";

    // Function to determine class based on positive or negative change
    function getClassForChange(change) {
        return change >= 0 ? "positive-change" : "negative-change";
    }

    // Populate the table with data
    stocksDummyData.forEach((stock) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${stock.symbol}</td>
            <td>${stock.companyName}</td>
            <td class="${getClassForChange(stock.priceChangePercent)}">$${stock.currentPriceChange.toFixed(2)} / ${stock.priceChangePercent}%</td>
            <td class="week-range">$${stock.weekRangeLow.toFixed(2)} - $${stock.weekRangeHigh.toFixed(2)}</td>
            <td>${stock.marketCap}</td>
        `;
        tableBody.appendChild(tr);
    });
});