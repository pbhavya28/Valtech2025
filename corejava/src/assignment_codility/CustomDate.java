package assignment_codility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomDate {

	private int date;
	private int month;
	private int year;
	
	
	public CustomDate() {}
	
	public CustomDate(int date, int month, int year) {
		super();
		this.date = date;
		this.month = month;
		this.year = year;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Object getCustomDate() {
		return this.getDate() +"-" + this.getMonth() +"-"+ this.getYear();
	}

	@Override
	public String toString() {
		return "CustomDate [date=" + date + ", month=" + month + ", year=" + year + "]";
	}
	public static void calculateDifference(String dateTime1, String dateTime2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
        LocalDateTime dt1 = LocalDateTime.parse(dateTime1, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(dateTime2, formatter);
 
        Duration duration = Duration.between(dt1, dt2);
 
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
 
        System.out.println("Difference between " + dateTime1 + " and " + dateTime2 + " is:");
        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }
	public static void main(String[] args) {
		CustomDate cd = new CustomDate(22,3,2025);
		System.out.println(cd.getCustomDate());
		System.out.println(cd.getDate());
		System.out.println(cd.getMonth());
		System.out.println(cd.getYear());
		
		String dateTime1 = "2023-04-20 11:30:00";
        String dateTime2 = "2023-03-12 12:30:30";
 
        calculateDifference(dateTime2, dateTime1);
	}
	
	
}
