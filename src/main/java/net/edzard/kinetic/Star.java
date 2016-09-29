package net.edzard.kinetic;

/**
 * A star shape.
 * Stars are defined by an outer and inner radius and a number of points. 
 * @author Ed
 */
public class Star extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Star() {}
	
	/**
	 * Retrieve the outer radius of this star shape.
	 * @return The outer radius
	 */
	public final native double getOuterRadius() /*-{
		return this.getOuterRadius();
	}-*/;

	/**
	 * Assign the outer radius of this star shape.
	 * @param radius An outer radius value
	 */
	public final native void setOuterRadius(double radius) /*-{
		this.setOuterRadius(radius);
	}-*/;
	
	/**
	 * Retrieve the inner radius of this star shape.
	 * @return The inner radius
	 */	
	public final native double getInnerRadius() /*-{
		return this.getInnerRadius();
	}-*/;
	
	/**
	 * Assign the inner radius of this star shape.
	 * @param radius An inner radius value
	 */
	public final native void setInnerRadius(double radius) /*-{
		this.setInnerRadius(radius);
	}-*/;
	
	/**
	 * Retrieve the number of points for this star shape.
	 * @return The number of points
	 */
	public final native int getNumPoints() /*-{
		return this.getNumPoints();
	}-*/;
	
	/**
	 * Assign a number of points for this star shape.
	 * @param number A number of points
	 */
	public final native void setNumPoints(int number) /*-{
		this.setNumPoints(number);
	}-*/;
}
