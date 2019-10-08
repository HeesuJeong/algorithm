package test;

import java.io.Serializable;

public class Product implements Serializable {
	protected int isbn;
	protected String name;
	protected int money;
	protected int stock;
	public Product(int isbn, String name, int money, int stock) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.money = money;
		this.stock = stock;
	}
	
	public Product() {
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [isbn=" + isbn + ", name=" + name + ", money=" + money + ", stock=" + stock + "]";
	}
}
