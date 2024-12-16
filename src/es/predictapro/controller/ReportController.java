package es.predictapro.controller;


import es.predictapro.model.DataPoint;
import es.predictapro.service.VisualizationService;


import java.util.List;


/**
 * ReportController handles the generation of reports based on input data.
 * <p>
 * This controller provides a simple interface for generating visual reports
 * by delegating the task to the {@link VisualizationService}.
 * </p>
 */
public class ReportController {


    // Service responsible for creating visual reports.
    private final VisualizationService visualizationService;


    /**
     * Constructor for ReportController.
     *
     * @param visualizationService The service used to generate reports.
     */
    public ReportController(VisualizationService visualizationService) {
        this.visualizationService = visualizationService;
    }
}