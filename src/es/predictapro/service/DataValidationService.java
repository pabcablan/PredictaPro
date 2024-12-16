package es.predictapro.service;

import es.predictapro.model.DataPoint;
import es.predictapro.exception.ValidationException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DataValidationService validates raw data to ensure its quality and consistency.
 * <p>
 * This service checks:
 * - If the data list is null or empty.
 * - If the data contains invalid values (e.g., NaN or infinite).
 * - If there are duplicate IDs in the data.
 * </p>
 */
public class DataValidationService {

    /**
     * Validates the given list of data points.
     * <p>
     * Steps:
     * 1. Ensures the data list is not null or empty.
     * 2. Checks for invalid values such as NaN (Not a Number) or infinite values.
     * 3. Verifies that all data points have unique IDs.
     * </p>
     *
     * @param data A list of {@link DataPoint} objects to validate.
     * @throws ValidationException if the data is null, empty, contains invalid values, or has duplicate IDs.
     */
    public void validateData(List<DataPoint> data) {
        // Step 1: Check if the data list is null or empty
        if (data == null || data.isEmpty()) {
            throw new ValidationException("The data list cannot be null or empty.");
        }

        // Step 2: Check for invalid values (NaN or infinite)
        List<DataPoint> invalidValues = new ArrayList<>();
        for (DataPoint dp : data) {
            if (Double.isNaN(dp.getValue()) || Double.isInfinite(dp.getValue())) {
                invalidValues.add(dp);
            }
        }
        if (!invalidValues.isEmpty()) {
            throw new ValidationException("Invalid values (NaN or Infinite) found in the data.");
        }

        // Step 3: Check for duplicate IDs
        Set<Integer> uniqueIds = new HashSet<>();
        for (DataPoint dp : data) {
            if (!uniqueIds.add(dp.getId())) { // add() returns false if the ID is already in the set
                throw new ValidationException("Duplicate IDs found in the data.");
            }
        }

        // Validation completed successfully
        System.out.println("Validation completed: No invalid values or duplicate IDs found.");
    }
}
