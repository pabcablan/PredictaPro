package es.predictapro.config;

import es.predictapro.repository.DataRepository;
import es.predictapro.repository.DatabaseRepository;
import es.predictapro.service.*;
import es.predictapro.service.*;

/**
 * AppConfig is a configuration class.
 * It provides methods to get instances of services and repositories
 * used across the application.
 */
public class AppConfig {

    /**
     * Returns an instance of the DataRepository.
     *
     * @return An implementation of {@link DataRepository}.
     */
    public static DataRepository getDataRepository() {
        return new DatabaseRepository();
    }

    /**
     * Returns an instance of the DataCleaningService.
     *
     * @return {@link DataCleaningService} instance.
     */
    public static DataCleaningService getDataCleaningService() {
        return new DataCleaningService();
    }

    /**
     * Returns an instance of the PredictionService.
     *
     * @return {@link PredictionService} instance.
     */
    public static PredictionService getPredictionService() {
        return new PredictionService();
    }

    /**
     * Returns an instance of the VisualizationService.
     *
     * @return {@link VisualizationService} instance.
     */
    public static VisualizationService getVisualizationService() {
        return new VisualizationService();
    }

    /**
     * Returns an instance of the DataValidationService.
     *
     * @return {@link DataValidationService} instance.
     */
    public static DataValidationService getDataValidationService() {
        return new DataValidationService();
    }

    /**
     * Returns an instance of the getDataStatisticsService.
     *
     * @return {@link DataStatisticsService} instance.
     */
    public static DataStatisticsService getDataStatisticsService() {
        return new DataStatisticsService();
    }
}
