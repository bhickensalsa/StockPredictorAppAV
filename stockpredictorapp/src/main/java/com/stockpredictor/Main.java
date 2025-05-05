package com.stockpredictor;

import com.stockpredictor.api.AlphaVantageClient;
import com.stockpredictor.model.StockData;
import com.stockpredictor.predictor.*;
import com.stockpredictor.utils.ConfigLoader;

import java.util.List;
import java.util.Properties;

/**
 * {@code Main} is the entry point of the Stock Predictor application.
 * 
 * <p>This class loads configuration settings, retrieves stock data from an API (Alpha Vantage),
 * applies a prediction model (e.g., Moving Average), and outputs the predicted next stock price.
 */
public class Main {

    /**
     * The main method that executes the stock prediction workflow.
     *
     * <p>Steps:
     * <ol>
     *   <li>Loads configuration settings (API key, base URL) from a properties file.</li>
     *   <li>Uses the AlphaVantageClient to fetch historical stock data for a given symbol (e.g., "AAPL").</li>
     *   <li>Applies a prediction model (e.g., Moving Average) to predict the next stock price.</li>
     *   <li>Prints the predicted next stock price to the console.</li>
     * </ol>
     *
     * @param args command-line arguments (not used in this version)
     */
    public static void main(String[] args) {
        try {
            // Load configuration from file (API key, base URL)
            Properties config = ConfigLoader.load("config.properties");

            // Initialize the AlphaVantageClient with the loaded configuration
            AlphaVantageClient client = new AlphaVantageClient(config);

            // Fetch historical daily stock data for the symbol "AAPL"
            List<StockData> stockData = client.getTimeSeriesDaily("AAPL");

            // Choose a predictor model (e.g., Moving Average with a 5-day window)
            Predictor predictor = new MovingAveragePredictor(5); // Can switch to other models like LinearRegressionPredictor

            // Predict the next closing price based on historical data
            double prediction = predictor.predictNext(stockData);

            // Output the predicted next value to the console
            System.out.println("Predicted next value: " + prediction);

        } catch (Exception e) {
            // Handle any exceptions that occur during execution (e.g., API call failures, invalid data)
            e.printStackTrace();
        }
    }
}
