package net.edzard.kinetic;

import java.util.Arrays;
import java.util.List;

import net.edzard.kinetic.event.EventTypeBasic;
import net.edzard.kinetic.event.IEventListener;
import net.edzard.kinetic.event.IEventTypeEnum;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Base class for all of the Kinetic classes.
 * Contains functionality for:
 * <ul>
 * <li>Event handling
 * <li>Naming
 * <li>Positioning, Rotation and Scaling
 * <li>Visibility
 * </ul>
 * @author Ed
 */
public abstract class Node extends JavaScriptObject {
	
	public enum Attr
	{
		X,
		Y
	}
	
	/**
	 * Protected Ctor.
	 * Makes JSNI (GWT) happy
	 */
	protected Node() {}
	
	/**
	 * Create a simple clone with identical attributes.
	 */
	public native final Node clone() /*-{
		return this.clone();
	}-*/;
	
	/**
	 * Remove and destroy self.
	 */
	public native final void destroy() /*-{
		return this.destroy();
	}-*/;
	
	/**
	 * If used with groups and shapes, the layer is cleared, and just that node is drawn.
	 */
	public native final void draw() /*-{
		this.draw();
	}-*/;
	
	/**
	 * Get stage ancestor.
	 */
	public final native Stage getStage() /*-{
		this.getStage();
	}-*/;
	
	/**
	 * Gets layer ancestor.
	 * @return container layer
	 */
	public native final Layer getLayer() /*-{
		return this.getLayer();
	}-*/;
	
	/**
	 * Gets the parent container which contains this node.
	 * @return parent container
	 */
	public native final Container getParent() /*-{
		return this.getParent();
	}-*/;
	
	/**
	 * Is this node embedded in a kinetic environment?
	 */
	public final boolean isRegistered()
	{
		return getParent() != null;
	}
	
	/**
	 * Gets attribute value for specified key. Can be Kinetic attrs and custom attrs as well.
	 * @param attr the key
	 * @return the value
	 */
	public native final JavaScriptObject getAttr(String attr) /*-{
		return this.getAttr(attr);
	}-*/;
	
	/**
	 * Sets an attribute value for specified key.
	 * Can be used to set Kinetic attrs, or even custom attrs.
	 * TODO: Custom attrs changes can also be subscribed to, just like Kinetic attrs. i.e. shape.on('myAttrChange', ...);
	 * @param attr the key
	 */
	public native final void setAttr(String attr, JavaScriptObject object) /*-{
		return this.setAttr(attr, object);
	}-*/;
	
	/**
	 * Gets the type of this node. One of: "Stage", "Layer", "Group", or "Shape".
	 * @return node type
	 */
	public native final String getNodeType() /*-{
		return this.getType();
	}-*/;
	
	/**
	 * Gets the class name of this node, e.g. "Stage", "Layer", "Circle", "Rect" etc.
	 * @return class name
	 */
	public native final String getClassName() /*-{
		return this.getClassName();
	}-*/;
	
	/**
	 * Gets the width of the node.
	 * @return node Width of the node
	 */
	public native final double getWidth() /*-{
		if (this.getWidth() == "auto") return 0;
		else return this.getWidth();
	}-*/;
	
	/**
	 * Sets the width of the node. Uses bounding boxes around select nodes. For example, to define the size of an ellipse, 
	 * you could set its width and height rather than setting the radius.
	 * @param width pixels in width
	 */
	public native final void setWidth(double width) /*-{
		return this.setWidth(width);
	}-*/;
	
	/**
	 * Gets the width of the node.
	 * @return node Width of the node
	 */
	public native final double getHeight() /*-{
		if (this.getWidth() == "auto") return 0;
		else return this.getHeight();
	}-*/;
	
	/**
	 * Sets the height of the node. Uses bounding boxes around select nodes. For example, to define the size of an ellipse, 
	 * you could set its width and height rather than setting the radius.
	 * @param width pixels in height
	 */
	public native final void setHeight(double height) /*-{
		return this.setHeight(height);
	}-*/;
	
	/**
	 * Retrieve the node's absolute opacity.
	 * @return A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public native final double getAbsoluteOpacity() /*-{
		return this.getAbsoluteOpacity();
	}-*/;
	
	/**
	 * Retrieve the node's absolute position.
	 * @return The position
	 */
	public native final Vector2d getAbsolutePosition() /*-{
		var pos = this.getAbsolutePosition();
		return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
	}-*/;
	
