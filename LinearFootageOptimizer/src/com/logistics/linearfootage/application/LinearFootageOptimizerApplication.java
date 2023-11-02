/**
 * LinearFootageOptimizerApplication serves as the entry point for the
 * Linear Footage Optimizer application. This class contains the main
 * method that initiates and runs the application.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-01
 */

package com.logistics.linearfootage.application;

import java.util.ArrayList;
import java.util.List;

import com.logistics.linearfootage.input.InputDataGenerator;
import com.logistics.linearfootage.model.LineItem;
import com.logistics.linearfootage.util.LinearFootageOptimizer;

public class LinearFootageOptimizerApplication {

	/**
	 * The main method of the application. It is called when the program is
	 * executed.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		
		List<LineItem> lineItems = new ArrayList<>();
		
		InputDataGenerator inputDataGenerator = new InputDataGenerator();
		
		// TODO: Added for testing. Need to remove below print statements and create a separate test class for input simulation.
		
		/*
		 * Commenting out input simulation using random values.
		lineItems = inputDataGenerator.generateInputData(20);
		*/
		
		// Populating lineItems list as per the given example for testing.
        // Example 1:  1 pallet @ 48 L x 48 W x 32 H is 2 linear feet
        lineItems.add(new LineItem(48, 48, 32, 0, false, false));

        // Example 2: 2 pallets @ 48 L x 48 W x 32 H is 4 linear feet
        lineItems.add(new LineItem(48, 48, 32, 0, false, false));
        lineItems.add(new LineItem(48, 48, 32, 0, false, false));

        // Example 3: 2 pallets @ 48 L x 48 W x 32 H, stackable is 2 linear feet
        lineItems.add(new LineItem(48, 48, 32, 0, true, false));
        lineItems.add(new LineItem(48, 48, 32, 0, true, false));

        // Example 4: 1 pallet @ 48 L x 62 W x 32 H is 4 linear feet
        lineItems.add(new LineItem(48, 62, 32, 0, false, false));

        // Example 5: 1 pallet @ 48 L x 62 W x 32 H, turnable is 3 linear feet
        lineItems.add(new LineItem(48, 62, 32, 0, false, true));
        
		
        // Print the LineItems
        for (LineItem item : lineItems) {
            System.out.println("LineItem Details:");
            System.out.println("Length: " + item.getLengthInches() + " inches");
            System.out.println("Width: " + item.getWidthInches() + " inches");
            System.out.println("Height: " + item.getHeightInches() + " inches");
            System.out.println("Weight: " + item.getWeightLbs() + " lbs");
            System.out.println("Stackable: " + item.isStackable());
            System.out.println("Turnable: " + item.isTurnable());
            System.out.println();
        }
        
        LinearFootageOptimizer linearFootageOptimizer = new LinearFootageOptimizer();
      //List<LineItem> optimizedLineItems = linearFootageOptimizer.optimizeLinearFootage(lineItems);
        

	}

}
