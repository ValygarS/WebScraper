import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class URLRunnable implements Runnable {
	
	protected Socket clientConnection;
	private BufferedReader in;
	private PrintWriter out;
	
	public URLRunnable(Socket connection){
		this.clientConnection = connection;
	}
	
	public void run(){
		try{
			in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
			out = new PrintWriter(clientConnection.getOutputStream(), true);
			
			// Server started
			System.out.println("Server started");
			
			// URL Request
			String url = in.readLine();
			URLObject uo = new URLObject(url);
			URLCache ucache = new URLCache();
			// adding to cache
			ucache.addToCache(url);	
			
			// No_Cache variable
			Boolean No_Cache = true;
			// get choice from client
			No_Cache = Boolean.valueOf(in.readLine());
			
			if(No_Cache){	
				out.println(uo.getHTML());
			}
			else{
				out.println(ucache.searchCache(url));
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
