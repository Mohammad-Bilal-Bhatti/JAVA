public class Client{
	public static void main(String[] args){
		
		// Initilizing ObjectMaker Runnable instances.  
		ObjectMaker maker_1 = new ObjectMaker("Maker 1");
		ObjectMaker maker_2 = new ObjectMaker("Maker 2");

		// Making the thread Objects.
		Thread thread_1 = new Thread(maker_1);
		Thread thread_2 = new Thread(maker_2);
		// Starting the Threads.
		thread_1.start();

		thread_2.start();


	}
}