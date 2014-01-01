package net.edzard.kinetic.event;

import net.edzard.kinetic.Shape;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The wrapper class for Kinetic native events. Used in KineticGWT event handling system.
 * 
 * @author SkyCrawl
 */
public class KineticEvent extends JavaScriptObject
{
	/**
	 * Protected Ctor.
	 * Makes JSNI (GWT) happy
	 */
	protected KineticEvent() {}
	
	/**
	 * Get the event target (the node that triggered this event). Useful for handling events in ancestors.
	 * @return The original event target
	 */
	public native final Shape getEventTarget() /*-{
		return this.targetNode;
	}-*/;
	
	/**
	 * Tells Kinetic environment to stop this event from bubbling up in the node hierarchy.
	 * RED ALERT: this is bugged in KineticJS and is also a pending issue for future releases.
	 */
	@Deprecated
	public native final void stopPropagation() /*-{
		this.cancelBubble = true;
	}-*/;
}
