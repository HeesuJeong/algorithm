package test;

public class CodeNotFoundException extends Exception{
	String msgErr;
	public CodeNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public CodeNotFoundException(String m) {
		// TODO Auto-generated constructor stub
		msgErr=m;
	}
	public void showErr() {
		System.out.println(msgErr);
	}
}
