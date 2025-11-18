package level_03.decoratorModel;


import level_03.interfaces.BubbleTea;

public class Flavour extends BubbleTeaDecorator {
	private final double EXTRACOST = 0.60;
	private String flavourName;
	public Flavour(BubbleTea decoratedBubbleTea, String flavourName) {
		super(decoratedBubbleTea);
		this.flavourName = flavourName;
	}
	@Override
	public String getDescription() {
		return decoratedBubbleTea.getDescription()
				+ ", " + flavourName + " flavour";
	}
	@Override
	public double getCost(){
		return decoratedBubbleTea.getCost() + EXTRACOST;
	}
}
