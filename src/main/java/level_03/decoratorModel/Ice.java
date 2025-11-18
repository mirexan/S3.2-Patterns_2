package level_03.decoratorModel;

import level_03.interfaces.BubbleTea;

public class Ice extends BubbleTeaDecorator {
	private final double EXTRACOST = 0.25;
	public Ice(BubbleTea decoratedBubbleTea) {
		super(decoratedBubbleTea);
	}
	@Override
	public String getDescription()
	{
		return decoratedBubbleTea.getDescription() + ", ice";
	}
	@Override
	public double getCost(){
		return decoratedBubbleTea.getCost() + EXTRACOST;
	}
}