	/**
	 * Set the node's absolute position.
	 * @param position The position
	 */
	public final native void setAbsolutePosition(final Vector2d position) /*-{
		this.setAbsolutePosition(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Retrieve the node's absolute Z index.
	 * @return The z index
	 */
	public native final double getAbsoluteZIndex() /*-{
		return this.getAbsoluteZIndex();
	}-*/;
	
	/**
	 * Retrieve the node's position relative to container.
	 * @return The position
	 */
	public native final Vector2d getPosition() /*-{
		var pos = this.getPosition();
		return @net.edzard.kinetic.Vector2d::new(DD)(pos.x, pos.y);
	}-*/;

	
	/**
	 * Set the node's position relative to container.
	 * @param position The position
	 */
	public final native void setPosition(final Vector2d position) /*-{
		this.setPosition(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Set the node's position relative to container.
	 * @param x A horizontal position
	 * @param y A vertical position
	 */
	public final native void setPosition(double x, double y) /*-{
		this.setPosition(x,y);
	}-*/;
	
	/**
	 * Get horizontal position relative to container.
	 * @return The horizontal position
	 */
	public final native double getX() /*-{
		return this.getX();
	}-*/;

	/**
	 * Set horizontal position relative to container.
	 * @param x The horizontal position
	 */
	public final native void setX(double x) /*-{
		this.setX(x);
	}-*/;

	/**
	 * Get vertical position relative to container.
	 * @param x The vertical position
	 */
	public final native double getY() /*-{
		return this.getY();
	}-*/;

	/**
	 * Set the vertical position relative to container.
	 * @param y The vertical position
	 */
	public final native void setY(double y) /*-{
		this.setY(y);
	}-*/;
	
	/**
	 * Makes this node visible.
	 * Used in conjunction with {@link #hide()}
	 */
	public final native void show() /*-{
		this.show();
	}-*/;
	
	/**
	 * Hides this node.
	 * Used in conjunction with {@link #show()}
	 */
	public final native void hide() /*-{
		this.hide();
	}-*/;
	
	/**
	 * Checks visibility of the node.
	 * @return True, if node is visible.
	 */
	public final native boolean isVisible() /*-{
		return this.isVisible();
	}-*/;
	
	/**
	 * Move the node's position relative to container.
	 * @param position The position
	 */
	public final native void move(final Vector2d position) /*-{
		this.move(position.@net.edzard.kinetic.Vector2d::x, position.@net.edzard.kinetic.Vector2d::y);
	}-*/;
	
	/**
	 * Move the node's position relative to container.
	 * @param x A horizontal position
	 * @param y A vertical position
	 */
	public final native void move(double x, double y) /*-{
		this.move(x,y);
	}-*/;
	
	/**
	 * Move this node into the specified container.
	 * @param newContainer The container to move this node to.
	 */
	public final native void moveTo(Container newContainer) /*-{
		this.moveTo(newContainer);
	}-*/;
	
	/**
	 * Moves the node to the highest Z position.
	 * It will be in front of all of the other nodes on a given layer.
	 * Node needs to belong to a layer.
	 */
	public final native void moveToTop() /*-{
		this.moveToTop();
	}-*/;

	/**
	 * Moves the node to the lowest Z position.
	 * It will be behind all of the other nodes on a given layer.
	 * Node needs to belong to a layer.
	 */
	public final native void moveToBottom() /*-{
		this.moveToBottom();
	}-*/;

	/**
	 * Increases the Z position of the node.
	 * Node needs to belong to a layer.
	 */
	public final native void moveUp() /*-{
		this.moveUp();
	}-*/;

	/**
	 * Decreases the Z position of the node.
	 * Node needs to belong to a layer.
	 */
	public final native void moveDown() /*-{
		this.moveDown();
	}-*/;

	/**
	 * Get the current Z position of the node relative to the container.
	 * Node needs to belong to a layer.
	 * @return The Z position
	 */
	public final native int getZIndex() /*-{
		return this.getZIndex();
	}-*/;

	/**
	 * Sets the Z position of the node.
	 * Node needs to belong to a layer.
	 * @param z A new Z position
	 */
	public final native void setZIndex(int z) /*-{
		this.setZIndex(z);
	}-*/;

	/**
	 * Enable or disable event handling.
	 * @param listening True, if events should be handled. False, otherwise.
	 */
	public final void setListening(boolean listening)
	{
		setListeningPrivate(listening);
		if(isRegistered())
		{
			getStage().drawHit();
		}
	}
	protected final native void setListeningPrivate(boolean listening) /*-{
		this.setListening(listening);
	}-*/;
	
	/**
	 * Check if events are handled.
	 * @return True, if events are handled
	 */
	public final native boolean isListening() /*-{
		return this.getListening();
	}-*/;

