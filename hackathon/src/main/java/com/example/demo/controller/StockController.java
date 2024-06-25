package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stock;
import com.example.demo.service.StockService;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/api/stocks")
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }
}
