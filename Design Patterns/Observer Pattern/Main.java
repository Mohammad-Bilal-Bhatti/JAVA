class Main{
	public static void main(String[] args) {
		
		// Creating three new Youtube Channel as an Example. 
		Channel codingGeeks = new Channel("Coding Geeks");

		Channel cyberTech = new Channel("Cyber Tech");

		Channel musicMania = new Channel("Music Manaia");

		print("Initially: ");
		print("New Channel Created -> " + codingGeeks.toString());
		print("New Channel Created -> " + cyberTech.toString());
		print("New Channel Created -> " + musicMania.toString());


		// Creating some Subscribers.
		Subscriber alee = new Subscriber("Alee");
		Subscriber smith = new Subscriber("Smith");
		Subscriber jhon = new Subscriber("Jhon");
		Subscriber jane = new Subscriber("Jane");
		Subscriber lucy = new Subscriber("Lucy");

		// Alee, Jhon, and Lucy has Subscribed to Coding Geeks Channel. 
		codingGeeks.addSubscriber(alee);
		codingGeeks.addSubscriber(jhon);
		codingGeeks.addSubscriber(lucy);

		// Alee, Simth, Jane, has Subscribed to Cyber Tech.
		cyberTech.addSubscriber(alee);
		cyberTech.addSubscriber(smith);
		cyberTech.addSubscriber(jane);


		// Music Mania is subscribed by Alee, Smith and Lucy
		musicMania.addSubscriber(alee); 
		musicMania.addSubscriber(smith); 
		musicMania.addSubscriber(lucy);

		print("");
		print("After Subscribtion: ");
		print(codingGeeks.toString());
		print(cyberTech.toString());
		print(musicMania.toString()); 


		// Displaying all Subscriber name and number of unseen Notification.

		print("");
		print(alee);
		print("Un-seen Notifications: " + alee.getUnseenNotifications());

		print("");
		print(jhon);
		print("Un-seen Notifications: " + jhon.getUnseenNotifications());

		print("");
		print(smith);
		print("Un-seen Notifications: " + smith.getUnseenNotifications());

		print("");
		print(jane);
		print("Un-seen Notifications: " + jane.getUnseenNotifications());

		print("");
		print(lucy);
		print("Un-seen Notifications: " + lucy.getUnseenNotifications());



		// Music Mania is Making a new Video called 'Song' and trying to upload it.
		Video song = new Video("Wo he khuda hai -NFAK");
		musicMania.uploadVideo(song);

		// Coding Geeks is Making a new Video Tutorial and also try to upload it on its Channel.
		Video tutorial = new Video("Introduction to Observer Design Patterns -Java");
		codingGeeks.uploadVideo(tutorial);

		// Cyber tech also uploading their new tech video.
		Video techVideo = new Video("Top 10 Programming Languages in 2020 -Languages"); 
		cyberTech.uploadVideo(techVideo);


		// After uploadation completition.
		// Displaying all Subscriber name and number of unseen Notification.	
		print("");
		print("+++++++++++++++++++++++++");
		print("After Uploading Videos.");
		print("+++++++++++++++++++++++++");
		print("");
		print(alee);
		print("Un-seen Notifications: " + alee.getUnseenNotifications());

		print("");
		print(jhon);
		print("Un-seen Notifications: " + jhon.getUnseenNotifications());

		print("");
		print(smith);
		print("Un-seen Notifications: " + smith.getUnseenNotifications());

		print("");
		print(jane);
		print("Un-seen Notifications: " + jane.getUnseenNotifications());

		print("");
		print(lucy);
		print("Un-seen Notifications: " + lucy.getUnseenNotifications());



		// Displaying All Unseen Notifications for every subscriber.
		print("");
		print("++++++++++++++++++++++++++++++++++++");
		print("Displaying All Unseen Notifications.");
		print("++++++++++++++++++++++++++++++++++++");
		print("");

		print("");
		print(alee);
		alee.showAllUnseenNotifications();

		print("");
		print(smith);
		smith.showAllUnseenNotifications();

		print("");
		print(jhon);
		jhon.showAllUnseenNotifications();

		print("");
		print(jane);
		jane.showAllUnseenNotifications();

		print("");
		print(lucy);
		lucy.showAllUnseenNotifications();




	}

	public static void print(Object s){
		System.out.println(s);
	}


}