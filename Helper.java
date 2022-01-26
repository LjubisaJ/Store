import java.time.DayOfWeek;
import java.time.LocalDate;

public class Helper {
	public static boolean isWeekend() {
		DayOfWeek day = LocalDate.now().getDayOfWeek();
		return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
	}
}
