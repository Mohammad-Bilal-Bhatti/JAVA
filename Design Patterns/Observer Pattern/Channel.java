import java.util.Observable;
import java.util.Observer;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.Calendar;

class Channel extends Observable{

	// Channel  --> Subject

	public static final String format = "E, dd MMM yyyy HH:mm:ss";


	protected String name;
	protected int totalSubscribers;

	// Instance Initilization Block.
	// At Starting of the Channel total subscribers will be zero.
	{
		totalSubscribers = 0;
	}

	public Channel(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public int getTotalSubscribers(){
		return totalSubscribers;
	}

	public void uploadVideo(Video video){


		// Getting String repersentation of Date.
		String uDate = new SimpleDateFormat(format).format(
								video.getUploadedDate()
							);
		String desc = "uploaded on: " + uDate;

		// Build Notification Object.
		Notification notif = new Notification(video.getName(), desc);

		notifySubscribers(notif);

	}

	/**
		Purpose: Wrapping addObserver() for better Read-ablity.
	*/
	public void addSubscriber(Observer observer){
		addObserver(observer);
		totalSubscribers++;
	}
	/**
		Purpose: Wrapping deleteObserver() for better Read-ablity.
	*/

	public void removeSubscriber(Observer observer){
		deleteObserver(observer);
		totalSubscribers--;	
	}

	/**
		Purpose: Wrapping setChange() and notifyObservers() methods for simplicity and better readability.	
	*/
	private void notifySubscribers(Notification notification){
		// Set the Flag that Subject has changed.
		setChanged();

		// Broadcase Message to All Observers. 
		notifyObservers(notification);
	}




	@Override
	public String toString(){
		return "Channel(" +
			" name=" + name +
			", totalSubscribers=" + totalSubscribers +
		" )";
	}

}






