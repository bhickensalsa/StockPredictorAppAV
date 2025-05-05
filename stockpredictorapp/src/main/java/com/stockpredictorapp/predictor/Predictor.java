package com.stockpredictorapp.predictor;

import com.stockpredictorapp.model.StockData;
import java.util.List;

public interface Predictor {
    double predictNext(List<StockData> data);
}
