package level_01.controller;


import level_01.interfaces.*;
import level_01.model.Dish;
import level_01.model.Menu;


public class MenuBuilder implements StartChoice, EntrantOption, MainCourseOption, DessertChoice, DrinkChoice {

	private Dish entrant;
	private Dish mainCourse;
	private Dish dessert;
	private String drink;

	@Override
	public EntrantOption withEntrant(String name) {
		this.entrant = new Dish(name);
		return this;
	}

	@Override
	public EntrantOption isVegan() {
		if (this.entrant != null) {
			this.entrant.setVegan(true);
		}
		return this;
	}

	@Override
	public EntrantOption isGlutenFree() {
		if (this.entrant != null) {
			this.entrant.setGlutenFree(true);
		}
		return this;
	}

	@Override
	public MainCourseOption withMainCourse(String name) {
		this.mainCourse = new Dish(name);
		return this;
	}

	@Override
	public MainCourseOption isVeganMain() {
		if (this.mainCourse != null) {
			this.mainCourse.setVegan(true);
		}
		return this;
	}

	@Override
	public MainCourseOption isGlutenFreeMain() {
		if (this.mainCourse != null) {
			this.mainCourse.setGlutenFree(true);
		}
		return this;
	}

	@Override
	public MainCourseOption withSuplement(String name) {
		if (this.mainCourse != null) {
			this.mainCourse.setSuplement(name);
		}
		return this;
	}

	@Override
	public DessertChoice withDessert(String name){
		this.dessert = new Dish(name);
		return this;
	}
	@Override
	public DessertChoice withCoffee(String name){
		this.dessert = new Dish(name);
		return this;
	}
	@Override
	public DrinkChoice withDrink(String name){
		this.drink = name;
		return this;
	}

	@Override
	public Menu build() {
		return new Menu(this.entrant, this.mainCourse, this.dessert, this.drink);
	}
}
