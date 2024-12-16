import es.predictapro.service.DataCleaningService;
import es.predictapro.model.DataPoint;

import java.util.Arrays;
import java.util.List;

/**
 * DataCleaningServiceTest is a simple executable test class for the {@link DataCleaningService}.
 * <p>
 * This class demonstrates the functionality of the data cleaning service by:
 * - Creating a sample dataset with valid and invalid values.
 * - Cleaning the dataset using the service.
 * - Printing the results of the cleaning process to the console.
 * </p>
 */
public class DataCleaningServiceTest {

    /**
     * The main method to execute the test.
     * <p>
     * Steps:
     * 1. Initializes a sample dataset with valid and invalid data points.
     * 2. Uses the {@link DataCleaningService} to clean the data.
     * 3. Outputs the cleaned dataset to the console.
     * </p>
     *
     * @param args Command-line arguments (not used in this test).
     */
    public static void main(String[] args) {
        // Step 1: Create an instance of the DataCleaningService
        DataCleaningService cleaningService = new DataCleaningService();

        // Step 2: Define test data
        List<DataPoint> data = Arrays.asList(
                new DataPoint(1, 10.5, System.currentTimeMillis()), // Valid data
                new DataPoint(2, -5.0, System.currentTimeMillis()), // Outlier (negative value)
                new DataPoint(3, 20.0, System.currentTimeMillis())  // Valid data
        );

        // Step 3: Execute the cleanData method
        List<DataPoint> cleanedData = cleaningService.cleanData(data);

        // Step 4: Display the results of the cleaning process
        System.out.println("Results of Data Cleaning:");
        for (DataPoint dp : cleanedData) {
            System.out.println("ID: " + dp.getId() + ", VALUE: " + dp.getValue() + ", TIMESTAMP: " + dp.getTimestamp());
        }
    }
}

