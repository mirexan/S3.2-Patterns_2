package level_01.interfaces;

public interface EntrantOption {
	public EntrantOption isVegan();
	public EntrantOption isGlutenFree();
	public MainCourseOption withMainCourse(String name);
}
