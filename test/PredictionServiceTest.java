import es.predictapro.service.PredictionService;
import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;

import java.util.Arrays;
import java.util.List;

/**
 * PredictionServiceTest is a simple executable test class for the {@link PredictionService}.
 * <p>
 * This class demonstrates the functionality of the PredictionService by:
 * - Creating sample data points.
 * - Using the service to generate a prediction.
 * - Printing the prediction result to the console.
 * </p>
 */
public class PredictionServiceTest {

    /**
     * The main method to execute the test.
     * <p>
     * Steps:
     * 1. Initializes the {@link PredictionService}.
     * 2. Defines a sample dataset for testing.
     * 3. Uses the service to generate a prediction from the dataset.
     * 4. Outputs the prediction result to the console.
     * </p>
     *
     * @param args Command-line arguments (not used in this test).
     */
    public static void main(String[] args) {
        // Step 1: Create an instance of the PredictionService
        PredictionService predictionService = new PredictionService();

        // Step 2: Define test data
        List<DataPoint> data = Arrays.asList(
                new DataPoint(1, 10.0, System.currentTimeMillis()), // First data point
                new DataPoint(2, 20.0, System.currentTimeMillis()), // Second data point
                new DataPoint(3, 30.0, System.currentTimeMillis())  // Third data point
        );

        // Step 3: Use the service to generate a prediction
        PredictionResult result = predictionService.predict(data);

        // Step 4: Display the prediction result
        System.out.println("PredictionService Test:");
        System.out.println("Predicted Value: " + result.getPredictedValue());
        System.out.println("Message: " + result.getMessage());
    }
}
