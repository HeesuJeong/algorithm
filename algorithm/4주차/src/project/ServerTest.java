//package project;
//
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ServerTest {
//	public static void main(String[] args) {
//		ServerSocket serverSocket=null;
//		try {
//		serverSocket=new ServerSocket(8000);
//		while(true) {
//			Socket socket=serverSocket.accept();
//			Thread thread=new PerClientThread(Socket);
//			thread.start();
//		}
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//}
