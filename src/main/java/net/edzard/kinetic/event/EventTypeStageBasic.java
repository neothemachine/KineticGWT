package net.edzard.kinetic.event;

/**
 * Kinetic stage events only. Don't use with other types.
 */
public enum EventTypeStageBasic implements IEventTypeEnum
{
	contentMouseover,
	contentMousemove,
	contentMouseout,
	contentMousedown,
	contentMouseup,
	contentClick,
	contentDblclick;

	@Override
	public String toNativeEvent()
	{
		return this.toString();
	}
}
