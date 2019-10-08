package 상호배타집합;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("input.txt")));
		for(int i = 1; i <= 50000; i++) {
			bw.write(1 + " " + (i) + "\n");
		}
		for(int i = 1; i <= 50000; i++) {
			bw.write(2 + " " + (i) + "\n");
		}
		bw.flush();
	}
}
