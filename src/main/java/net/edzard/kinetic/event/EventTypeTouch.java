package net.edzard.kinetic.event;


/**
 * Can be used with any node except stage. Touch device events only.
 */
public enum EventTypeTouch implements IEventTypeEnum
{
	TOUCHSTART,
	TOUCHMOVE,
	TOUCHEND,
	TAP,
	DBLTAP;

	@Override
	public String toNativeEvent()
	{
		return this.toString().toLowerCase();
	}
}
