package com.ssafy.ddu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactMgr implements IContactMgr {

	private ArrayList<Contact> li;

	// 생성자는 private으로 감춘다
	private ContactMgr() {
		li = new ArrayList<>();
	}

	// singleton
	private static ContactMgr instance;

	public static ContactMgr getInstance() {
		if (instance == null)
			instance = new ContactMgr();
		return instance;
	}

	@Override
	public void add(Contact contact) throws DuplicateContactException {
		// TODO Auto-generated method stub

		// 만든 search 사용해서 중복 확인합
		if (search(contact.getNumber()) != null)
			throw new DuplicateContactException();
		li.add(contact);
	}

	// 수정하기(이름으로 해당하는 연락처 찾아 회사명을 바꾸자)
	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub
		for (int i = 0; i < li.size(); i++) {
			if (contact.getName().equals(li.get(i).getName())) {
				li.get(i).setCompany(contact.getCompany());
			}
		}
	}

	// 한바퀴돌아서 전화번호가 phone인 연락처의 위치를 찾아서 기억
	@Override
	public void delete(String phone) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		int idx = -1;
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getNumber().equals(phone)) {
				idx = i;
				break;
			}
		}
		// arraylist에서 제거
		if (idx != -1)
			li.remove(idx);
		else {
			throw new ContactNotFoundException();
		}
	}

	@Override
	public Contact search(String phone) {
		// TODO Auto-generated method stub
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i).getNumber().equals(phone)) {
				return li.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Contact> search() {
		// TODO Auto-generated method stub
		return li;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Comparator<Contact> com =new Comparator<Contact>() {

			//내가 더 빠르면 음수 리턴
			//같으면 0리턴
			//내가 더 느리면 양수 리턴
			@Override
			public int compare(Contact o1, Contact o2) {
				// TODO Auto-generated method stub
				
				//이름이 같으면 번호순
				if(o1.getName().compareTo(o2.getName())==0) return o1.getNumber().compareTo(o2.getNumber());
				//이름순
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(li,com);
	}

	public void save() {
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("contact.dat"));
			oos.writeObject(li);
			oos.flush(); //파이프 내 버퍼 비워주기
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void open() {
		ObjectInputStream ois = null;
		try {
			ois= new ObjectInputStream(new FileInputStream("contact.dat"));
			li=(ArrayList<Contact>)ois.readObject();
			//input일때는 flush 없다*******************
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
