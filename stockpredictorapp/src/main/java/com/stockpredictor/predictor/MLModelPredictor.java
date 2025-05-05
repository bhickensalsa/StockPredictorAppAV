package com.stockpredictor.predictor;

import com.stockpredictor.model.StockData;

import java.util.List;

/**
 * {@code MLModelPredictor} is a placeholder implementation of the {@link Predictor} interface
 * that is intended to use a machine learning model (e.g., Weka, DL4J, TensorFlow)
 * to predict the next closing price of a stock.
 *
 * <p>Currently, this implementation does not perform any real prediction
 * and should be extended or replaced with actual ML inference logic.
 */
public class MLModelPredictor implements Predictor {

    /**
     * Predicts the next closing price using a machine learning model.
     *
     * <p><b>Note:</b> This method is not yet implemented and always returns {@code 0.0}.
     *
     * @param data a list of {@link StockData} representing historical stock prices
     * @return the predicted closing price for the next day (currently always {@code 0.0})
     */
    @Override
    public double predictNext(List<StockData> data) {
        // TODO: Integrate with a real ML model using frameworks like Weka, DL4J, or TensorFlow
        System.out.println("ML Predictor not implemented.");
        return 0.0;
    }
}
