package level_01.interfaces;

public interface StartChoice {
	public DishOptionChoice<EntrantOption> withEntrant(String name);
	public DishOptionChoice<MainCourseChoice> withMainCourse(String name);
}
