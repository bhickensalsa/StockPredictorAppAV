# Stock Predictor

A stock price prediction tool that uses various algorithms to predict future stock prices based on historical data. The project fetches stock data from the Alpha Vantage API, processes the data, and uses different prediction models like Moving Average, Linear Regression, and placeholders for Machine Learning-based models.

## Features

* Fetches historical stock data for a given stock symbol (e.g., AAPL) from the Alpha Vantage API.
* Supports multiple prediction models:
    * **Moving Average:** Predicts the next stock price based on the average of the last N closing prices.
    * **Linear Regression:** Uses linear regression to predict future stock prices based on past data.
    * **Machine Learning (placeholder):** A placeholder for integrating with machine learning frameworks such as Weka, TensorFlow, or DL4J for advanced prediction models.
* Modular design allows easy extension with more prediction algorithms or data sources.

## Installation

### Prerequisites

* Java 8 or higher
* An Alpha Vantage API key (you can get one [here](https://www.alphavantage.co/support/#api-key))

### Setup

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/yourusername/stock-predictor.git](https://github.com/yourusername/stock-predictor.git)
    cd stock-predictor
    ```

2.  **Install dependencies:**

    If you’re using Maven, you can use the following command to download dependencies:

    ```bash
    mvn clean install
    ```

3.  **Configure API credentials:**

    * Create a `config.properties` file in the `src/main/resources` directory (or any other suitable directory).
    * Add the following properties to the `config.properties` file:

        ```properties
        # Configuration file for Stock Predictor application

        # API key for accessing the Alpha Vantage API
        # Replace with your own Alpha Vantage API key
        api.key=YOUR_API_KEY

        # Base URL for Alpha Vantage API requests
        # This is the URL used to retrieve stock data from Alpha Vantage
        api.base_url=[https://www.alphavantage.co/query](https://www.alphavantage.co/query)
        ```

4.  **Run the application:**

    Once you’ve set up the `config.properties` file, you can run the main application:

    ```bash
    mvn exec:java -Dexec.mainClass="com.stockpredictor.Main"
    ```

    This will fetch the historical stock data for the stock symbol AAPL, apply the Moving Average predictor, and output the predicted next closing price.

## Usage

* **Stock Symbol:** By default, the program fetches data for the stock symbol "AAPL" (Apple). You can modify the `Main.java` file to use other symbols by changing the argument passed to the `getTimeSeriesDaily` method in the `AlphaVantageClient` class.
* **Prediction Models:** You can switch between prediction models in the `Main.java` file by changing the implementation of the `Predictor` interface. Available options include:
    * `MovingAveragePredictor`: Predicts using a simple moving average.
    * `LinearRegressionPredictor`: Predicts using linear regression.
    * `MLModelPredictor`: Placeholder for a machine learning-based model.

## Code Overview

### AlphaVantageClient

This class is responsible for fetching historical stock data from the Alpha Vantage API using your API key and the base URL specified in the `config.properties` file.

### StockData

A model class that represents the stock data for a specific day, including fields such as the date, open, close, high, low prices, and volume.

### Predictor Interface & Implementations

The `Predictor` interface defines the contract for stock prediction models. It is implemented by different classes, such as:

* `MovingAveragePredictor`: Uses a simple moving average to predict the next closing price.
* `LinearRegressionPredictor`: Uses linear regression to predict the next closing price.
* `MLModelPredictor`: Placeholder for integrating machine learning models.

### ConfigLoader

This utility class is used to load configuration properties from the `config.properties` file, making it easy to configure API keys and URLs.

### Main

The entry point of the application that ties everything together. It loads the configuration, fetches stock data, applies the chosen prediction model, and prints the result.

## Contributing

Contributions are welcome! Feel free to fork the repository, create a branch, and submit pull requests. If you have any ideas for new prediction models, feel free to contribute. Please make sure to follow the existing code style and include tests for any new functionality.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Author: Your Name
GitHub: https://github.com/bhickensalsa
Email: phi.jonsson@gmail.com
