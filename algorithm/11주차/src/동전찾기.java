import java.util.Arrays;

public class 동전찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cntOne = new int[200];
		for (int i = 0; i < cntOne.length; i++) {
			cntOne[i] = i;
		}
		int[] cntFour = new int[200];
		for (int i = 0; i < cntFour.length; i++) {
			if (i >= 4) {
				cntFour[i]=Math.min(cntFour[i-4]+1, cntOne[i]);
			}
			else cntFour[i] = cntOne[i];
		}
		int[] cntSix = new int[200];
		for (int i = 0; i < cntSix.length; i++) {
			if (i >= 6) {
				cntSix[i]=Math.min(cntSix[i-6]+1, cntFour[i]);
			}
			else cntSix[i] = cntFour[i];
		}
	System.out.println(cntSix[178]);
	}

}
