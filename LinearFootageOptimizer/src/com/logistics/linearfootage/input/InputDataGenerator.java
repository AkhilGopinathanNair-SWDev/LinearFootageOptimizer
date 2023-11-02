/**
 * InputDataGenerator is responsible for generating and providing input data for
 * the Linear Footage Optimization application. This class contains methods for
 * creating LineItem objects to simulate input data.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-01
 */

package com.logistics.linearfootage.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.logistics.linearfootage.model.LineItem;

public class InputDataGenerator {

	private Random random = new Random();

	/**
	 * Generates LineItem objects to simulate input data for the application.
	 *
	 * @param itemCount The number of LineItem objects to generate.
	 * @return A list of LineItem objects representing input data.
	 */
	public List<LineItem> generateInputData(int itemCount) {

		List<LineItem> inputItems = new ArrayList<>();

		for (int i = 0; i < itemCount; i++) {

			// Generate random dimensions, weight, and properties for LineItem

			int lengthInches = random.nextInt(100) + 1; // Random length between 1 and 100 inches
			int widthInches = random.nextInt(100) + 1; // Random width between 1 and 100 inches
			int heightInches = random.nextInt(100) + 1; // Random height between 1 and 100 inches
			int weightLbs = random.nextInt(50) + 1; // Random weight between 1 and 50 lbs

			// Generate random properties
			boolean stackable = random.nextBoolean();
			boolean turnable = random.nextBoolean();

			// Create a LineItem object and add it to the list
			LineItem lineItem = new LineItem(lengthInches, widthInches, heightInches, weightLbs, stackable, turnable);
			inputItems.add(lineItem);
		}

		return inputItems;
	}
}
