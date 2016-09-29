package net.edzard.kinetic;

import java.util.List;

import com.google.gwt.core.client.JsArray;

/**
 * Base class for all nodes that contain other child nodes.
 * @author Ed
 * @see Stage, Layer, Group
 */
public class Container extends Node {

	/**
	 * Protected ctor keeps GWT happy.
	 */
	protected Container() {}
	
	/**
	 * Add a node to this container.
	 * @param child A child node
	 */
	public final native void add(Node child) /*-{
		this.add(child);
	}-*/;

	/**
	 * Retrieve a child node of this container.
	 * The following selectors are supported:
	 * <ul>
	 * <li>Use '#' to select a node by a previously assigned unique ID (e.g. '#foo')
	 * <li>Use '.' to select a number of nodes with the same name (e.g. '.bar')
	 * <li>Use type or class name to select certain types (e.g. 'Text')
	 * <li>Use ", " to seperate selectors.
	 * </ul>
	 * @param selector The selector string
	 * @return An array of matching nodes
	 */
	public final native JsArray<Node> find(String selector) /*-{
		return this.find(selector).toArray();
	}-*/;
	
	/**
	 * Retrieve all child nodes of this container.
	 * @return A list of child nodes
	 */
	public final native List<Node> getChildren() /*-{
		var result = @java.util.ArrayList::new()();
		var children = this.getChildren();
		for (var i=0; i < children.length; ++i) {
			result.@java.util.ArrayList::add(Ljava/lang/Object;)(children[i]);
		}
		return result;
	}-*/;

	/**
	 * Check if a this container is the parent of some other node 
	 * @param node The other node
	 * @return True, if this container is a parent of the other node. False, otherwise.
	 */
	public final native boolean isAncestorOf(Node node) /*-{
		return this.isAncestorOf(node);
	}-*/;

	/**
	 * Remove child node from this container.
	 * @param child The child node to remove
	 */
	public final native void remove(Node child) /*-{
		this.remove(child);
	}-*/;

	/** 
	 * Remove all child nodes from this container (doesn't destroy them).
	 */
	public final native void removeChildren() /*-{
		this.removeChildren();
	}-*/;
	
	/** 
	 * Remove and destroy all child nodes of this container.
	 */
	public final native void destroyChildren() /*-{
		this.destroyChildren();
	}-*/;
}
