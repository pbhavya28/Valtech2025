package assignment_codility;

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
	public static void main(String[] args) {
		CustomDate cd = new CustomDate(22,3,2025);
		System.out.println(cd.getCustomDate());
		System.out.println(cd.getDate());
		System.out.println(cd.getMonth());
		System.out.println(cd.getYear());
	}
	
	
}
