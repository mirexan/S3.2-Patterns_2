package level_01.controller;


import level_01.interfaces.*;
import level_01.model.Dish;
import level_01.model.Menu;


public class MenuBuilder implements StartChoice, MainCourseChoice, DessertChoice, DrinkChoice {

	private Dish entrant;
	private Dish mainCourse;
	private Dish dessert;
	private String drink;

	@Override
	public EntrantOption withEntrant(String name) {
		this.entrant = new Dish(name);
		return new EntrantOption() {
			@Override
			public EntrantOption isVegan() {
				entrant.setVegan(true);
				return this;
			}

			@Override
			public EntrantOption isGlutenFree() {
				entrant.setGlutenFree(true);
				return this;
			}

			@Override
			public MainCourseOption withMainCourse(String name) {
				return MenuBuilder.this.withMainCourse(name);
			}

			@Override
			public DessertChoice withDessert(String name) {
				return null;
			}

			@Override
			public DessertChoice withCoffee(String name) {
				return null;
			}

			@Override
			public DrinkChoice withDrink(String name) {
				return null;
			}

			@Override
			public Menu build() {
				return null;
			}
		};
	}
	@Override
	public EntrantOption isVegan() {
		this.entrant.setVegan(true);
		return this;
	}

	@Override
	public EntrantOption isGlutenFree() {
		this.entrant.setGlutenFree(true);
		return null;
	}

	@Override
	public MainCourseChoice withMainCourse(String name) {
		this.mainCourse = new Dish(name);
		return this;
	}
	@Override
	public MainCourseChoice isVegan(){
		this.mainCourse.setVegan(true);
		return this;
	}
	@Override
	public MainCourseChoice isGlutenFree(){
		this.mainCourse.setVegan(true);
		return this;
	}
	@Override
	public MainCourseChoice withSuplement(String name){
		this.mainCourse.setSuplement(name);
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
