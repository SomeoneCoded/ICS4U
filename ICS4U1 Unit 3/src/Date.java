import java.util.Arrays;

public class Date {

	private int month, day, year;

	// used to determine the month name
	private String[] monthArray = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	// used to determine the number of days in each month
	private int daysArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public Date(String month, int day, int year) {
		this.day = day;
		this.year = year;
		for (int i = 0; i < monthArray.length; i++) {
			if (month.equals(monthArray[i])) {
				this.month = i + 1;
				break;
			}
		}
	}

	public Date(int dayNumber, int year) {
		boolean leapYear = false;

		if (year % 4 == 0) {
			leapYear = true;

			if (year % 100 == 0 && !(year % 400 == 0)) {
				leapYear = false;
			}
		}

		if (leapYear)
			daysArray[1] = 29;

		for (int index = 0; index < daysArray.length; index++) {
			if (day - daysArray[index] <= 0) {
				day = dayNumber;
				month = index + 1;
				break;
			} else
				day -= daysArray[index];
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDayNumber() {
		int dayNumber = 0;
		for (int m = 0; m < (month - 1); m++) {
			dayNumber += daysArray[m];
		}

		dayNumber += day;
		return dayNumber;

	}

	@Override
	public String toString() {
		return "Date [month=" + month + ", day=" + day + ", year=" + year + "]";
	}

	public void displayDate1() {
		System.out.printf("%d/%d/%d\n", getMonth(), getDay(), getYear());
	}

	public void displayDate2() {
		System.out.printf("%s %d, %d\n", monthArray[getMonth() - 1], getDay(), getYear());

	}

	public void displayDate3() {
		System.out.printf("%d %d\n", getDayNumber(), getYear());

	}

}