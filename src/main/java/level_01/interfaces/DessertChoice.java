package level_01.interfaces;

import level_01.model.Menu;

public interface DessertChoice {
	public DrinkChoice withDrink(String name);
	public Menu build();
}
