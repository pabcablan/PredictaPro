package es.predictapro.controller;


import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;
import es.predictapro.service.DataCleaningService;
import es.predictapro.service.PredictionService;


import java.util.List;


/**
 * DataController manages the data processing flow for predictions.
 * <p>
 * It coordinates the cleaning of raw data and the generation of predictions
 * by using the appropriate services.
 * </p>
 *
 * Purpose:
 * - Streamline the workflow between data cleaning and prediction services.
 * - Provide a single entry point for handling prediction requests.
 */
public class DataController {


    // Service responsible for cleaning raw data.
    private final DataCleaningService cleaningService;


    // Service responsible for generating predictions from clean data.
    private final PredictionService predictionService;


    /**
     * Constructor for DataController.
     *
     * @param cleaningService   The service used to clean raw data.
     * @param predictionService The service used to generate predictions.
     */
    public DataController(DataCleaningService cleaningService, PredictionService predictionService) {
        this.cleaningService = cleaningService;
        this.predictionService = predictionService;
    }



    /**
     * Handles a prediction request by cleaning the input data and generating a prediction.
     *
     * Workflow:
     * 1. Cleans the raw data using the DataCleaningService.
     * 2. Passes the cleaned data to the PredictionService to generate a prediction result.
     *
     * @param data The raw input data to be processed.
     * @return A {@link PredictionResult} containing the prediction outcome and message.
     */
    public PredictionResult handlePredictionRequest(List<DataPoint> data) {
        // Step 1: Clean the input data
        List<DataPoint> cleanedData = cleaningService.cleanData(data);


        // Step 2: Generate a prediction using the cleaned data
        return predictionService.predict(cleanedData);
    }
}