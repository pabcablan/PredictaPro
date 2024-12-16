package es.predictapro;

import es.predictapro.config.AppConfig;
import es.predictapro.controller.ReportController;
import es.predictapro.model.DataPoint;
import es.predictapro.model.PredictionResult;
import es.predictapro.service.DataCleaningService;
import es.predictapro.service.DataValidationService;
import es.predictapro.service.PredictionService;
import es.predictapro.service.DataStatisticsService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Main class serves as the entry point for the application.
 * <p>
 * It demonstrates the functionality of the system by:
 * - Simulating input data.
 * - Validating, cleaning, predicting, reporting, and analyzing data.
 * - Displaying results in a user-friendly manner.
 * </p>
 */
public class Main {

    /**
     * Main method orchestrates the application's workflow.
     * <p>
     * Steps:
     * 1. Initializes services and controllers using {@link AppConfig}.
     * 2. Simulates input data.
     * 3. Processes the data by validating, cleaning, predicting, reporting, and analyzing it.
     * </p>
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize services and controllers
        DataCleaningService cleaningService = AppConfig.getDataCleaningService();
        DataValidationService validationService = AppConfig.getDataValidationService();
        PredictionService predictionService = AppConfig.getPredictionService();
        DataStatisticsService statisticsService = AppConfig.getDataStatisticsService();
        ReportController reportController = new ReportController(AppConfig.getVisualizationService());

        // Simulate input data
        List<DataPoint> rawData = createSampleData();

        // Process and display results
        processAndDisplay(rawData, cleaningService, validationService, predictionService, statisticsService, reportController);
    }

    /**
     * Simulates a dataset for demonstration purposes.
     *
     * @return A list of sample {@link DataPoint} objects.
     */
    private static List<DataPoint> createSampleData() {
        return Arrays.asList(
                new DataPoint(1, 10.5, System.currentTimeMillis()),
                new DataPoint(2, -50.0, System.currentTimeMillis() - 86400000L),
                new DataPoint(3, 20.0, System.currentTimeMillis()),
                new DataPoint(4, 1000.0, System.currentTimeMillis() - 604800000L), // Extreme outlier
                new DataPoint(5, 15.0, System.currentTimeMillis()),
                new DataPoint(6, 12.0, System.currentTimeMillis())
        );
    }

    /**
     * Processes the input data and displays results.
     *
     * @param rawData The raw input data.
     * @param cleaningService Service for cleaning data.
     * @param validationService Service for validating data.
     * @param predictionService Service for generating predictions.
     * @param statisticsService Service for analyzing data.
     * @param reportController Controller for generating data reports.
     */
    private static void processAndDisplay(
            List<DataPoint> rawData,
            DataCleaningService cleaningService,
            DataValidationService validationService,
            PredictionService predictionService,
            DataStatisticsService statisticsService,
            ReportController reportController
    ) {
        // Step 1: Validate the data
        validateData(rawData, validationService);

        // Step 2: Clean the data
        List<DataPoint> cleanedData = cleanData(rawData, cleaningService);

        // Step 3: Generate predictions
        predictData(cleanedData, predictionService);

        // Step 4: Generate tabular report
        generateReport(cleanedData, reportController);

        // Step 5: Analyze cleaned data
        analyzeData(cleanedData, statisticsService);
    }

    /**
     * Validates the raw input data for integrity and quality.
     *
     * @param rawData The raw input data.
     * @param validationService The service used for data validation.
     */
    private static void validateData(List<DataPoint> rawData, DataValidationService validationService) {
        System.out.println("===================================");
        System.out.println("=== Section 1: Data Validation ===");
        System.out.println("===================================");
        try {
            validationService.validateData(rawData);
            System.out.println("Data validated successfully.");
        } catch (Exception e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Cleans the raw input data by removing outliers.
     *
     * @param rawData The raw input data.
     * @param cleaningService The service used for data cleaning.
     * @return A list of cleaned {@link DataPoint} objects.
     */
    private static List<DataPoint> cleanData(List<DataPoint> rawData, DataCleaningService cleaningService) {
        System.out.println("===================================");
        System.out.println("=== Section 2: Data Cleaning ===");
        System.out.println("===================================");
        printDataPoints("Original Data:", rawData);
        List<DataPoint> cleanedData = cleaningService.cleanData(rawData);
        printDataPoints("Cleaned Data:", cleanedData);
        return cleanedData;
    }

    /**
     * Generates a prediction based on the cleaned data.
     *
     * @param cleanedData The cleaned data.
     * @param predictionService The service used for generating predictions.
     */
    private static void predictData(List<DataPoint> cleanedData, PredictionService predictionService) {
        System.out.println("===================================");
        System.out.println("=== Section 3: Prediction ===");
        System.out.println("===================================");
        PredictionResult prediction = predictionService.predict(cleanedData);
        System.out.println("Predicted Value: " + prediction.getPredictedValue());
        System.out.println("Message: " + prediction.getMessage());
        System.out.println();
    }

    /**
     * Generates and displays a tabular report for the cleaned data.
     *
     * @param cleanedData The cleaned data.
     * @param reportController The controller responsible for generating reports.
     */
    private static void generateReport(List<DataPoint> cleanedData, ReportController reportController) {
        System.out.println("===================================");
        System.out.println("=== Section 4: Tabular Report ===");
        System.out.println("===================================");
        String report = reportController.generateReport(cleanedData);
        System.out.println(report);
    }

    /**
     * Analyzes the cleaned data to extract key statistics.
     *
     * @param cleanedData The cleaned data.
     * @param statisticsService The service used for analyzing data.
     */
    private static void analyzeData(List<DataPoint> cleanedData, DataStatisticsService statisticsService) {
        System.out.println("===================================");
        System.out.println("=== Section 5: Data Analysis ===");
        System.out.println("===================================");
        double average = statisticsService.calculateAverage(cleanedData);
        double max = statisticsService.findMax(cleanedData);
        double min = statisticsService.findMin(cleanedData);
        double range = statisticsService.calculateRange(cleanedData);

        System.out.println("Average Value: " + average);
        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
        System.out.println("Range: " + range);
        System.out.println();
    }

    /**
     * Utility method for printing data points to the console.
     *
     * @param title Title of the data being displayed.
     * @param dataPoints List of {@link DataPoint} objects to print.
     */
    private static void printDataPoints(String title, List<DataPoint> dataPoints) {
        System.out.println(title);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (DataPoint dp : dataPoints) {
            System.out.printf("ID: %d, VALUE: %.2f, TIMESTAMP: %s%n",
                    dp.getId(), dp.getValue(), dateFormat.format(new Date(dp.getTimestamp())));
        }
        System.out.println();
    }
}