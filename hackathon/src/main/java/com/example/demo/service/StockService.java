package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stock;

@Service
public class StockService {

    private List<Stock> stocks = Arrays.asList(
        new Stock("AAPL", "Apple Inc.", 170.00, 1.20, 145.00, 190.00, "$2.78T"),
        new Stock("TSLA", "Tesla Inc.", 700.00, 0.50, 550.00, 900.00, "$800B"),
        new Stock("GOOGL", "Alphabet Inc.", 2750.00, 1.15, 2300.00, 2900.00, "$1.82T"),
        new Stock("AMZN", "Amazon.com Inc.", 3500.00, 2.10, 3100.00, 3700.00, "$1.75T"),
        new Stock("MSFT", "Microsoft Corp.", 300.00, 1.75, 250.00, 350.00, "$2.25T"),
        new Stock("NVDA", "NVIDIA Corp.", 220.00, 1.80, 150.00, 230.00, "$600B"),
        new Stock("TSM", "Taiwan Semiconductor Manufacturing Co.", 120.00, -0.80, 100.00, 140.00, "$580B"),
        new Stock("JPM", "JPMorgan Chase & Co.", 150.00, -0.30, 120.00, 160.00, "$450B"),
        new Stock("FB", "Meta Platforms Inc.", 340.00, 1.50, 250.00, 380.00, "$940B"),
        new Stock("V", "Visa Inc.", 220.00, 1.10, 190.00, 250.00, "$480B"),
        new Stock("DIS", "Walt Disney Co.", 180.00, 1.25, 150.00, 200.00, "$330B"),
        new Stock("NFLX", "Netflix Inc.", 600.00, 1.85, 450.00, 650.00, "$270B"),
        new Stock("BRK.A", "Berkshire Hathaway Inc.", 420000.00, 0.60, 370000.00, 440000.00, "$700B"),
        new Stock("PG", "Procter & Gamble Co.", 150.00, 0.85, 130.00, 160.00, "$360B"),
        new Stock("MA", "Mastercard Inc.", 350.00, 1.30, 300.00, 370.00, "$350B"),
        new Stock("INTC", "Intel Corp.", 60.00, 0.40, 50.00, 70.00, "$240B"),
        new Stock("PYPL", "PayPal Holdings Inc.", 300.00, 2.00, 200.00, 320.00, "$350B"),
        new Stock("PEP", "PepsiCo Inc.", 160.00, 0.95, 140.00, 170.00, "$220B"),
        new Stock("KO", "Coca-Cola Co.", 60.00, 0.75, 50.00, 65.00, "$260B"),
        new Stock("XOM", "Exxon Mobil Corp.", 90.00, -0.20, 70.00, 100.00, "$400B")
        
        
        // Add more stock data as needed
    );

    private Random random = new Random();

    @Scheduled(fixedRate = 5000) // Update every 5 seconds
    public void updateStockPrices() {
        for (Stock stock : stocks) {
            double change = (random.nextDouble() - 0.5) * 10; // Simulate price change
            stock.setCurrentPriceChange(stock.getCurrentPriceChange() + change);
            stock.setPriceChangePercent((change / stock.getCurrentPriceChange()) * 100);
        }
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
