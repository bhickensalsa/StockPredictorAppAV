package com.stockpredictorapp.predictor;

import com.stockpredictorapp.model.StockData;
import java.util.List;

public class MovingAveragePredictor implements Predictor {
    private final int windowSize;

    public MovingAveragePredictor(int windowSize) {
        this.windowSize = windowSize;
    }

    @Override
    public double predictNext(List<StockData> data) {
        int start = Math.max(0, data.size() - windowSize);
        return data.subList(start, data.size())
                   .stream()
                   .mapToDouble(StockData::getClose)
                   .average()
                   .orElseThrow();
    }
}
