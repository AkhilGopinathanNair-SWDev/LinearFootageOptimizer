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

	/**
	 * Calculate the linear footage of a list of LineItems based on given truck
	 * dimensions.
	 *
	 * @param lineItems         List of LineItem objects to be considered for linear
	 *                          footage calculation.
	 * @param truckWidthInches  Width of the truck or trailer in inches.
	 * @param truckHeightInches Height of the truck or trailer in inches.
	 * @return The calculated linear footage as an integer.
	 */
	public int calculateLinearFootage(List<LineItem> lineItems, int truckWidthInches, int truckHeightInches) {
		double totalLinearFootage = 0.0;
		double totalWidthInches = 0.0;
		//Flag to check if we have already stacked an item over another item
		boolean alreadyStacked = false;
		//Flag to check if we have already placed an item in the same row
		boolean firstColumn = true;

		for (LineItem item : lineItems) {
			double itemLinearFootage = calculateItemLinearFootage(item);

			// Reset the total width if it exceeds the truck's half width.
			if (totalWidthInches == truckWidthInches) {
				totalWidthInches = 0;
			}

			// Check if the item can be placed within the remaining truck width.
			if (totalWidthInches + item.getWidthInches() <= truckWidthInches / 2) {
				totalWidthInches += item.getWidthInches();
			} else {
				totalWidthInches = truckWidthInches; // Takes up entire width
			}

			// Calculate the linear footage based on stackability and item dimensions.
			if (!item.isStackable()) {
				if (item.getWidthInches() > truckWidthInches / 2 && firstColumn) {
					// If it takes up more than 50% width, consider it taking up the entire width.
					totalWidthInches = truckWidthInches;
					totalLinearFootage += itemLinearFootage;
				} else {
					totalLinearFootage += itemLinearFootage / 2;
				}
			} else {
				if (IsAllowedToStack(lineItems, item, truckHeightInches)) {
					if (alreadyStacked) {
						totalLinearFootage += itemLinearFootage / 2;
					}
					alreadyStacked = true;
				} else {
					totalLinearFootage += itemLinearFootage / 2;
					alreadyStacked = false;
				}
			}

			firstColumn = !firstColumn;
		}

		// Round the result to the next whole number.
		int roundedLinearFootage = (int) Math.ceil(totalLinearFootage);

		return roundedLinearFootage;
	}

	/**
	 * Calculate the linear footage of a LineItem.
	 *
	 * @param item The LineItem for which to calculate linear footage.
	 * @return The linear footage for the LineItem in feet.
	 */
	public double calculateItemLinearFootage(LineItem item) {
		// Calculate linear footage based on the length (in feet).
		double linearFootage = (item.getLengthInches() / 12.0);
		return linearFootage;
	}

	/**
	 * Check if an item is allowed to be stacked on top of another item.
	 *
	 * @param lineItems         List of LineItem objects.
	 * @param currentItem       The LineItem currently being evaluated.
	 * @param truckHeightInches Height of the truck or trailer in inches.
	 * @return True if the item is allowed to be stacked, otherwise false.
	 */
	public boolean IsAllowedToStack(List<LineItem> lineItems, LineItem currentItem, int truckHeightInches) {
		if (currentItem.isStackable()) {
			int currentIndex = lineItems.indexOf(currentItem);

			if (currentIndex > 0) {
				// Ensure we are not at the beginning of the list.
				LineItem itemBehind = lineItems.get(currentIndex - 1);

				// Check if the item behind is stackable, has the same width, and fits within
				// truck height.
				if (itemBehind.isStackable() && itemBehind.getWidthInches() == currentItem.getWidthInches()
						&& (currentItem.getHeightInches() + itemBehind.getHeightInches()) < truckHeightInches) {
					return true;
				}
			}
		}
		return false;
	}
}
