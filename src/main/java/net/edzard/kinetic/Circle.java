package net.edzard.kinetic;

/**
 * A circular shape.
 * @author Ed
 */
public class Circle extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Circle() {}
	
	/**
	 * Retrieve this circle's radius.
	 * @return The radius
	 */
	public final native double getRadius() /*-{
		return this.getRadius();
	}-*/;

	/**
	 * Assign a radius.
	 * @param radius The new radius value
	 */
	public final native void setRadius(double radius) /*-{
		this.setRadius(radius);
	}-*/;
}
