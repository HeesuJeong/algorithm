package test;

public class DuplicateException extends Exception{
	String msgErr;
	public DuplicateException() {
		// TODO Auto-generated constructor stub
	}
	public DuplicateException(String m) {
		// TODO Auto-generated constructor stub
		msgErr=m;
	}
	public void showErr() {
		System.out.println(msgErr);
	}
}
