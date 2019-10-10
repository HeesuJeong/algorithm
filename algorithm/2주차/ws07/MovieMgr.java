package edu.ssafy.ws07;

public class MovieMgr {
	private Movie[] mm;
	private int index=0;
	private int idx=0;
	
	private MovieMgr() {
		mm=new Movie[100];
	}
	private static MovieMgr instance;
	
	public static MovieMgr getInstance() {
		if(instance==null)
			instance=new MovieMgr();
		return instance;
	}
	
	public int showIndex() {
		return index;
	}
	public int showIdx() {
		return idx;
	}
	public void add(Movie m) {
		mm[index++]=m;
	}
	//모든 영화 리턴
	public Movie[] search() {
		System.out.println("모든 영화 출력합니다");
		return mm;
	}
	//타이틀로 검색
	public Movie[] searchTitle(String title) {
		Movie[] tmp=new Movie[index];
		idx=0;
		for (int i = 0; i < index; i++) {
			if(title.equals(mm[i].getTitle()))
				tmp[idx++]=mm[i];
		}
		return tmp;
	}
	//감독이름으로 영화정보 리턴
	public Movie[] searchDir(String dir) {
		Movie[] tmp=new Movie[index];
		idx=0;
		for (int i = 0; i < index; i++) {
			if(dir.equals(mm[i].getDirector()))
				tmp[idx++]=mm[i];
		}
		return tmp;
	}
	//장르
	public Movie[] searchGen(String gen) {
		Movie[] tmp=new Movie[index];
		idx=0;
		for (int i = 0; i < index; i++) {
			if(gen.equals(mm[i].getGenre()))
				tmp[idx++]=mm[i];
		}
		return tmp;
	}
	//입력된 제목의 영화 삭제
	public void delete(String title) {
		for (int i = 0; i < index; i++) {
			if(title.equals(mm[i].getGenre())) {
				for(int j=i+1;j<index;j++) {
					mm[j-1]=mm[j];
				}
				index--;
				i--;
			}
		}
	}
	//영화 갯수 리턴
	public int getSize() {
		return index;
	}
}
