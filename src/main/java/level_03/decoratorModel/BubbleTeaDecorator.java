package level_03.decoratorModel;

import level_03.interfaces.BubbleTea;

public abstract class BubbleTeaDecorator implements BubbleTea {
	protected BubbleTea decoratedBubbleTea;
	public BubbleTeaDecorator(BubbleTea decoratedBubbleTea) {
		this.decoratedBubbleTea = decoratedBubbleTea;
	}
	@Override
	public String getDescription(){
		return decoratedBubbleTea.getDescription();
	}
	@Override
	public double getCost(){
		return decoratedBubbleTea.getCost();
	}
}
