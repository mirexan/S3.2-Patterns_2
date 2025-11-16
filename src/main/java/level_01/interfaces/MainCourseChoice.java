package level_01.interfaces;

import level_01.model.Menu;

public interface MainCourseChoice extends DishOptionChoice<MainCourseChoice>{
	public MainCourseOption withMainCourse(String name);
	public DessertChoice withDessert(String name);
	public DessertChoice withCoffee(String name);
	public DrinkChoice withDrink(String name);
	public Menu build();
}
