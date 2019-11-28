interface Os{

	public String getCWD();
	public void changeDir(String newPath);
	public void open(String fileName);
	public void rename(String oldName, String newName);
	public void delete(String fileName);
	public void browse(String url);

}