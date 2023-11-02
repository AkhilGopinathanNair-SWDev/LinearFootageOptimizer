/**
 * Represents a Line Item in the context of logistics and freight.
 * This class encapsulates the dimensions, weight, and properties of a shipment unit,
 * such as length, width, height, weight, stackability, and turnability.
 * It is used to optimize space allocation in logistics and transportation.
 *
 * @author Akhil Gopinathan Nair
 * @version 1.0
 * @since 2023-11-01
 */

package com.logistics.linearfootage;

public class LineItem {

	private int lengthInches; // Length of the shipment in inches
	private int widthInches; // Width of the shipment in inches
	private int heightInches; // Height of the shipment in inches

	private int weightLbs; // Weight of the shipment in pounds

	private boolean stackable; // Indicates if the item is stackable
	private boolean turnable; // Indicates if the item is turnable

	/**
	 * Initializes a new LineItem instance with default values.
	 */
	public LineItem() {
		// Default constructor implementation
	}

	/**
	 * Creates a new LineItem instance with the given dimensions and properties.
	 *
	 * @param lengthInches - Length in inches.
	 * @param widthInches  - Width in inches.
	 * @param heightInches - Height in inches.
	 * @param stackable    - Indicates if the item is stackable.
	 * @param turnable     - Indicates if the item is turnable.
	 */
	public LineItem(int lengthInches, int widthInches, int heightInches, int weightLbs, boolean stackable,
			boolean turnable) {
		this.setLengthInches(lengthInches);
		this.setWidthInches(widthInches);
		this.setHeightInches(heightInches);
		this.setWeightLbs(weightLbs);
		this.setStackable(stackable);
		this.setTurnable(turnable);
	}

	/**
	 * @return the lengthInches
	 */
	public int getLengthInches() {
		return lengthInches;
	}

	/**
	 * @param lengthInches the lengthInches to set
	 */
	public void setLengthInches(int lengthInches) {
		this.lengthInches = lengthInches;
	}

	/**
	 * @return the widthInches
	 */
	public int getWidthInches() {
		return widthInches;
	}

	/**
	 * @param widthInches the widthInches to set
	 */
	public void setWidthInches(int widthInches) {
		this.widthInches = widthInches;
	}

	/**
	 * @return the heightInches
	 */
	public int getHeightInches() {
		return heightInches;
	}

	/**
	 * @param heightInches the heightInches to set
	 */
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	/**
	 * @return the weightLbs
	 */
	public int getWeightLbs() {
		return weightLbs;
	}

	/**
	 * @param weightLbs the weightLbs to set
	 */
	public void setWeightLbs(int weightLbs) {
		this.weightLbs = weightLbs;
	}

	/**
	 * @return the stackable
	 */
	public boolean isStackable() {
		return stackable;
	}

	/**
	 * @param stackable the stackable to set
	 */
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	/**
	 * @return the turnable
	 */
	public boolean isTurnable() {
		return turnable;
	}

	/**
	 * @param turnable the turnable to set
	 */
	public void setTurnable(boolean turnable) {
		this.turnable = turnable;
	}

}
