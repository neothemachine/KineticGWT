package net.edzard.kinetic;

import com.google.gwt.canvas.dom.client.Context2d;

/**
 * A layer object.
 * Layers contain nodes. Multiple layers can be assigned to a stage. Each will be drawn individually and combined into a single overall drawing.
 * By restricting shapes to certain layers, update operations can be kept to a minimum, which is good for performance.
 * @author Ed
 */
public class Layer extends Container {

	/** Protected Ctor keeps GWT happy */
	protected Layer() {}

	/**
	 * Clear this layer.
	 */
	public final native void clear() /*-{
		this.clear();
	}-*/;
	
	/**
	 * Assign a callback handler for execution after each drawing operation.
	 * @param callback The callback handler to execute
	 */
	public final native void setAfterDrawHandler(Runnable callback) /*-{
		this.afterDraw(function() {
		    callback.@java.lang.Runnable::run()();
		});
	}-*/; 

	/**
	 * Assign a callback handler for execution before each drawing operation.
	 * @param callback The callback handler to execute
	 */
	public final native void setBeforeDrawHandler(Runnable callback) /*-{
		this.afterDraw(function() {
		    callback.@java.lang.Runnable::run()();
		});
	}-*/; 

	/**
	 * Retrieves the throttle value for animations on this layer object.
	 * The throttle value influences how often drawing operations are executed.
	 * @return The throttle value in milliseconds.
	 */
	public final native int getThrottle()  /*-{
		return this.getThrottle();
	}-*/;
	
	/**
	 * Assign a throttle value for animation on this layer object.
	 * The throttle value influences how often drawing operations are executed.
	 * @param throttle The throttle value in milliseconds.
	 */
	public final native void setThrottle(int throttle) /*-{
		this.setThrottle(throttle);
	}-*/;

	public final native Canvas getCanvas() /*-{
		return this.getCanvas();
	}-*/;
	
	public final native Context2d getContext() /*-{
		return this.getCanvas().getContext();
	}-*/;
}
