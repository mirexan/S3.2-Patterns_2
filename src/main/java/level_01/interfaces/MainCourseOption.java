package level_01.interfaces;

import level_01.model.Menu;

public interface MainCourseOption {
	public MainCourseOption isVeganMain();
	public MainCourseOption isGlutenFreeMain();
	public MainCourseOption withSuplement(String name);
	public DessertChoice withDessert(String name);
	public DessertChoice withCoffee(String name);
	public DrinkChoice withDrink(String name);
	public Menu build();

}
