import java.util.ArrayList;

public class URLCache {
	
	public ArrayList<URLObject> pages = new ArrayList<URLObject>();
	
	//method to search cache array for givel url and to output html
	public synchronized String searchCache(String url){
		String response = "";
		for (int i=0; i<pages.size(); i++){
			URLObject u = (URLObject)pages.get(i);
			if (u.url.equals(url)) {
				response = u.html;
				break;
			}
		}
		return response;
	}
	
	// method to add to array
	public synchronized void addToCache(String url){
		URLObject uo = new URLObject(url);
		uo.html = uo.getHTML();
		// check if array already contains url in order to just replace html (set) or to add it.
		if (pages.contains(url)){
			pages.set(pages.indexOf(url), uo);
		}
		else{
			pages.add(uo);
		}
		
	}
}
