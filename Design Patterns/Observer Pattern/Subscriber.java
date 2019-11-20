import java.util.Observer;
import java.util.Observable;
import java.util.List;
import java.util.ArrayList;

class Subscriber implements Observer{
	protected String name;
	protected List<Notification> notifications;

	// Instance Initilization Block.
	{
		// Notifications list will be empty for the subscirber creation time.
		notifications = new ArrayList<>();
	}

	public Subscriber(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	private void addNotification(Notification notification){
		try{
			notifications.add((Notification)notification.clone());
		}catch(CloneNotSupportedException notSupportException){
			System.out.println("Clone Not Supported!");
		}
	}

	public int getUnseenNotifications(){
		int unseenCount = 0;
		// For each notification in notification list.
		for(Notification n : notifications){
			if(! n.isSeen())	// If not seen.
				unseenCount++;
		}
		return unseenCount;
	}

	public void displayNotification(int index){
		// If index is less than zero OR greater and euqual then the size of the list.
		if(index < 0 || index >= notifications.size()){
			System.out.println("Please select correct order index.");
			return;
		}

		Notification n = notifications.get(index);

		n.show();	// Show the notification to the user.
	}

	public void showAllUnseenNotifications(){
		// Iterate for each Notification in notification list. 
		for( Notification n : notifications ){
			// check for not seen.
			if( ! n.isSeen() ){
				n.show();			// Display that Notification.
			}
		}
	}



	@Override
	public void update(Observable observable, Object object){

		// Cast Objects to their relevant DataTypes.
		Channel channel = (Channel) observable;
		Notification notification = (Notification) object;
		
		// Add the notification to the notifications list.
		addNotification(notification);	
	}

	@Override
	public String toString(){
		return "Subscriber(" +
			" name=" + name +
		" )";
	} 

}