package level_01;

import level_01.controller.MenuBuilder;
import level_01.model.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class UnitaryTests {
	@Test
	public void executiveMenuBuildingTest (){
		Menu executiveMenu = new MenuBuilder()
				.withEntrant("Amanida Mediterrània")
				.isVegan()
				.isGlutenFree()
				.withMainCourse("Filet de Vedella")
				.withSuplement("Guarnició extra")
				.withDessert("Mousse de xocolata")
				.withDrink("Vi Negre")
				.build();
		Assertions.assertEquals("Amanida Mediterrània", executiveMenu.getEntrant().getName());
		Assertions.assertTrue(executiveMenu.getEntrant().isVegan());
		Assertions.assertTrue(executiveMenu.getEntrant().isGlutenFree());
		Assertions.assertEquals("Filet de Vedella", executiveMenu.getMainCourse().getName());
		Assertions.assertEquals("Guarnició extra", executiveMenu.getMainCourse().getSuplement());
		Assertions.assertEquals("Mousse de xocolata", executiveMenu.getDessert().getName());
		Assertions.assertEquals("Vi Negre", executiveMenu.getDrink());
	}
	@Test
	public void kidsMenuBuildingTest (){
		Menu kidsMenu = new MenuBuilder()
				.withMainCourse("Macarrons amb tomàquet")
				.withDessert("Gelat de Vainilla")
				.withDrink("Suc de taronja")
				.build();
		Assertions.assertNull(kidsMenu.getEntrant());
		Assertions.assertEquals("Macarrons amb tomàquet",kidsMenu.getMainCourse().getName());
		Assertions.assertEquals("Gelat de Vainilla", kidsMenu.getDessert().getName());
		Assertions.assertEquals("Suc de taronja",kidsMenu.getDrink());
	}
	@Test
	public void halfMenuBuildingTest (){
		Menu halfMenu = new MenuBuilder()
				.withMainCourse("Risotto de bolets")
				.isVeganMain()
				.withDrink("Aigua")
				.build();
		Assertions.assertNull(halfMenu.getEntrant());
		Assertions.assertEquals("Risotto de bolets", halfMenu.getMainCourse().getName());
		Assertions.assertTrue(halfMenu.getMainCourse().isVegan());
		Assertions.assertEquals("Aigua", halfMenu.getDrink());
	}
	@Test
	public void halfMenuNoDrinkBuildingTest (){
		Menu halfNoDrinkMenu = new MenuBuilder()
				.withMainCourse("Risotto de bolets")
				.isVeganMain()
				.isGlutenFreeMain()
				.build();
		Assertions.assertNull(halfNoDrinkMenu.getEntrant());
		Assertions.assertNull(halfNoDrinkMenu.getDessert());
		Assertions.assertNull(halfNoDrinkMenu.getDrink());
		Assertions.assertEquals("Risotto de bolets", halfNoDrinkMenu.getMainCourse().getName());
		Assertions.assertTrue(halfNoDrinkMenu.getMainCourse().isVegan());
		Assertions.assertTrue(halfNoDrinkMenu.getMainCourse().isGlutenFree());
	}
}
