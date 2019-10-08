package test;

public class Refrigerator extends Product{
	private int fullL;

	public Refrigerator(int isbn, String name, int money, int stock, int fullL) {
		super(isbn, name, money, stock);
		this.fullL = fullL;
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

	public int getFullL() {
		return fullL;
	}

	public void setFullL(int fullL) {
		this.fullL = fullL;
	}

	@Override
	public String toString() {
		return "Refrigerator [isbn=" + isbn + ", name=" + name + ", money=" + money + ", stock="
				+ stock + ", fullL="+fullL+"]";
	}
}
