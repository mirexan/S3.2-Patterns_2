package level_01.interfaces;

public interface MainCourseOption extends DessertChoice{
	public MainCourseOption isVegan();
	public MainCourseOption isGlutenFree();
	public MainCourseOption withSuplement(String name);
}
