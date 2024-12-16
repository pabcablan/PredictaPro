package es.predictapro.service;

import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;

import java.util.List;

/**
 * PredictionService performs predictions on a dataset using linear regression.
 * <p>
 * This service calculates predictions based on the input data by:
 * - Using indices as independent variables (x).
 * - Applying linear regression to estimate the next value in the sequence.
 * </p>
 */
public class PredictionService {

    /**
     * Predicts the next value in the dataset using linear regression.
     * <p>
     * Steps:
     * 1. Validates the input data (checks if it's null or empty).
     * 2. Calculates the regression coefficients (slope and intercept).
     * 3. Uses the regression model to predict the next value in the sequence.
     * </p>
     *
     * @param data A list of {@link DataPoint} objects representing the dataset.
     * @return A {@link PredictionResult} containing the predicted value and a description message.
     */
    public PredictionResult predict(List<DataPoint> data) {
        // Step 1: Validate the input data
        if (data == null || data.isEmpty()) {
            return new PredictionResult(0, "Not enough data to make a prediction.");
        }

        // Initialize variables for linear regression calculations
        int n = data.size(); // Number of data points
        double sumX = 0.0; // Sum of x (indices)
        double sumY = 0.0; // Sum of y (values)
        double sumXY = 0.0; // Sum of x * y
        double sumX2 = 0.0; // Sum of x^2

        // Step 2: Compute the necessary sums
        for (int i = 0; i < n; i++) {
            double x = i + 1; // Use the index as the independent variable
            double y = data.get(i).getValue(); // The dependent variable (data value)

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        // Step 3: Calculate the slope (m) and intercept (b) for the regression line
        double m = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double b = (sumY - m * sumX) / n;

        // Step 4: Predict the next value (for x = n + 1)
        double nextX = n + 1;
        double predictedValue = m * nextX + b;

        // Step 5: Return the prediction result
        return new PredictionResult(predictedValue, "Prediction calculated using simple linear regression.");
    }
}

