package level_03;

import level_03.decoratorModel.Flavour;
import level_03.decoratorModel.Ice;
import level_03.decoratorModel.Sugar;
import level_03.decoratorModel.Tapioca;
import level_03.interfaces.BubbleTea;
import level_03.model.LatteBase;

import level_03.model.TeaBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BubbleTea_UnitaryTest {
	BubbleTea tea;
	@Test
	public void LatteTapiocaStrawberryDescriptionTest() {
		tea = new LatteBase();
		tea = new Tapioca(tea);
		tea = new Flavour(tea,"Strawberry");
		Assertions.assertEquals("Latte base, tapioca, Strawberry flavour", tea.getDescription());
	}
	@Test
	public void LatteTapiocaStrawberryCostTest() {
		tea = new LatteBase();
		tea = new Tapioca(tea);
		tea = new Flavour(tea,"Strawberry");
		Assertions.assertEquals(4.60, tea.getCost());
	}
	@Test
	public void TeaIceSugarTapiocaVanillaCoconutDescriptionTest() {
		tea = new TeaBase();
		tea = new Ice(tea);
		tea = new Sugar(tea);
		tea = new Tapioca(tea);
		tea = new Flavour(tea,"vanilla");
		tea = new Flavour(tea,"coconut");
		Assertions.assertEquals("Tea base, ice, sugar, " +
				"tapioca, vanilla flavour, coconut flavour", tea.getDescription());
	}
	@Test
	public void TeaIceSugarTapiocaVanillaCoconutCostTest() {
		tea = new TeaBase();
		tea = new Ice(tea);
		tea = new Sugar(tea);
		tea = new Tapioca(tea);
		tea = new Flavour(tea,"vanilla");
		tea = new Flavour(tea,"coconut");
		Assertions.assertEquals(5.25, tea.getCost(), 0.001);
	}
}
