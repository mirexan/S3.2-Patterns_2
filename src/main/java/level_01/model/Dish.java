package level_01.model;

public class Dish {
	private String name;
	private String suplement;
	private boolean vegan;
	private boolean glutenFree;
	public Dish(String name) {
		this.name = name;
		this.vegan = false;
		this.glutenFree = false;
	}
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}
	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}
	public void setSuplement(String suplement) {
		this.suplement = suplement;
	}
}
