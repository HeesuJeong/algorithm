package test;

public class TV extends Product{

	private int inch;
	
	public TV(int isbn, String name, int money, int stock, int inch) {
		super(isbn, name, money, stock);
		this.inch = inch;
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [isbn=" + isbn + ", name=" + name + ", money=" + money
				+ ", stock=" + stock + ", inch=" + inch +"]";
	}
}
