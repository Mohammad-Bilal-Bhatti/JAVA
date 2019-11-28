class ProxyServer implements Os{

	public static String[] blockedURLs = new String[]{
		"www.facebook.com",
		"www.youtube.com",
		"www.twitter.com",
		"www.instagram.com"
	};

	// Encapsulating OS inside self.
	private Os runningOs; // Repensents any Os either Windows or another Proxy Server.

	public ProxyServer(){
		this.runningOs = new Windows(); // A new Operating System is Running on Proxy Server.
	}

	@Override
	public String getCWD(){
		return runningOs.getCWD();
	}
	@Override
	public void changeDir(String newPath){
		runningOs.changeDir(newPath);
	}
	@Override
	public void open(String fileName){
		runningOs.open(fileName);
	}
	@Override
	public void rename(String oldName, String newName){
		// Access Control Logic.
		System.out.println("You Have Not The Permission to Rename The File.");
	}
	@Override
	public void delete(String fileName){
		// Access Control Logic.
		System.out.println("You Have Not The Permission to Delete The File.");
	}
	@Override
	public void browse(String url){
		for ( String b_url : blockedURLs ){
			// Access Control Logic.
			if ( url ==  b_url ){
				System.out.println(url+" is Blocked! Can\'t access it.");
				return; // If any of the URL matched with the Blocked URL.
			}
		}
		runningOs.browse(url);  // Browse that file.
	}

	@Override
	public String toString(){
		return "ProxyServer( cwd='" + getCWD() + "' )"; 
	}
	
}