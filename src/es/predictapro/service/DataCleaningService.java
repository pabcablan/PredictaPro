package es.predictapro.service;

import es.predictapro.model.DataPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * DataCleaningService provides methods to clean raw datasets.
 * <p>
 * This service removes outliers from the input data by applying statistical
 * techniques such as mean and standard deviation. Data points outside of
 * a specified range are excluded.
 * </p>
 */
public class DataCleaningService {

    /**
     * Cleans the input data by removing outliers.
     * <p>
     * Steps:
     * 1. Calculates the mean (average) of the data values.
     * 2. Calculates the standard deviation to measure the spread of the data.
     * 3. Removes data points that fall outside the range defined by
     *    [mean - 2 * stdDev, mean + 2 * stdDev].
     * </p>
     *
     * @param data A list of {@link DataPoint} objects to clean.
     * @return A list of cleaned {@link DataPoint} objects within the defined range.
     *         Returns an empty list if the input is null or empty.
     */
    public List<DataPoint> cleanData(List<DataPoint> data) {
        // Handle null or empty input
        if (data == null || data.isEmpty()) {
            return new ArrayList<>(); // Returns an empty list if no data is provided
        }

        // Step 1: Calculate the mean (average)
        double sum = 0.0;
        for (DataPoint point : data) {
            sum += point.getValue();
        }
        double mean = sum / data.size();

        // Step 2: Calculate the standard deviation
        double varianceSum = 0.0;
        for (DataPoint point : data) {
            varianceSum += Math.pow(point.getValue() - mean, 2);
        }
        double stdDev = Math.sqrt(varianceSum / data.size());

        // Step 3: Define bounds using mean and standard deviation
        double lowerBound = mean - 2 * stdDev;
        double upperBound = mean + 2 * stdDev;

        // Step 4: Filter the data to include only points within the bounds
        List<DataPoint> cleanedData = new ArrayList<>();
        for (DataPoint point : data) {
            if (point.getValue() >= lowerBound && point.getValue() <= upperBound) {
                cleanedData.add(point);
            }
        }

        // Return the cleaned dataset
        return cleanedData;
    }
}
