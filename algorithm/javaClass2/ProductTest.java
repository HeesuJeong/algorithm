package edu.ssafy.ws07;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr p=new ProductMgr();
		
		//데이터 입력부분
		p.add(new TV(111, "type1", 10000, 10, 10, "평면"));
		p.add(new TV(122, "LG", 20011, 100, 11, "굴곡"));
		p.add(new TV(222,"Samsung",222,5,12,"평면"));
		p.add(new TV(333, "type2", 99999, 300, 10, "평면"));
		p.add(new TV(999, "type3", 30000, 10, 12, "굴곡"));


		p.add(new Refrigerator(999, "LG", 10000, 10, 100));
		p.add(new Refrigerator(122, "LG", 9999, 5, 90));
		p.add(new Refrigerator(222, "type2", 98943, 20, 200));
		p.add(new Refrigerator(333, "type3", 100000, 100, 1000));
		p.add(new Refrigerator(111, "type1", 30303, 2, 100));
		
		//상품정보 전체 검색
		p.searchAll();
		//상품번호로 상품을 검색
		p.searchLsbn(999);
		//상품명으로 검색(부분 검색 가능)
		p.searchName("type");
		//TV정보만 검색
		p.searchTV();
		//Refrigerator만 검색
		p.searchRefrigerator();
		//상품번호로 상품 삭제
		p.delProduct(999);
		System.out.println("999번 삭제 후 상품 정보입니다.");
		p.searchAll();
		//전체 재고 상품 금액 구하기
		p.totalMoney();
		
		System.out.println("해당 객체의 모든 원소의 가격의 합을 출력합니다");
		Refrigerator r=new Refrigerator(1234, "LG", 10000, 10, 1110);
		System.out.println(p.showPrice(r));
		System.out.println("해당 객체의 모든 원소의 재고수량의 합을 출력합니다");
		System.out.println(p.showCount(r));
		System.out.println(p.searchInch());
		System.out.println(p.searchLiter());
		
		Product[] resul=p.searchLowerPrice("type1", 400000);
		for (int i = 0; i < p.showIdx(); i++) {
			System.out.println(resul[i].toString());
		}
	}

}
