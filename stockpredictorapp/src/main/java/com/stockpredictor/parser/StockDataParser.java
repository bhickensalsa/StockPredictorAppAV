package com.stockpredictor.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockpredictor.model.StockData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * {@code StockDataParser} is responsible for parsing JSON-formatted stock data
 * retrieved from an external API (e.g., Alpha Vantage) into a list of {@link StockData} objects.
 *
 * <p>The expected format is the "Time Series (Daily)" structure provided by Alpha Vantage.
 */
public class StockDataParser {

    /**
     * Parses the given JSON string into a list of {@link StockData} objects.
     *
     * @param json the raw JSON string returned by the stock data API
     * @return a list of {@link StockData} containing parsed daily trading information;
     *         returns an empty list if the JSON is invalid or data is missing
     */
    public static List<StockData> parse(String json) {
        List<StockData> dataList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            // Access the "Time Series (Daily)" section of the response
            JsonNode timeSeries = root.get("Time Series (Daily)");

            if (timeSeries != null) {
                Iterator<String> dates = timeSeries.fieldNames();

                // Iterate over each date and extract stock data for that day
                while (dates.hasNext()) {
                    String date = dates.next();
                    JsonNode node = timeSeries.get(date);

                    // Create a StockData object from the JSON node
                    StockData data = new StockData(
                            LocalDate.parse(date),
                            node.get("1. open").asDouble(),
                            node.get("4. close").asDouble(),
                            node.get("2. high").asDouble(),
                            node.get("3. low").asDouble(),
                            node.get("5. volume").asLong()
                    );

                    dataList.add(data);
                }
            }

        } catch (Exception e) {
            // Print the stack trace if parsing fails (could be improved with proper logging)
            e.printStackTrace();
        }

        return dataList;
    }
}