	/**
	 * Retrieve a node's unique identifier.
	 * @return The identifier or <emph>null</emph> if not set.
	 */
	public final native String getID() /*-{
		return this.getAttrs().id;
	}-*/;
	
	/**
	 * Set a unique identifier for this node.
	 * @param newID An identifier.
	 */
	public final native void setID(String newID) /*-{
		this.getAttrs().id = newID;
	}-*/;

	/**
	 * Retrieve a node's name.
	 * @return The name or <emph>null</emph> if not set.
	 */	
	public final native String getName() /*-{
		return this.getAttrs().name;
	}-*/;

	/**
	 * Set a name for this node.
	 * Names do not have to be unique - two nodes with the same name can exist.
	 * @param newName A name.
	 */
	public final native void setName(String newName) /*-{
		this.getAttrs().name = newName;
	}-*/;
	
	/**
	 * Retrieve the opacity of the complete node.
	 * @return A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public final native double getOpacity() /*-{
		return this.getOpacity();
	}-*/;

	/**
	 * Set the opacity of the complete node.
	 * @param opacity A value between 0 and 1. 0 is complete transparency and 1 is complete opaque.
	 */
	public final native void setOpacity(double opacity) /*-{
		this.setOpacity(opacity);
	}-*/;

	/**
	 * Retrieve the node's scaling.
	 * @return The two scaling components. The x component holds the horizontal scale, while y holds the vertical scale.
	 */
	public final native Vector2d getScale() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getScale().x, this.getScale().y);
	}-*/;

	/**
	 * Set scaling for the node.
	 * @param scale The two scaling components. The x component holds the horizontal scale, while y holds the vertical scale.
	 */
	public final native void setScale(Vector2d scale) /*-{
		this.setScale([scale.@net.edzard.kinetic.Vector2d::x, scale.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
	
	/**
	 * Retrieve the node's rotation in radians.
	 * @return The rotation
	 */
	public final native double getRotation() /*-{
		return this.getRotation();
	}-*/;

	/**
	 * Set the node's rotation. 
	 * @param rot The rotation in radians
	 */
	public final native void setRotation(double rot) /*-{
		this.setRotation(rot);
	}-*/;
	
	/**
	 * Retrieve the node's center offset.
	 * The center offset is used during transformations (positioning, scaling, rotation)
	 * @return The center offset
	 */
	public final native Vector2d getOffset() /*-{
		return @net.edzard.kinetic.Vector2d::new(DD)(this.getOffset().x, this.getOffset().y);
	}-*/;

	/**
	 * Assign the node's center offset.
	 * The center offset is used during transformations (positioning, scaling, rotation)
	 * @param offset The node center's offset
	 */
	public final native void setOffset(Vector2d offset) /*-{
		this.setOffset([offset.@net.edzard.kinetic.Vector2d::x, offset.@net.edzard.kinetic.Vector2d::y]);
	}-*/;
	
	/**
	 * Enable or disable dragging of the node.  
	 * @param drag True, if the node should be dragable. False, if not.
	 */
	public final native void setDraggable(boolean drag) /*-{
		this.setDraggable(drag);
	}-*/;

	/**
	 * Checks if a node can be dragged.
	 * @return True, in case that the node can be dragged. False, otherwise.
	 */
	public final native boolean isDraggable() /*-{
		return this.getAttrs().draggable;
	}-*/;

	/**
	 * Register an event listener for a single event. 
	 * @param type A single event type to listen for.
	 * @param handler The handler.
	 */
	public final void addEventListener(IEventTypeEnum type, IEventListener handler) {
		addEventListener(Arrays.asList(type), handler);
	}
	
	/**
	 * Register an event listener for a multitude of events.
	 * @param type List of events to listen for
	 * @param handler The handler.
	 */
	public final void addEventListener(List<IEventTypeEnum> eventTypes, IEventListener handler)
	{
		addEventListeners(eventListToString(eventTypes), handler);
	}
	
	/**
	 * Convert a list of event types to a single string, as defined by the KineticJS standard.
	 * @param eventTypes The event types
	 * @return A string of the event types
	 */
	protected final static String eventListToString(List<IEventTypeEnum> eventTypes)
	{
		final StringBuffer sb = new StringBuffer();
		for (IEventTypeEnum type: eventTypes)
		{
			sb.append(type.toNativeEvent()).append(" "); // toLowerCase() would not work with the new Stage events because they contain a capital letter
		}
		return sb.toString().trim();
	}
	
	/**
	 * Add a (possibly) multi-event listener to the node.
	 * @param eventString The string containing events to register.
	 * @param handler The handler to execute.
	 */
	// Seems to be buggy in kineticjs. Always getting mousemove events
	// TODO Maik: It's not buggy, it just fails and then creates too many events due to the failure.
	//             the evt variable is directly from the browser, not from kineticjs, that's why there's
	//             a mismatch between event types
	//             Touch also needs to be handled differently if evt should be used.
	//       quick fix: ignore evt object
	// TODO: SkyCrawl: I may be wrong (haven't tested it) but I think there's not going to be a problem with this anymore. Event system has changed quite a bit.
	protected final native void addEventListeners(String eventString, IEventListener handler) /*-{	
		this.on(eventString, function(evt) {
//			if (evt != null) {
//				console.log(evt.type);
//				var javaEvt = @net.edzard.kinetic.Event::new(Lnet/edzard/kinetic/Event$Type;Lnet/edzard/kinetic/Event$Button;II)(
//					@net.edzard.kinetic.Event.Type::valueOf(Ljava/lang/String;)(evt.type.toUpperCase()),
//					@net.edzard.kinetic.Event.Button::fromInteger(I)(evt.button),
//					evt.offsetX,
//					evt.offsetY
//				);
//				javaEvt.@net.edzard.kinetic.Event::setShape(Lnet/edzard/kinetic/Shape;)(evt.shape);
//				var bubble = handler.@net.edzard.kinetic.Node.EventListener::handle(Lnet/edzard/kinetic/Event;)(javaEvt);
//				evt.cancelBubble = !bubble;
//			} else {
				handler.@net.edzard.kinetic.event.IEventListener::handle(Lnet/edzard/kinetic/event/KineticEvent;)(evt);
//			}
		});
	}-*/;
	
	/**
	 * Remove an event listener from the node.
	 * @param type The event Type to stop listening to
	 */
	public final void removeEventListener(IEventTypeEnum type)
	{
		removeEventListener(Arrays.asList(type));
	}

	/**
	 * Remove an event listener from the node.
	 * @param eventTypes A number of event types to stop listening to
	 */
	// Might be buggy in Kineticjs 	
	public final void removeEventListener(List<IEventTypeEnum> eventTypes)
	{
		removeEventListeners(eventListToString(eventTypes));
	}
	
	/**
	 * Remove listener for specified events from this node.
	 * @param eventTypes A (possibly) number of event types to stop listening to
	 */
	protected final native void removeEventListeners(String eventTypes) /*-{
		this.off(eventTypes);
	}-*/;
	
	/**
	 * Removes this node from its parent but doesn't destroy.
	 */
	public final native void remove() /*-{
		this.remove();
	}-*/;
	
	/**
	 * Simulates the firing of an event.
	 * This will trigger the appropriate listeners with empty event objects.
	 * @param type The event type to simulate
	 */
	public final native void simulate(EventTypeBasic type) /*-{
		this.simulate(type.@net.edzard.kinetic.event.EventSimulated.Type::toString()().toLowerCase());
	}-*/;
	
	/**
	 * Write the current node's definition to JSON.
	 * Doesn't serialize functions and images. These need to be written manually.
	 * @return A JSON representation of the node
	 */
	public final native String toJSON() /*-{
		return this.toJSON();
	}-*/;
	
	/**
	 * Writes the current node's definition to JSON. Only serializes attributes defined in the parameter. Doesn't
	 * serialize functions, images, DOM objects or objects with methods.
	 * 
	 * RED ALERT: this method uses a modified version of kinetic's "toJSON" method (see below) which is not
	 * a part of the standard KineticJS distribution and hence this method is deprecated.
	 * It is safe to use this method with the bundled "dev" version, but beware using it in production with
	 * a "min" version for example. Should you choose to do so, you can always add the modified function
	 * yourselves:
	 * 
	 * toMyJSON: function(attrsToPrint) { return JSON.stringify(this.toObject(), attrsToPrint, '\t'); }
	 * 
	 * @param attrsToPrint attributes to serialize
	 * Recommended default code:
	 * JsArrayString jsonAttrsToSerialize = (JsArrayString) JsArrayString.createArray();
	 * jsonAttrsToSerialize.push("attrs");
	 * jsonAttrsToSerialize.push("x");
	 * jsonAttrsToSerialize.push("y");
	 * jsonAttrsToSerialize.push("id");
	 * jsonAttrsToSerialize.push("className");
	 * jsonAttrsToSerialize.push("children");
	 * 
	 * @return A JSON representation of the node. Formatted with a tabulator.
	 */
	@Deprecated
	public final native String toMyJSON(JsArrayString attrsToPrint) /*-{
		return this.toMyJSON(attrsToPrint);
	}-*/;
}
