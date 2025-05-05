package com.stockpredictor.api;

import com.stockpredictor.model.StockData;
import com.stockpredictor.parser.StockDataParser;
import com.stockpredictor.exception.ApiException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * AlphaVantageClient is responsible for interacting with the Alpha Vantage API
 * to retrieve stock market data.
 *
 * <p>This class fetches daily time series stock data in JSON format
 * and parses it into a list of {@link StockData} objects using {@link StockDataParser}.
 */
public class AlphaVantageClient {
    
    /** API key used to authenticate requests to Alpha Vantage */
    private final String apiKey;

    /** Base URL for the Alpha Vantage API */
    private final String baseUrl;

    /** HTTP client used to perform API requests */
    private final OkHttpClient httpClient;

    /**
     * Constructs an {@code AlphaVantageClient} using the provided configuration properties.
     *
     * @param config a {@code Properties} object containing the required API configuration
     *               - "api.key": the API key for Alpha Vantage
     *               - "api.base_url": the base URL for the Alpha Vantage API
     */
    public AlphaVantageClient(Properties config) {
        this.apiKey = config.getProperty("api.key");
        this.baseUrl = config.getProperty("api.base_url");
        this.httpClient = new OkHttpClient();
    }

    /**
     * Fetches daily time series stock data for the given symbol.
     *
     * @param symbol the stock ticker symbol (e.g., "AAPL", "GOOGL")
     * @return a list of {@link StockData} representing the daily time series data
     * @throws IOException if a network error occurs during the HTTP request
     * @throws ApiException if the API response is not successful (e.g., bad request, quota exceeded)
     */
    public List<StockData> getTimeSeriesDaily(String symbol) throws IOException {
        // Construct the API request URL with the appropriate query parameters
        String url = String.format("%s?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s", baseUrl, symbol, apiKey);

        // Create the HTTP request
        Request request = new Request.Builder().url(url).build();

        // Execute the request and handle the response
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                // If the response is not successful, throw a custom exception with the message
                throw new ApiException("API request failed: " + response.message());
            }

            // Parse the JSON response body into a list of StockData objects
            String json = response.body().string();
            return StockDataParser.parse(json);
        }
    }
}
