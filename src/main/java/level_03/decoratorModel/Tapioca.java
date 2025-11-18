package level_03.decoratorModel;

import level_03.interfaces.BubbleTea;

public class Tapioca extends BubbleTeaDecorator {
	private final double EXTRACOST = 0.50;
	public Tapioca(BubbleTea decoratedBubbleTea) {
		super(decoratedBubbleTea);
	}
	@Override
	public String getDescription()
	{
		return decoratedBubbleTea.getDescription() + ", tapioca";
	}
	@Override
	public double getCost(){
		return decoratedBubbleTea.getCost() + EXTRACOST;
	}
}
