package level_03.model;

import level_03.interfaces.BubbleTea;

public class TeaBase implements BubbleTea {
	private String description;
	private double cost;
	public TeaBase() {
		this.description = "Tea base";
		this.cost = 3.00;
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
