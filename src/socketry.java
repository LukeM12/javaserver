import java.net.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;


public class socketry {
	private boolean is_connected;
	private int port;
	private InetAddress ip_addr;	
	FileOutputStream debug;
	ServerSocket serv;
	
	public socketry(boolean is_connected, int port, String filename){
		this.is_connected = is_connected;
		this.port = port;
		/*This should rarely fail but if it does it should need to attempt at least to make a default named file*/
		try { 
			this.debug = new FileOutputStream(filename + ".txt");
		}
		catch (Exception file_){
			System.out.print("Debug file not initialized");
		}
		/*This one however may fail, and may need interactive testing to get the user to enter just a different port number*/
		try {
			this.serv = new ServerSocket(this.port);			
			//Enter the what if scenerio here. The catch will input it to the Debug file. Possibly it can either notify " Hey I am using another port or something
		}
		catch (Exception main_){
			System.out.print("Server socket not initialized");
		}
		
	}
	
	public void port_scan(){
		try {
			ServerSocket serv = new ServerSocket(this.port);
			//Socket skt = serv.accept();
			System.out.print("Socket was made\n");
			//skt.close();
			serv.close();
			
		}
		catch (Exception e ){
			System.out.print("ERROR : Socket was not made");
		}
		return;
	}
	
	public void get_local_ip(){
		try {
			ServerSocket serv = new ServerSocket(this.port);
			System.out.print("Local IP is " + serv.getInetAddress() + '\n');
			this.ip_addr = serv.getInetAddress();
			return;
		}
		catch (Exception socket){
			System.out.print("Socket problem");  //FIXME - Toss these into a debug file
			return;
		}
		
	}

	
	public static void main(String args[]){
		socketry a = new socketry(true, 1234, "anyname");
		a.port_scan();
		a.get_local_ip();


	}
		
}
