package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class productMgrlmpl extends Product implements IProductMgr{

	private ArrayList<Product> li;
	
	
	private productMgrlmpl() {
		// TODO Auto-generated constructor stub
		li=new ArrayList<>();
		try {
			writeFile();
			readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	private static productMgrlmpl instance;
	
	public static productMgrlmpl getinstance() {
		if(instance==null) instance=new productMgrlmpl();
		return instance;
	}
	
	@Override
	public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("product.dat"));
		li=(ArrayList<Product>)ois.readObject();
		ois.close();
	}

	@Override
	public void writeFile() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Product> tmp=new ArrayList<>();
		tmp.add(new TV(111,"abc",1000,10,11));
		tmp.add(new TV(222,"azb",3000,10,11));
		tmp.add(new TV(111,"aza",2000,10,11));
		tmp.add(new Refrigerator(111,"ba",1000,10,600));
		tmp.add(new Refrigerator(111,"az",1000,10,60));
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("product.dat"));
		oos.writeObject(tmp);
		oos.close();
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Comparator<Product> com=new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(li,com);
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}

}
