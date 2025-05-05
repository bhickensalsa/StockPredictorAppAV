package com.stockpredictor.predictor;

import com.stockpredictor.model.StockData;
import java.util.List;

/**
 * {@code Predictor} is a functional interface that defines the contract
 * for predicting the next closing price of a stock based on historical data.
 *
 * <p>Implementations of this interface may use statistical methods,
 * machine learning models, or heuristic approaches to make predictions.
 */
public interface Predictor {

    /**
     * Predicts the next closing price of a stock using the given historical data.
     *
     * @param data a list of {@link StockData} objects representing historical daily prices,
     *             ordered from oldest to newest
     * @return the predicted closing price for the next day
     * @throws IllegalArgumentException or custom exceptions if the data is insufficient or invalid
     */
    double predictNext(List<StockData> data);
}
