package net.edzard.kinetic.event;

/**
 * Kinetic stage events only. Don't use with other types. Touch device events only. 
 */
public enum EventTypeStageTouch implements IEventTypeEnum
{
	contentTouchstart,
	contentTouchmove,
	contentTouchend,
	contentTap,
	contentDblTap,;

	@Override
	public String toNativeEvent()
	{
		return this.toString();
	}
}
