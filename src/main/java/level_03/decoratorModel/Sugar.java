package level_03.decoratorModel;

import level_03.interfaces.BubbleTea;

public class Sugar extends BubbleTeaDecorator {
	private final double EXTRACOST = 0.30;
	public Sugar(BubbleTea decoratedBubbleTea) {
		super(decoratedBubbleTea);
	}
	@Override
	public String getDescription()
	{
		return decoratedBubbleTea.getDescription() + ", sugar";
	}
	@Override
	public double getCost(){
		return decoratedBubbleTea.getCost() + EXTRACOST;
	}
}
