package es.predictapro.model;


/**
 * PredictionResult represents the outcome of a prediction process.
 * <p>
 * It encapsulates:
 * - The predicted value as a numerical result.
 * - A message providing context or additional information about the prediction.
 * </p>
 */
public class PredictionResult {


    // The value predicted by the prediction process.
    private double predictedValue;


    // A message describing the prediction or its context.
    private String message;


    /**
     * Constructor for PredictionResult.
     *
     * @param predictedValue The numerical value resulting from the prediction.
     * @param message        A message providing context or details about the prediction result.
     */
    public PredictionResult(double predictedValue, String message) {
        this.predictedValue = predictedValue;
        this.message = message;
    }


    /**
     * Gets the predicted value.
     *
     * @return The numerical value of the prediction.
     */
    public double getPredictedValue() {
        return predictedValue;
    }


    /**
     * Gets the message associated with the prediction result.
     *
     * @return A descriptive message about the prediction.
     */
    public String getMessage() {
        return message;
    }


    /**
     * Converts the prediction result to a readable string format.
     *
     * @return A string representation of the prediction result, including the value and message.
     */
    @Override
    public String toString() {
        return "PredictionResult{predictedValue=" + predictedValue + ", message='" + message + "'}";
    }
}