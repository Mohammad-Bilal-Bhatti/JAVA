class ObjectMaker implements Runnable{

	private String name;

	public ObjectMaker(String name){
		this.name = name;
		System.out.println(name + " Created.");
	}

	@Override
	public void run(){
		System.out.println(name + " Now Started Running !");
		// Run an infinite loop...
		while ( true ){
			// Create Singleton Object.
			Singleton instance = Singleton.getInstance();
			// Print the instance count...
			System.out.println(name + " Says: Total Singleton Intances: " + Singleton.getInstanceCount()); 
		}
	}

	
}