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



    /**
     * Gets the ID of the data point.
     *
     * @return The unique identifier of the data point.
     */
    public int getId() {
        return id;
    }


    /**
     * Gets the value of the data point.
     *
     * @return The numerical value of the data point.
     */
    public double getValue() {
        return value;
    }


    /**
     * Gets the timestamp of the data point.
     *
     * @return The time at which the data point was recorded, in milliseconds.
     */
    public long getTimestamp() {
        return timestamp;
    }


    /**
     * Converts the data point to a readable string format.
     *
     * @return A string representation of the data point, including its ID, value, and timestamp.
     */
    @Override
    public String toString() {
        return "DataPoint{id=" + id + ", value=" + value + ", timestamp=" + timestamp + "}";
    }
}