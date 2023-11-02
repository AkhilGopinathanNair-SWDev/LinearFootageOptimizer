/**
 * Represents a Linear Footage Result in the context of logistics and freight.
 * This class encapsulates the rounded linear footage value and a list of LineItems,
 * providing a summary of dimensions, weight, and properties of a shipment unit.
 * The rounded linear footage represents the total length of items in linear feet,
 * while the LineItems provide detailed information about individual items within the shipment.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-02
 */

package com.logistics.linearfootage.model;

import java.util.List;

public class LinearFootageResult {
	private int roundedLinearFootage;
	private List<LineItem> lineItems;

	public LinearFootageResult(int roundedLinearFootage, List<LineItem> lineItems) {
		this.roundedLinearFootage = roundedLinearFootage;
		this.lineItems = lineItems;
	}

	public LinearFootageResult() {
	}

	public int getRoundedLinearFootage() {
		return roundedLinearFootage;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}
}
