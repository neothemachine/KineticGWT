package net.edzard.kinetic.event;

/**
 * Defines signature for event callbacks.
 * Instantiate this class the same way you did with previous versions of KineticGWT:
 * <ul>
 * <li>node.addEventListener(EventTypeBasic.CLICK, new IEventListener() { ... }</li>
 * </ul>
 * @author Ed
 */
public interface IEventListener
{
	/**
	 * Handles an event. Called by Kinetic.
	 * @return True, if the event should stop being processed further by bubbling up in the hierarchy. False, if bubbling should continue. 
	 */
	public void handle(KineticEvent event);
}
