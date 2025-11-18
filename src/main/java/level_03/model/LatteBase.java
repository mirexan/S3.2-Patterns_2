package level_03.model;

import level_03.interfaces.BubbleTea;

public class LatteBase implements BubbleTea {
	private String description;
	private double cost;
	public LatteBase() {
		this.description = "Latte base";
		this.cost = 3.50;
	}
	@Override
	public String getDescription() {
		return this.description;
	}
	@Override
	public double getCost() {
		return this.cost;
	}
}
