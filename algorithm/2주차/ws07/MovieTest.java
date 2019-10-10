package edu.ssafy.ws07;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieMgr manager=MovieMgr.getInstance();
//		once heesu 90 music good
//		ifonly minhae 1000 romance s
//		beforesunset heesu 80 romance healing
//		eatpraylove heesu 100 daily healing
//		titanic null 110 romance perfect
		
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색"); 
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		
		
		Scanner sc=new Scanner(System.in);
		int type=0;
		String name="";
		String dir="";
		int score=0;
		String gen="";
		String com="";
		
		while(true) {
			System.out.println("원하는 번호를 선택하세요");
			type=sc.nextInt();
			if(type==1) {
				System.out.println("영화이름, 감독, 점수, 장르, 한줄평 입력하세요.");
				name=sc.next();
				dir=sc.next();
				score=sc.nextInt();
				gen=sc.next();
				com=sc.next();
				manager.add(new Movie(name,dir,score,gen,com));
			}else if(type==2) {
				Movie[] resul=manager.search();
				for (int i = 0; i < manager.showIndex(); i++) {
					System.out.println(resul[i].toString());
				}
			}else if(type==3) {
				System.out.print("검색하고 싶으신 영화 제목을 입력하세요 : ");
				String t=sc.next();
				Movie[] resul=manager.searchTitle(t);
				for (int i = 0; i < manager.showIdx(); i++) {
					System.out.println(resul[i].toString());
				}
			}else if(type==4) {
				System.out.print("검색하고 싶으신 영화 장르를 입력하세요 : ");
				String t=sc.next();
				Movie[] resul=manager.searchGen(t);
				for (int i = 0; i < manager.showIdx(); i++) {
					System.out.println(resul[i].toString());
				}
			}else if(type==5) {
				System.out.print("삭제하고 싶으신 영화 장르를 입력하세요 : ");
				String t=sc.next();
				manager.delete(t);
				////////////
			}else if(type==0) {
				System.out.println("프로그램 종료합니다");
				break;
			}
			
		}//while
	}

}
