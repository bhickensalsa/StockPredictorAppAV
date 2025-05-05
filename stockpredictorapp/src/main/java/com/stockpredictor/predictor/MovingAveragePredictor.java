package com.stockpredictor.predictor;

import com.stockpredictor.model.StockData;

import java.util.List;

/**
 * {@code MovingAveragePredictor} implements the {@link Predictor} interface and
 * provides a simple prediction method based on the moving average of recent closing prices.
 *
 * <p>This approach smooths out short-term fluctuations and predicts the next closing price
 * as the average of the last N closing prices.
 */
public class MovingAveragePredictor implements Predictor {

    /** Number of recent data points to include in the moving average */
    private final int windowSize;

    /**
     * Constructs a {@code MovingAveragePredictor} with the specified window size.
     *
     * @param windowSize the number of most recent days to consider in the moving average
     */
    public MovingAveragePredictor(int windowSize) {
        this.windowSize = windowSize;
    }

    /**
     * Predicts the next closing price using a simple moving average over the last {@code windowSize} days.
     *
     * @param data a list of {@link StockData} representing historical stock prices
     * @return the predicted closing price for the next day
     * @throws IllegalStateException if the window is empty (i.e., no data points to average)
     */
    @Override
    public double predictNext(List<StockData> data) {
        // Determine the start index to apply the moving average (ensure non-negative)
        int start = Math.max(0, data.size() - windowSize);

        // Calculate and return the average of the closing prices in the window
        return data.subList(start, data.size())
                   .stream()
                   .mapToDouble(StockData::getClose)
                   .average()
                   .orElseThrow(); // Throws if the window is empty
    }
}
