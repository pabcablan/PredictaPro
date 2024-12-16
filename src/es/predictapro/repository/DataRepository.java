package es.predictapro.repository;

import es.predictapro.model.DataPoint;
import java.util.List;

/**
 * DataRepository defines the contract for data storage and retrieval operations.
 * <p>
 * This interface abstracts the underlying data storage mechanism, allowing flexibility
 * in how data is stored (e.g., in-memory, database, or external APIs).
 * </p>
 */
public interface DataRepository {

    /**
     * Retrieves all stored data points.
     * <p>
     * This method should return a list containing all the {@link DataPoint} objects
     * stored in the repository.
     * </p>
     *
     * @return A list of {@link DataPoint} objects.
     */
    List<DataPoint> getAllData();

    /**
     * Saves a new data point to the repository.
     * <p>
     * This method allows adding a new {@link DataPoint} to the repository's storage.
     * Implementations should define how the data is persisted.
     * </p>
     *
     * @param dataPoint The {@link DataPoint} object to be saved.
     */
    void saveData(DataPoint dataPoint);
}
