package net.edzard.kinetic;

/**
 * A regular polygon.
 * Regular polygons are defined using a radius and a number of sides.
 * @author Ed
 */
public class RegularPolygon extends Shape {

	/** Protected default Ctor keeps GWT happy */ 
	protected RegularPolygon() {}
	
	/**
	 * Retrieve this regular polygon's radius.
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
	
	/**
	 * Retrieve the number of sides for this regular polygon shape.
	 * @return The number of sides
	 */
	public final native int getSides() /*-{
		return this.getSides();
	}-*/;
	
	/**
	 * Assigns a number of sides.
	 * @param sides A new number of sides.
	 */
	public final native void setSides(int sides) /*-{
		this.setSides(sides);
	}-*/;
}
