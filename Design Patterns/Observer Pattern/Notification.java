class Notification implements Cloneable{
	protected String title;
	protected String description;
	protected boolean seen;

	// Instance initilization Block.
	{
		seen = false; // By default the notification seen is set to false.
	}


	public Notification(String title, String description){
		this.title = title;
		this.description = description;
	}

	public boolean isSeen(){
		return seen;
	}

	public void show(){
		System.out.println( "Title: " + title + " Description: " + description );
		seen = true;	// After show() the notification is now seen by the user.
	}

	public String toString(){
		return "Notificaiton(" + 
			" title=" + title +
			", description=" + description +
			", seen=" + seen +
		" )";
	}

	public Object clone() throws CloneNotSupportedException{
		// Return new Notification Object with same info.
		return new Notification(this.title, this.description);
	}

}