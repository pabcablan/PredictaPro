package es.predictapro.model;


/**
 * DataPoint represents a single data entry in the system.
 * <p>
 * Each data point consists of:
 * - An ID to uniquely identify the data.
 * - A value representing the data's measurement.
 * - A timestamp indicating when the data was recorded.
 * </p>
 */
public class DataPoint {

    // Unique identifier for the data point.
    private int id;


    // The numerical value associated with this data point.
    private double value;


    // The timestamp indicating when this data point was recorded (in milliseconds).
    private long timestamp;


    /**
     * Constructor for DataPoint.
     *
     * @param id        The unique identifier for this data point.
     * @param value     The numerical value of the data point.
     * @param timestamp The time at which the data point was recorded, in milliseconds.
     */
    public DataPoint(int id, double value, long timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }
}