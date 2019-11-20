import java.util.Date;
import java.text.SimpleDateFormat;  

class Video{

	public static final String format = "E, dd MMM yyyy HH:mm:ss";

	protected String name;
	protected Date uploadedDate;

	public Video(String name){
		this.name = name;
		this.uploadedDate = new Date(); // Get the system date.
	}

	public String getName(){
		return name;
	}

	public Date getUploadedDate(){
		return uploadedDate;
	}


	@Override
	public String toString(){
		return "Video(" +
			" name=" + name +
			", uploadedDate=" + new SimpleDateFormat(format).format(uploadedDate) +
		" )";
	}

}