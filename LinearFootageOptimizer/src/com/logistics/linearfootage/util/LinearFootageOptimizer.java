/**
 * A utility class for optimizing linear footage in the context of logistics and freight.
 * This class provides methods for calculating the rounded linear footage of a list of LineItems
 * based on their dimensions and ensuring that the total linear footage does not exceed the
 * specified truck height and width.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-01
 */

package com.logistics.linearfootage.util;

import java.util.List;

import com.logistics.linearfootage.model.LineItem;

public class LinearFootageOptimizer {

	public int calculateLinearFootage(List<LineItem> lineItems, int truckWidthInches, int truckHeightInches) {
		double totalLinearFootage = 0.0;
        double totalWidthInches = 0.0;

        for (LineItem item : lineItems) {
            if (totalWidthInches > truckWidthInches * 0.5) {
                totalWidthInches = truckWidthInches; // Takes up entire width
            }

            double itemLinearFootage = calculateItemLinearFootage(item);
            if (totalWidthInches + item.getWidthInches() <= truckWidthInches) {
                totalLinearFootage += itemLinearFootage;
                totalWidthInches += item.getWidthInches();
            } else {
                // If adding the item exceeds the width, start a new row
                totalWidthInches = item.getWidthInches();
                totalLinearFootage += itemLinearFootage;
            }

            if (totalLinearFootage * 12 > truckHeightInches) {
                totalLinearFootage = (totalLinearFootage * 12) / 2; // Divide by 2 if more than 50% height
            }
        }

        // Round the result to the next whole number
        int roundedLinearFootage = (int) Math.ceil(totalLinearFootage);

        return roundedLinearFootage;
	}

	public double calculateItemLinearFootage(LineItem item) {
        double linearFootage = (item.getLengthInches() / 12.0);
        return linearFootage;
	}

}
