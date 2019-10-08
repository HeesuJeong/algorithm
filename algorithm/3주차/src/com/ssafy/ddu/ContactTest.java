package com.ssafy.ddu;

import java.util.Scanner;

public class ContactTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ContactMgr mgr=ContactMgr.getInstance();
		while(true) {
			System.out.println("1. 연락처 추가");
			System.out.println("2. 연락처 삭제");
			System.out.println("3. 연락처 수정");
			System.out.println("4. 연락처 검색");
			System.out.println("5. 모든 연락처");
			System.out.println("6. 정렬 후 연락처 출력");
			System.out.println("7. 파일 만들기");
			System.out.println("8. 파일 가져오기");
			System.out.println("0. 종료! ");
			
			int sel=sc.nextInt();
			if(sel==1) {
				//연락처에 필요한 정보 받자
				System.out.print("폰 번호는? : ");
				String num=sc.next();
				System.out.print("이름? : ");
				String name=sc.next();
				System.out.print("회사? : ");
				String company=sc.next();
				
				Contact contact=new Contact(num,name,company);
				try {
					mgr.add(contact);
				} catch (DuplicateContactException e) {
					// TODO Auto-generated catch block
					System.out.println("이미 존재하는 번호입니다.");
				}
				
			}else if(sel==2) {
				System.out.println("폰 번호는? : ");
				String num=sc.next();
				try {
					mgr.delete(num);
				} catch (ContactNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("그런애 없어요.");
				}
			}else if(sel==3) {
				System.out.println("이름? : ");
				String name=sc.next();
				System.out.println("회사? : ");
				String company=sc.next();
				mgr.update(new Contact("",name,company));
			}else if(sel==4) {
				System.out.println("폰 번호? : ");
				String number=sc.next();
				Contact con=mgr.search(number);
				System.out.println(con);
			}else if(sel==5) {
				for(Contact c:mgr.search()) System.out.println(c);
			}else if(sel==6){
				mgr.sort();
				for(Contact c:mgr.search()) System.out.println(c);
			}else if(sel==7) {
				mgr.save();
			}else if(sel==8){
				mgr.open();
			}else if(sel==0) break;
		}
	}

}
