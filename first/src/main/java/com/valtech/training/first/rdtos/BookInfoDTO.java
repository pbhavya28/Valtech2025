package com.valtech.training.first.rdtos;

public class BookInfoDTO{
	
	private String publisherName;
	private int price;
	public BookInfoDTO() {}
	public BookInfoDTO(String publisherName, int price) {
		super();
		this.publisherName = publisherName;
		this.price = price;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookInfoDTO [publisherName=" + publisherName + ", price=" + price + ", getPublisherName()="
				+ getPublisherName() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
