package edu.ssafy.ws06;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarMgr cm=CarMgr.getInstance();
		cm.add(new Car("1234","현대",10000));
		cm.add(new Car("2345","기아",90000));
		cm.add(new Car("1234","벤츠",909900));
		cm.add(new Bus("1000","폭스바겐",99999,20));
		cm.add(new Bus("12151486","BMW",33333,30));
		cm.add(new Bus("12151486","BMW",33333,10));
		cm.add(new Truck("12151486","BMW",33333,100));
		cm.add(new Truck("12151486","BMW",33333,100));
		cm.add(new Truck("12151486","BMW",33333,200));
		cm.searchAll();
		
		//차량정보 더하기
		cm.add(new Car("12151486","현대",55555));
		System.out.println("새 차량 추가된 후 차량 정보 입니다.");
		
		Car[] pr=cm.searchAll();
		for (int i = 0; i < pr.length; i++) {
			System.out.println(pr[i].toString());
		}
		//번호로 검색
		pr=cm.searchNum("1234");
		for (int i = 0; i < cm.len(); i++) {
			System.out.println(pr[i].toString());
		}
		
		//가격으로 검색
		pr=cm.searchPrice(33333);
		for (int i = 0; i < cm.len(); i++) {
			System.out.println(pr[i].toString());
		}
		
		//차량 번호로 가격 업데이트
		cm.update("1234", 0);
		System.out.println("업데이트 후 차량 정보 입니다.");
		pr=cm.searchAll();
		for (int i = 0; i < cm.len(); i++) {
			System.out.println(pr[i].toString());
		}
		
		//정보 삭제하기
		cm.deleteNum("12151486");
		System.out.println("삭제 후 차량 정보 입니다.");
		pr=cm.searchAll();
		for (int i = 0; i < cm.objectNum(); i++) {
			System.out.println(pr[i].toString());
		}
		
		//차량 총 수 구하기
		int x=cm.size();
		System.out.println("저장된 차량의 개수는 "+x+"입니다.");
		//총 가격
		x=cm.totalPrice();
		System.out.println("모든 차량의 가격 합계는 "+x+"입니다.");
	}

}
