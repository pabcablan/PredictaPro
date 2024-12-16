import es.predictapro.model.DataPoint;
import es.predictapro.service.DataStatisticsService;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test class for {@link DataStatisticsService}.
 * <p>
 * This class tests the functionality of the {@link DataStatisticsService}
 * by validating the computation of statistical metrics such as average,
 * maximum, minimum, and range for a given set of data points.
 * </p>
 */
public class DataStatisticsServiceTest {

    /**
     * Main method to execute the test cases for {@link DataStatisticsService}.
     * <p>
     * The test verifies:
     * - Correct computation of average.
     * - Correct determination of maximum and minimum values.
     * - Proper calculation of range.
     * - Handling of edge cases such as empty or single data point lists.
     * </p>
     *
     * @param args Command-line arguments (not used in this test).
     */
    public static void main(String[] args) {
        System.out.println("Running DataStatisticsServiceTest...");

        // Test 1: Standard dataset
        testWithStandardDataset();

        // Test 2: Empty dataset
        testWithEmptyDataset();

        // Test 3: Single data point
        testWithSingleDataPoint();
    }

    /**
     * Tests statistical metrics using a standard dataset.
     */
    private static void testWithStandardDataset() {
        DataStatisticsService statisticsService = new DataStatisticsService();

        // Define test data
        List<DataPoint> data = Arrays.asList(
                new DataPoint(1, 10.0, System.currentTimeMillis()),
                new DataPoint(2, 20.0, System.currentTimeMillis()),
                new DataPoint(3, 30.0, System.currentTimeMillis())
        );

        // Execute statistical methods
        double average = statisticsService.calculateAverage(data);
        double max = statisticsService.findMax(data);
        double min = statisticsService.findMin(data);
        double range = statisticsService.calculateRange(data);

        // Print results
        System.out.println("Test 1: Standard Dataset");
        System.out.println("Average: " + average + " (Expected: 20.0)");
        System.out.println("Max: " + max + " (Expected: 30.0)");
        System.out.println("Min: " + min + " (Expected: 10.0)");
        System.out.println("Range: " + range + " (Expected: 20.0)");
        System.out.println();
    }

    /**
     * Tests statistical metrics using an empty dataset.
     * Ensures methods handle empty lists gracefully.
     */
    private static void testWithEmptyDataset() {
        DataStatisticsService statisticsService = new DataStatisticsService();

        // Define test data
        List<DataPoint> data = Arrays.asList();

        // Execute statistical methods
        double average = statisticsService.calculateAverage(data);
        double max = statisticsService.findMax(data);
        double min = statisticsService.findMin(data);
        double range = statisticsService.calculateRange(data);

        // Print results
        System.out.println("Test 2: Empty Dataset");
        System.out.println("Average: " + average + " (Expected: 0.0)");
        System.out.println("Max: " + max + " (Expected: Double.MIN_VALUE)");
        System.out.println("Min: " + min + " (Expected: Double.MAX_VALUE)");
        System.out.println("Range: " + range + " (Expected: 0.0)");
        System.out.println();
    }

    /**
     * Tests statistical metrics using a dataset with a single data point.
     */
    private static void testWithSingleDataPoint() {
        DataStatisticsService statisticsService = new DataStatisticsService();

        // Define test data
        List<DataPoint> data = Arrays.asList(
                new DataPoint(1, 42.0, System.currentTimeMillis())
        );

        // Execute statistical methods
        double average = statisticsService.calculateAverage(data);
        double max = statisticsService.findMax(data);
        double min = statisticsService.findMin(data);
        double range = statisticsService.calculateRange(data);

        // Print results
        System.out.println("Test 3: Single Data Point");
        System.out.println("Average: " + average + " (Expected: 42.0)");
        System.out.println("Max: " + max + " (Expected: 42.0)");
        System.out.println("Min: " + min + " (Expected: 42.0)");
        System.out.println("Range: " + range + " (Expected: 0.0)");
        System.out.println();
    }
}

