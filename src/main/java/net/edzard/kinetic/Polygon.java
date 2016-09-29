package net.edzard.kinetic;

import java.util.List;

/**
 * A polygon shape.
 * Polygons are defined by an arbitrary number of points.
 * @author Ed
 */
public class Polygon extends Shape {
	
	/** Protected default Ctor keeps GWT happy */
	protected Polygon() {}
	
	/**
	 * Retrieve a single point of the polygon shape definition.
	 * @param num The index number of the point to retrieve. There are no boundary checks implemented...
	 * @return The position of the point in shape coordinates
	 */
	public final native Vector2d getPoint(int num) /*-{
		var v = this.getPoints()[num];
		return @net.edzard.kinetic.Vector2d::new(DD)(v.x, v.y);
	}-*/;
	
	/**
	 * Change a point already contained in the polygon shape.
	 * @param num The index number of the point to change. It has to exist.
	 * @param position The new position to assign
	 */
	public final native void setPoint(int num, Vector2d position) /*-{
		var vCurrent = this.getPoints()[num];
		vCurrent.x = position.@net.edzard.kinetic.Vector2d::x;
		vCurrent.y = position.@net.edzard.kinetic.Vector2d::y;
	}-*/;
	
	/**
	 * Retrieve the polygon shape definition as a list of points. 
	 * @return A list of points
	 */
	public final native List<Vector2d> getPoints()  /*-{
		var resultList = @java.util.ArrayList::new()();
		var currentPoints = this.getPoints(); // Have to be in [{x,y},{x,y},...] form
		for (var i=0; i < currentPoints.length; ++i) {
			var vec = @net.edzard.kinetic.Vector2d::new(DD)(currentPoints[i].x, currentPoints[i].y);
			resultList.@java.util.ArrayList::add(Ljava/lang/Object;)(vec);
		} 
		return resultList;
	}-*/;

	/**
	 * Set the polygon shape using a number of points.
	 * @param givenPoints A list of points
	 */
	public final native void setPoints(List<Vector2d> givenPoints) /*-{
		var points = [];
		var it = givenPoints.@java.util.List::iterator()();
		while (it.@java.util.Iterator::hasNext()()) {
			var vec = it.@java.util.Iterator::next()();
			points.push({
				x: vec.@net.edzard.kinetic.Vector2d::x,
				y: vec.@net.edzard.kinetic.Vector2d::y
			});
		}  
		this.setPoints(points);
	}-*/;
}
