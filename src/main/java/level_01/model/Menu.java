package level_01.model;

public class Menu {
	private Dish entrant;
	private Dish mainCourse;
	private Dish dessert;
	private String drink;

	public Menu(Dish entrant, Dish mainCourse, Dish dessert, String drink){
		this.entrant = entrant;
		this.mainCourse = mainCourse;
		this.dessert = dessert;
		this.drink = drink;
	}
}
