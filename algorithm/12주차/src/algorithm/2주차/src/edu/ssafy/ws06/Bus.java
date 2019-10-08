package edu.ssafy.ws06;

public class Bus extends Car {
	private int seat;

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
	}
	
	public Bus() {
		
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
	
	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Bus " +"[num=" + num + ", model=" + model + ", price=" + price +", seat=" + seat +"]";
	}
	
	
}
