import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portNo = 55555;
		String ipAddress = "127.0.0.1";
		
		Socket clientSocket;
		
		BufferedReader in;
		PrintWriter out;
		InputStreamReader ir;
		
		try{
			clientSocket = new Socket(ipAddress, portNo);
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			ir = new InputStreamReader(clientSocket.getInputStream());
			
			in = new BufferedReader(ir);
			
			BufferedReader userConsoleIn = new BufferedReader(new InputStreamReader(System.in));
			// sending data vars to server
			System.out.println("Enter HTML:");
			String html = userConsoleIn.readLine(); 
			out.println(html);
			
			System.out.println("No cache? (True/False)");
			String no_cache = userConsoleIn.readLine().toLowerCase();
			// validate user input
			while (!no_cache.equals("true") && !no_cache.equals("false")){
				System.out.println("Please enter True or False");
				no_cache = userConsoleIn.readLine().toLowerCase();
			}
			out.println(no_cache);
			// getting response from server
			System.out.println("Server answer: " + in.readLine());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}


}


