package net.edzard.kinetic;

/**
 * An elliptical shape.
 * @author Ed
 */
public class Ellipse extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected Ellipse() {}
	
	/**
	 * Retrieve this ellipse's radius.
	 * @return The radius (x and y component)
	 */
	public final native Vector2d getRadius() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getRadius().x, this.getRadius().y);
	}-*/;

	/**
	 * Assign the ellipse's radius.
	 * @param radius The new radius value (x and y component)
	 */
	public final native void setRadius(Vector2d radius) /*-{
		this.setRadius([radius.@net.edzard.kinetic.Vector2d::x, radius.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
}
