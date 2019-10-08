package edu.ssafy.ws07;

public class ProductMgr {
	private Product[] products;
	private int max = 5;
	private int index = 0;
	private int idx = 0;

	public int showIndex() {
		return index;
	}

	public int showIdx() {
		return idx;
	}

	public ProductMgr() {
		products = new Product[max];
	}

	// 해당 객체 모두의 가격합
	public int showPrice(Product p) {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if (p instanceof TV) {
				if (products[i] instanceof TV) {
					sum += products[i].getMoney();
				}
			} else if (p instanceof Refrigerator) {
				if (products[i] instanceof Refrigerator) {
					sum += products[i].getMoney();
				}
			}
		}
		return sum;
	}

	// 해당 객체 모두의 재고수량
	public int showCount(Product p) {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if (p instanceof TV) {
				if (products[i] instanceof TV) {
					sum += products[i].getStock();
				}
			} else if (p instanceof Refrigerator) {
				if (products[i] instanceof Refrigerator) {
					sum += products[i].getStock();
				}
			}
		}
		return sum;
	}

	// TV의 평균 인치를 리턴
	public int searchInch() {
		int cnt = 0;
		System.out.println("모든 TV의 평균 인치를 출력합니다");
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof TV) {
				cnt += products[i].getStock();
			}
		}
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof TV) {
				TV tmp=(TV)products[i];
				sum+=tmp.getInch();
			}
		}
		System.out.println("-->모든 재고는 "+cnt+"개 입니다. 모든 가격의 합은 "+sum+" 입니다.");
		return sum/cnt;
	}

	//냉장고의 리터 합계
	public int searchLiter() {
		int cnt = 0;
		System.out.println("모든 냉장고의 평균 용량을 출력합니다");
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof Refrigerator) {
				cnt += products[i].getStock();
			}
		}
		int sum = 0;
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof Refrigerator) {
				Refrigerator tmp=(Refrigerator)products[i];
				sum+=tmp.getFullL();
			}
		}
		return sum/cnt;
	}
	
	//
	public Product[] searchLowerPrice(String s,int p) {
		System.out.println(s+"와 이름이 같고 가격은 "+p+"보다 작은 제품 정보 출력합니다.");
		Product[] tmp=new Product[index];
		idx=0;
		for (int i = 0; i < index; i++) {
			if (s.equals(products[i].getName())) {
				if(products[i].getMoney()<p) {
					tmp[idx++]=products[i];
				}
			}
		}
		return tmp;
	}
	
	// 데이터 입력부분
	public void add(Product p) {
		if (index < max) {
			products[index] = p;
			index++;
		} else {
			Product[] temp = new Product[max * 2];
			max *= 2;
			System.arraycopy(products, 0, temp, 0, products.length);
			products = temp;
			products[index] = p;
			index++;
		}
	}

	// 상품정보 전체 검색
	public void searchAll() {
		System.out.println("모든 상품 정보 출력합니다");
		for (int i = 0; i < index; i++) {
			System.out.println(products[i].toString());
		}
	}

	// 상품번호로 상품을 검색
	public void searchLsbn(int a) {
		System.out.println(a + " 번호 상품 정보입니다.");
		for (int i = 0; i < index; i++) {
			if (a == products[i].getIsbn()) {
				System.out.println(products[i].toString());
			}
		}
	}

	// 상품명으로 검색(부분 검색 가능)
	public void searchName(String n) {
		System.out.println(n + " 이 포함된 이름을 가진 상품 정보입니다.");
		for (int i = 0; i < index; i++) {
			if (products[i].getName().contains(n)) {
				System.out.println(products[i].toString());
			}
		}
	}

	// TV정보만 검색
	public void searchTV() {
		System.out.println("모든 TV를 출력합니다");
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof TV) {
				System.out.println(products[i].toString());
			}
		}
	}

	// Refrigerator만 검색
	public void searchRefrigerator() {
		System.out.println("모든 Refrigerator를 출력합니다");
		for (int i = 0; i < index; i++) {
			if (products[i] instanceof Refrigerator) {
				System.out.println(products[i].toString());
			}
		}
	}

	// 상품번호로 상품 삭제
	public void delProduct(int n) {
		for (int i = 0; i < index; i++) {
			if (n == products[i].getIsbn()) {
				products[i] = products[index - 1];
				index--;
			}
		}
	}

	// 전체 재고 상품 금액 구하기
	public void totalMoney() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += products[i].getMoney();
		}
		System.out.println("모든 도서의 금액 합계는 " + sum + "입니다");
	}
}