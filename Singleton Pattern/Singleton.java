class Singleton{

	// Thread Safe Singleton Class...

	private static Singleton instance = null;	// INSTANCE.
	private static int instanceCount = 0;		// COUNTER.

	private static Object threadSafe = Singleton.class;

	private Singleton(){

		// increment every time the constructor is being called !
		instanceCount++;	
	}

	public static Singleton getInstance(){
		synchronized(threadSafe){
			if(instance == null){
				instance = new Singleton();
			}
			return instance;
		}
	}

	public static int getInstanceCount(){
		return instanceCount;
	}
}