import es.predictapro.controller.DataController;
import es.predictapro.service.DataCleaningService;
import es.predictapro.service.PredictionService;
import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;

import java.util.Arrays;
import java.util.List;

/**
 * DataControllerTest is a simple executable test class for the {@link DataController}.
 * <p>
 * This class demonstrates the functionality of the DataController by:
 * - Creating sample data points.
 * - Using the controller to clean the data and generate a prediction.
 * - Printing the prediction result to the console.
 * </p>
 */
public class DataControllerTest {

    /**
     * The main method to execute the test.
     * <p>
     * Steps:
     * 1. Initializes the services and the DataController.
     * 2. Defines a sample dataset for testing.
     * 3. Calls the controller to process the data and generate a prediction.
     * 4. Outputs the prediction result to the console.
     * </p>
     *
     * @param args Command-line arguments (not used in this test).
     */
    public static void main(String[] args) {
        // Step 1: Create instances of the services and the controller
        DataCleaningService cleaningService = new DataCleaningService();
        PredictionService predictionService = new PredictionService();
        DataController controller = new DataController(cleaningService, predictionService);

        // Step 2: Define test data
        List<DataPoint> data = Arrays.asList(
                new DataPoint(1, 10.5, System.currentTimeMillis()), // Valid data
                new DataPoint(2, -5.0, System.currentTimeMillis()), // Outlier (negative value)
                new DataPoint(3, 20.0, System.currentTimeMillis())  // Valid data
        );

        // Step 3: Use the controller to handle the prediction request
        PredictionResult result = controller.handlePredictionRequest(data);

        // Step 4: Display the prediction result
        System.out.println("DataController Test:");
        System.out.println("Predicted Value: " + result.getPredictedValue());
        System.out.println("Message: " + result.getMessage());
    }
}
