package es.predictapro.controller;


import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;
import es.predictapro.service.PredictionService;


import java.util.List;


/**
 * PredictionController handles requests related to predictions.
 * <p>
 * This controller acts as an intermediary between the prediction service
 * and the rest of the application, ensuring clean and reusable logic.
 * </p>
 */
public class PredictionController {


    // Service responsible for handling prediction logic.
    private final PredictionService predictionService;


    /**
     * Constructor for PredictionController.
     *
     * @param predictionService The service used to generate predictions.
     */
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }


    /**
     * Handles a prediction request.
     * <p>
     * This method directly delegates the prediction task to the {@link PredictionService}.
     * </p>
     *
     * @param data A list of {@link DataPoint} objects to be used for prediction.
     * @return A {@link PredictionResult} containing the predicted value and related details.
     */
    public PredictionResult handlePrediction(List<DataPoint> data) {
        return predictionService.predict(data);
    }
}
