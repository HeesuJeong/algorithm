
public class 문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hello World 0_0 welcome to hell 8_8";
		
		//문자열을 문자의 배열로 변환
		char[] ch_arr=str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i); //한글자를 char형으로 주어오는 charAt
			if(Character.isDigit(c)) System.out.println(c+" 는 숫자입니다.");
		}
	}

}
