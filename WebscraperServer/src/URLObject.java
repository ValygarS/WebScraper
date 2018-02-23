import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLObject {
	
	public String url;
	public String html;
	
	// constructor
	public URLObject(String url_request){
		
		this.url = url_request;
		
	}
	
	// gets html from the web
	public String getHTML(){
		String tmp_html = "";
		try{
			URL u = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
			
			String inputLine;
			while((inputLine = in.readLine()) != null){
				//System.out.println(inputLine);
				tmp_html = tmp_html + inputLine;
			}
			in.close();
			}catch(Exception e){
			System.out.println("Get HTML Page Error!");
		}
		return tmp_html;
		
	}
	

}
