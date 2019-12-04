package edu.ssafy.ws06;

public class CarMgr {
		private Car[] cars;
		private int index=0;
		private int idx=0;
		private CarMgr() {
			cars=new Car[100];
		}
		
		private static CarMgr instance; //자기자신의 참조변수
		
		public static CarMgr getInstance() {
			//없었다면 만들어 줘
			if(instance==null)
				instance=new CarMgr();
			//있으면 하나만 줘
			return instance;
			//즉 CarMgr은 하나
		}
		//새 차 추가
		public void add(Car c) {
				cars[index]=c;
				index++;
		}
		public int len() {
			return idx;
		}
		public int objectNum() {
			return index;
		}
		
		//모든 차 정보 출력
		public Car[] searchAll() {
			idx=0;
			Car[] tmp=new Car[index];
			for (int i = 0; i < index; i++) {
				tmp[idx++]=cars[i];
			}
			return tmp;
			//return cars 바로 해도 된다.
		}
		
		//차량 번호로 검색결과
		public Car[] searchNum(String n) {
			System.out.println(n+" 차량 번호로 검색한 결과 입니다.");
			idx=0;
			Car[] tmp=new Car[index];
			for (int i = 0; i < index; i++) {
				if(cars[i].getNum()==n) {
					tmp[idx++]=cars[i];
				}
			}
			return tmp;
		}
		
		//가격으로 검색결과
		public Car[] searchPrice(int p) {
			System.out.println(p+" 가격인 차량의 결과 입니다.");
			idx=0;
			Car[] tmp=new Car[index];
			for (int i = 0; i < index; i++) {
				if(cars[i].getPrice()<p) {
					System.out.println(cars[i].toString());
				}
			}
			return tmp;
		}
		
		//update하기
		public void update(String n,int p) {
			System.out.println(n+" 차량 번호의 가격을 변경합니다.");
			for (int i = 0; i < index; i++) {
				if(cars[i].getNum()==n) {
					cars[i].setPrice(p);
				}
			}
		}
		
		//차량번호로 삭제하기
		public void deleteNum(String n) {
			System.out.println(n+" 차량 번호의 정보를 삭제합니다.");
			for (int i = 0; i < index; i++) {
				if(cars[i].getNum()==n) {
					for(int j=i+1;j<index;j++) {
						cars[j-1]=cars[j];
					}
					index--;
					i--;
				}
			}
		}
		
		//저장된 차량 수량
		public int size() {
			return index;
		}
		//전체 가격
		public int totalPrice() {
			int sum=0;
			for (int i = 0; i < index; i++) {
				sum+=cars[i].getPrice();
			}
			return sum;
		}
}
