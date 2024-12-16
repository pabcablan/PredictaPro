package es.predictapro.repository;

import es.predictapro.model.DataPoint;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseRepository provides a basic in-memory implementation of the {@link DataRepository} interface.
 * <p>
 * This repository is used to store and retrieve {@link DataPoint} objects.
 * In this implementation, the data is stored in a simple {@link ArrayList}.
 * </p>
 */
public class DatabaseRepository implements DataRepository {

    // A simple in-memory database to store DataPoint objects.
    private List<DataPoint> database = new ArrayList<>();

    /**
     * Retrieves all stored data points.
     *
     * @return A list of all {@link DataPoint} objects in the database.
     */
    @Override
    public List<DataPoint> getAllData() {
        return database;
    }

    /**
     * Saves a new data point to the database.
     *
     * @param dataPoint The {@link DataPoint} object to be saved.
     */
    @Override
    public void saveData(DataPoint dataPoint) {
        database.add(dataPoint);
    }
}
