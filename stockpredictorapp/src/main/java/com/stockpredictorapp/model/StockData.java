package com.stockpredictorapp.model;

import java.time.LocalDate;

public class StockData {
    private LocalDate date;
    private double open;
    private double close;
    private double high;
    private double low;
    private long volume;

    public StockData(LocalDate date, double open, double close, double high, double low, long volume) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    public double getClose() {
        return close;
    }

    // Add other getters if needed
}
