package level_03.model;

import level_03.interfaces.BubbleTea;

public class MatchaBase implements BubbleTea {
	private String description;
	private double cost;
	public MatchaBase() {
		this.description = "Matcha base";
		this.cost = 3.20;
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
