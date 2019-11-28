class Client{
	public static void main(String[] args) {
		
		// This server is encapsulating an Os inside it.
		ProxyServer server = new ProxyServer();

		System.out.println(server);

		// Change the Current Working Direcory
		server.changeDir("C://Windows/System32/");       // Navagating to Some else dir. 

		// Opening the File.
		server.open("cmd.exe"); 

		// Trying to Renaming the File.
		server.rename("cmd.exe", "cms.exe");

		// Trying to Deleting the File.
		server.delete("cmd.ext");

		// Browsing Google.com
		server.browse("www.google.com");

		// Browsing playcode.io
		server.browse("playcode.io");

		// Browsing facebook.com
		server.browse("www.facebook.com");


	}
}