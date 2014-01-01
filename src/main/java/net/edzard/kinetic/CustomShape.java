package net.edzard.kinetic;

/**
 * A custom shape.
 * The shape is defined using a given path object. 
 * Custom shapes are CPU intensive to render.
 * @author Ed
 */
public class CustomShape extends Shape { 
	
	/** Protected Ctor keeps GWT happy */
	protected CustomShape() {}

	/**
	 * Retrieve the custom shape's path.
	 * @return The path
	 */
	public final native Path getPath() /*-{
		return this.path;
	}-*/;
	
	/**
	 * Assign a path to the custom shape.
	 * @param path The new path
	 */
	public final native void setPath(Path path) /*-{
		this.path = path;
	}-*/;
}
