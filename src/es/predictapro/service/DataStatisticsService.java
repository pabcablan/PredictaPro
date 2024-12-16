package es.predictapro.service;

import es.predictapro.model.DataPoint;

import java.util.List;

/**
 * Service for computing statistical metrics on a dataset.
 * <p>
 * Provides methods to calculate average, maximum, minimum, range, and other
 * key statistical metrics from a list of {@link DataPoint} objects.
 * </p>
 */
public class DataStatisticsService {

    /**
     * Computes the average of the given data points.
     *
     * @param dataPoints The list of data points.
     * @return The average value, or 0.0 if the list is empty.
     */
    public double calculateAverage(List<DataPoint> dataPoints) {
        return dataPoints.stream()
                .mapToDouble(DataPoint::getValue)
                .average()
                .orElse(0.0);
    }

    /**
     * Finds the maximum value among the given data points.
     *
     * @param dataPoints The list of data points.
     * @return The maximum value, or {@code Double.MIN_VALUE} if the list is empty.
     */
    public double findMax(List<DataPoint> dataPoints) {
        return dataPoints.stream()
                .mapToDouble(DataPoint::getValue)
                .max()
                .orElse(Double.MIN_VALUE);
    }

    /**
     * Finds the minimum value among the given data points.
     *
     * @param dataPoints The list of data points.
     * @return The minimum value, or {@code Double.MAX_VALUE} if the list is empty.
     */
    public double findMin(List<DataPoint> dataPoints) {
        return dataPoints.stream()
                .mapToDouble(DataPoint::getValue)
                .min()
                .orElse(Double.MAX_VALUE);
    }

    /**
     * Calculates the range of values (difference between max and min)
     * among the given data points.
     *
     * @param dataPoints The list of data points.
     * @return The range of values, or 0.0 if the list is empty.
     */
    public double calculateRange(List<DataPoint> dataPoints) {
        if (dataPoints == null || dataPoints.isEmpty()) {
            return 0.0;
        }
        return findMax(dataPoints) - findMin(dataPoints);
    }

    /**
     * Calculates the sum of all values among the given data points.
     *
     * @param dataPoints The list of data points.
     * @return The total sum of values, or 0.0 if the list is empty.
     */
    public double calculateSum(List<DataPoint> dataPoints) {
        return dataPoints.stream()
                .mapToDouble(DataPoint::getValue)
                .sum();
    }

    /**
     * Calculates the count of data points in the list.
     *
     * @param dataPoints The list of data points.
     * @return The number of data points, or 0 if the list is null or empty.
     */
    public long countDataPoints(List<DataPoint> dataPoints) {
        return dataPoints != null ? dataPoints.size() : 0;
    }
}