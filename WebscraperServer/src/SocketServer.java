import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
int portNo = 55555;
	
	public void runServer(){
		try{ 
			ServerSocket s = new ServerSocket(portNo);
			
			Socket client = s.accept();
			
			Thread t = new Thread(new URLRunnable(client));
			t.start();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
