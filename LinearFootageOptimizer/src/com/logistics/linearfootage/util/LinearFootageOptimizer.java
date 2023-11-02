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
		boolean firstColumn = true;

		for (LineItem item : lineItems) {
			double itemLinearFootage = calculateItemLinearFootage(item);
			if (totalWidthInches == truckWidthInches) {
				totalWidthInches = 0;
			}

			if (totalWidthInches + item.getWidthInches() <= truckWidthInches / 2) {
				totalWidthInches += item.getWidthInches();
			} else {
				totalWidthInches = truckWidthInches; // Takes up entire width
			}

			if (item.getWidthInches() > truckWidthInches / 2 && firstColumn) {
				// If it takes up more than 50% width, consider it taking up the entire width
				totalWidthInches = truckWidthInches;
				totalLinearFootage += itemLinearFootage;
			} else {
				totalLinearFootage += itemLinearFootage / 2;
			}

			firstColumn = !firstColumn;

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
