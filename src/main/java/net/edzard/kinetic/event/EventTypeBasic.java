package net.edzard.kinetic.event;


/**
 * Can be used with any node except stage.
 * @author Ed
 */
public enum EventTypeBasic implements IEventTypeEnum
{
	MOUSEENTER,
	MOUSELEAVE,
	MOUSEOVER,
	MOUSEOUT,
	MOUSEMOVE,
	MOUSEDOWN,
	MOUSEUP,
	CLICK,
	DBLCLICK,
	DRAGSTART,
	DRAGMOVE,
	DRAGEND;

	@Override
	public String toNativeEvent()
	{
		return this.toString().toLowerCase();
	}
}
