package net.edzard.kinetic;

import com.google.gwt.resources.client.ImageResource;

/**
 * An image shape.
 * @author Ed
 */
public class Image extends Shape {

	/** Protected ctor keeps GWT happy */
	protected Image() {}
	
	/**
	 * Retrieve the image object of the image shape.
	 * @return The image object
	 */
	public final native com.google.gwt.user.client.ui.Image getImage() /*-{
		return @com.google.gwt.user.client.ui.Image::new(Lcom/google/gwt/dom/client/Element;)(this.getImage())
	}-*/;
	
	/**
	 * Assign an image resource to this image shape.
	 * Automatically sets the image extents.
	 * @param res The resource to use for the image
	 */
	public final void setImage(ImageResource res) {
		com.google.gwt.user.client.ui.Image img = new com.google.gwt.user.client.ui.Image(res.getSafeUri());
		setImage(img);
		setWidth(res.getWidth());
		setHeight(res.getHeight());
	}

	/**
	 * Assign an image object to thus image shape.
	 * @param img The image object to use. Does not support picture inlining, so be careful where you get the picture from.
	 */
	// Does not support picture inlining
	private final native void setImage(com.google.gwt.user.client.ui.Image img) /*-{
		this.setImage(img.@com.google.gwt.user.client.ui.Image::getElement()());
	}-*/;
	
	/**
	 * Retrieve the image shape extents.
	 * @return The image shape extents. The <emph>x</emph> component contains the horizontal size, whereas the <emph>y</emph> component contains the vertical size. Surprise. 
	 */
	public final Vector2d getSize() {
		return new Vector2d(getWidth(), getHeight());
	}
	
	/**
	 * Assign the image shape extents.
	 * @param size The image extents. The <emph>x</emph> component contains the horizontal size, whereas the <emph>y</emph> component contains the vertical size.
	 */
	public final void setSize(Vector2d size) {
		setWidth(size.x);
		setHeight(size.y);
	}
	
	/**
	 * Retrieve the cropping area for the image shape.
	 * @return The cropping area. The area is defined in coordinates relative to the image shape origin.
	 */
	public final native Box2d getCrop() /*-{
		var box = @net.edzard.kinetic.Box2d::new()();
		box.@net.edzard.kinetic.Box2d::left = this.getCrop().x;
		box.@net.edzard.kinetic.Box2d::top = this.getCrop().y;
		box.@net.edzard.kinetic.Box2d::right = this.getCrop().x + this.getCrop().width;
		box.@net.edzard.kinetic.Box2d::bottom = this.getCrop().y + this.getCrop().height;
		return box;
	}-*/;

	/**
	 * Assing a cropping area to the image shape.
	 * @param box The cropping area. The area is defined in coordinates relative to the image shape origin.
	 */
	public final native void setCrop(Box2d box) /*-{
		this.setCrop({
			x: box.@net.edzard.kinetic.Box2d::left,
			y: box.@net.edzard.kinetic.Box2d::top,
			width: box.@net.edzard.kinetic.Box2d::right - box.@net.edzard.kinetic.Box2d::left,
			height: box.@net.edzard.kinetic.Box2d::bottom - box.@net.edzard.kinetic.Box2d::top
		});
	}-*/;
}
