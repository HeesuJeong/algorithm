package test;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productMgrlmpl pm=productMgrlmpl.getinstance();
		pm.showAll();
		System.out.println("=========");
		pm.sort();
		pm.showAll();
	}

}
