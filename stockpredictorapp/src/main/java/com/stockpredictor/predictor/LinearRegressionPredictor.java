package com.stockpredictor.predictor;

import com.stockpredictor.model.StockData;

import java.util.List;

/**
 * {@code LinearRegressionPredictor} implements the {@link Predictor} interface and provides
 * a simple linear regression-based approach to predict the next closing price of a stock.
 *
 * <p>This model assumes a linear relationship between time (as sequential days)
 * and the closing stock price.
 */
public class LinearRegressionPredictor implements Predictor {

    /**
     * Predicts the next closing price based on the linear regression of the input time series.
     *
     * @param data a list of {@link StockData} objects representing consecutive daily stock prices
     * @return the predicted closing price for the next day
     * @throws IllegalArgumentException if fewer than two data points are provided
     */
    @Override
    public double predictNext(List<StockData> data) {
        int n = data.size();
        if (n < 2) {
            throw new IllegalArgumentException("Not enough data for regression.");
        }

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        // Treat each day as x = 0, 1, ..., n-1, and y = closing price
        for (int i = 0; i < n; i++) {
            double x = i;
            double y = data.get(i).getClose();
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        // Calculate slope (m) and intercept (b) of best-fit line: y = mx + b
        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        // Predict the next point (x = n)
        return slope * n + intercept;
    }
}
