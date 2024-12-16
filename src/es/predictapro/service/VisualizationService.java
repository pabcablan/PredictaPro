package es.predictapro.service;

import es.predictapro.model.DataPoint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * VisualizationService provides methods for generating visual representations of data.
 * <p>
 * This service creates tabular reports that display data points in a structured and
 * human-readable format.
 * </p>
 */
public class VisualizationService {

    /**
     * Generates a tabular report from a list of data points.
     * <p>
     * The report includes:
     * - The ID of each data point.
     * - The value of the data point.
     * - A formatted timestamp of when the data was recorded.
     * <p>
     * If the input list is null or empty, a message indicating no data is returned.
     * </p>
     *
     * @param data A list of {@link DataPoint} objects to be displayed in the report.
     * @return A {@link String} representing the tabular report.
     */
    public String generateReport(List<DataPoint> data) {
        // Handle null or empty data input
        if (data == null || data.isEmpty()) {
            return "No data available to generate the report.";
        }

        // Initialize a StringBuilder for the report
        StringBuilder table = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Add table header
        table.append("ID  | VALUE    | TIMESTAMP\n");
        table.append("-------------------------------\n");

        // Add table rows for each data point
        for (DataPoint dp : data) {
            String timestamp = dateFormat.format(new Date(dp.getTimestamp()));
            table.append(dp.getId()).append("   | ")
                    .append(String.format("%.2f", dp.getValue())).append("   | ")
                    .append(timestamp).append("\n");
        }

        // Return the complete table as a string
        return table.toString();
    }
}
