package net.edzard.kinetic;

import java.util.List;

/**
 * Central class for drawing with Kinetic.
 * The stage contains everything that is drawn. It consists of layers, which in turn contain the shapes.
 * @author Ed
 * @see Layer
 */
public class Stage extends Container {
	
	/**
	 * Callback interface for receiveing a data URL string.
	 * @author Ed
	 */
	public interface DataUrlTarget {
		/**
		 * Receive a data URL string.
		 * @param url The data URL string
		 */
		public void receive(String url);
	}
	
	/** Protected default Ctor keeps GWT happy */
	protected Stage() {}

	/**
	 * Add a new layer to the stage.
	 * @param layer The new layer
	 */
	public final native void add(final Layer layer) /*-{
	    this.add(layer);
	  }-*/;

	/**
	 * Clears the stage.
	 * All layers are cleared. 
	 */
	public final native void clear() /*-{
		this.clear();
	}-*/;
	
	/**
	 * Draws the hit graphs of contained layers.
	 */
	public final native void drawHit() /*-{
		this.drawHit();
	}-*/;
	
	/**
	 * Starts any animation on this stage.
	 */
	public final native void start() /*-{
		this.start();
	}-*/;
	
	/**
	 * Stops any animation on this stage.
	 */
	public final native void stop() /*-{
		this.stop();
	}-*/;
	
	/**
	 * Retrieve the user position.
	 * This is either a mouse or a touch position. 
	 * @return The last user position
	 */
	public final native Vector2d getPointerPosition() /*-{
		var pos = this.getPointerPosition(); //TODO: Why does it have a parameter (evt)?
		if (pos != null) return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
		else return null;
	}-*/;
	
	/**
	 * Get all shapes that intersect with a given point.
	 * This works across layers
	 * @param position Position to check
	 * @return A list of shapes
	 */
	public final native List<Shape> getIntersections(Vector2d position) /*-{
		var intersections = this.getIntersections({x: position.@net.edzard.kinetic.Vector2d::x, y: position.@net.edzard.kinetic.Vector2d::y});
		var result = @java.util.ArrayList::new()();
		for (i=0; i < intersections.length; ++i) {
			result.@java.util.ArrayList::add(Ljava/lang/Object;)(intersections[i]);
		}
		return result;
	}-*/;
	
	/**
	 * Retrieve the size of the stage.
	 * @return The stage's size (x component is width, y component is height)
	 */
	public final Vector2d getSize() {
		return new Vector2d(getWidth(), getHeight());
	}
	
	/**
	 * Assign new size to stage.
	 * @param size The stage's new size (x component is width, y component is height)
	 */
	public final void setSize(Vector2d size) {
		setWidth((int)size.x);
		setHeight((int)size.y);
	}
	
	/**
	 * Retrieve a URL to the stage's data.
	 * The data url will refer to a PNG image
	 * The data url will be passed by means of a callback
	 * @param callback A callback handler that will receive the data url
	 */
	public final native void toDataURL(DataUrlTarget callback) /*-{
		this.toDataURL(function(dataUrl, mimeType, quality) {
		    callback.@net.edzard.kinetic.Stage.DataUrlTarget::receive(Ljava/lang/String;)(dataUrl);
		});
	}-*/;

	/**
	 * Retrieves the throttle value for animations on this stage object.
	 * The throttle value influences how often drawing operations are executed.
	 * @return The throttle value in milliseconds.
	 */
	public final native int getThrottle()  /*-{
		return this.getThrottle();
	}-*/;
	
	/**
	 * Assign a throttle value for animation on this stage object.
	 * The throttle value influences how often drawing operations are executed.
	 * @param throttle The throttle value in milliseconds.
	 */
	public final native void setThrottle(int throttle) /*-{
		this.setThrottle(throttle);
	}-*/;
}
