package net.edzard.kinetic;

/**
 * A shape that draws paths defined using the SVG standard.
 * * A SVG path string is made up from path commands (see <a href="http://www.w3.org/TR/SVG/paths.html">W3C SVG 1.1 TR</a>).
 * @author Ed 
 */
public class PathSVG extends Shape {

	/** Protected default Ctor keeps GWT happy */
	protected PathSVG() {}
	
	/**
	 * Retrieve the SVG Path string.
	 * @return The path string
	 */
	public final native String getData() /*-{
		return this.getData();
	}-*/;
	
	/**
	 * Assign a SVG path string.
	 * @param data The new path string
	 */
	public final native void setData(String data) /*-{
		this.setData(data);
	}-*/;
}
