package com.example.demo.model;

public class Stock {
    private String symbol;
    private String companyName;
    private double currentPriceChange;
    private double priceChangePercent;
    private double weekRangeLow;
    private double weekRangeHigh;
    private String marketCap;

    // Getters and Setters
    // Constructor

    public Stock(String symbol, String companyName, double currentPriceChange, double priceChangePercent, double weekRangeLow, double weekRangeHigh, String marketCap) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPriceChange = currentPriceChange;
        this.priceChangePercent = priceChangePercent;
        this.weekRangeLow = weekRangeLow;
        this.weekRangeHigh = weekRangeHigh;
        this.marketCap = marketCap;
    }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public double getCurrentPriceChange() { return currentPriceChange; }
    public void setCurrentPriceChange(double currentPriceChange) { this.currentPriceChange = currentPriceChange; }

    public double getPriceChangePercent() { return priceChangePercent; }
    public void setPriceChangePercent(double priceChangePercent) { this.priceChangePercent = priceChangePercent; }

    public double getWeekRangeLow() { return weekRangeLow; }
    public void setWeekRangeLow(double weekRangeLow) { this.weekRangeLow = weekRangeLow; }

    public double getWeekRangeHigh() { return weekRangeHigh; }
    public void setWeekRangeHigh(double weekRangeHigh) { this.weekRangeHigh = weekRangeHigh; }

    public String getMarketCap() { return marketCap; }
    public void setMarketCap(String marketCap) { this.marketCap = marketCap; }
}
