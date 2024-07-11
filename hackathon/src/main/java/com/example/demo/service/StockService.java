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
        new Stock("AAPL", "Apple Inc.", 150.00, 1.01, 116.21, 182.94, "$2.48T"),
        new Stock("TSLA", "Tesla Inc.", 650.00, -2.15, 450.00, 90.00, "$300B"),
        new Stock("ALPH", "Alphabet Inc.", 50.00, -2.15, 450.00, 900.00, "$900B"),
        new Stock("MAVN", "Maven Tec.", 40.00, -2.15, 49.00, 900.00, "$50B"),
        new Stock("NVID", "NVIDIA Inc.", 50.00, -2.15, 40.00, 900.00, "$200B"),
        new Stock("TMSC", "TSMC SEMI INC.", 5.00, -2.15, 40.00, 900.00, "$610B"),
        new Stock("BROS", "BROTHERS INC.", 60.00, -2.15, 40.00, 900.00, "$120B"),
        new Stock("JPMC", "JP Morgan INC.", 65.00, -2.15, 450.00, 900.00, "$809B")
        
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
