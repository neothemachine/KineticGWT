package net.edzard.kinetic;

/**
 * A rectangular shape.
 * @author Ed
 */
public class Rectangle extends Shape {

	/** Protected default Ctor keeps GWT happy */ 
	protected Rectangle() {}
	
	public final Vector2d getSize() {
	    return new Vector2d(this.getWidth(), this.getHeight());
	}
	
	/**
	 * Retrieve the rectangle shape corner radius.
	 * @return The corner radius
	 */
	public final native double getCornerRadius() /*-{
		return this.getCornerRadius();
	}-*/;
	
	/**
	 * Assign the rectangle shape corner radius.
	 * Yes, we have rounded corners. :-)
	 * @param radius A radius for the rounding of corners
	 */
	public final native void setCornerRadius(double radius) /*-{
		this.setCornerRadius(radius);
	}-*/;
	
	/**
	 * Does this rectangle intersect with another?
	 * Copied and assimilated from StackOverflow answer #2: http://stackoverflow.com/questions/2752349/fast-rectangle-to-rectangle-intersection
	 * @param other The other rectangle
	 */
	public final boolean intersects(Vector2d otherRectAbsPos, Vector2d otherRectSize)
	{
		Vector2d absPosA = getAbsolutePosition();
		Vector2d sizeA = getSize();
		return (absPosA.x <= (otherRectAbsPos.x + otherRectSize.x) && // a.left <= b.right
				otherRectAbsPos.x <= (absPosA.x + sizeA.x) && // b.left <= a.right
				absPosA.y <= (otherRectAbsPos.y + otherRectSize.y) && // a.top <= b.bottom
				otherRectAbsPos.y <= (absPosA.y + sizeA.y) // b.top <= a.bottom
		);
	}
}
