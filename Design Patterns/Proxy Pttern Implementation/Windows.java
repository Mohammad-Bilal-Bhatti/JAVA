class Windows implements Os{

	protected String currentDir;

	public Windows(){
		this.currentDir = ".";  // Representing root directory.
	}

	public Windows(String cwd){
		this.currentDir = cwd;
	}

	@Override
	public String getCWD(){
		return currentDir;
	}

	@Override
	public void changeDir(String newPath){
		System.out.println("Directory Changed...");
		System.out.println("Old CWD -> " + getCWD());
		System.out.println("New CWD -> " + newPath);
		this.currentDir = newPath;
	}
	@Override
	public void open(String fileName){
		System.out.println("Filed Opened. " + fileName);
	}
	@Override
	public void rename(String oldName, String newName){
		System.out.println("File Renamed.");
		System.out.println("Old Name -> " + oldName);
		System.out.println("New Name -> " + newName);
	}
	@Override
	public void delete(String fileName){
		System.out.println("File Deleted -> " + fileName);
	}
	@Override
	public void browse(String url){
		System.out.println("Browsing -> " + url);
	}

	@Override
	public String toString(){	
		return "Windows( cwd='" + getCWD() + "' )";
	}
}