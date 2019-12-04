package edu.ssafy.ws06;

public class Truck extends Car {
	private int ton;

	public Truck(String num, String model, int price, int ton) {
		super(num, model, price);
		this.ton = ton;
	}
	
	public Truck() {
		
	}

	public int getTon() {
		return ton;
	}

	public void setTon(int ton) {
		this.ton = ton;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Truck [num=" + num + ", model=" + model + ", price=" + price + ", ton=" + ton + "]";
	}
	
	
}
