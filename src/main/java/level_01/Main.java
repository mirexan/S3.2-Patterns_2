package level_01;

import level_01.controller.MenuBuilder;
import level_01.model.Menu;

public class Main {
	public static void main(String[] args) {
		Menu executiveMenu = new MenuBuilder()
				.withEntrant("Amanida Mediterrània")
				.isVegan()
				.isGlutenFree()
				.withMainCourse("Filet de Vedella")
				.withSuplement("Guarnició extra")
				.withDessert("Mousse de xocolata")
				.withDrink("Vi Negre")
				.build();

		Menu kidsMenu = new MenuBuilder()
				.withMainCourse("Macarrons amb tomàquet")
				.withDessert("Gelat de Vainilla")
				.withDrink("Suc de taronja")
				.build();

		Menu halfMenu = new MenuBuilder()
				.withMainCourse("Risotto de bolets")
				.isVegan()
				.withCoffee("Espresso")
				.withDrink("Aigua")
				.build();
	}
}
