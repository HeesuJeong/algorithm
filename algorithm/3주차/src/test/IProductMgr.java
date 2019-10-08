package test;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IProductMgr {
	public void readFile() throws FileNotFoundException, IOException, ClassNotFoundException;
	public void writeFile() throws FileNotFoundException, IOException;
	public void sort();
	public void showAll();
}
