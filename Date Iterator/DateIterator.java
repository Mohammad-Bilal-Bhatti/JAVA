import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateIterator {

    private Date currentDate;  // Points the Current System Date.
    private Date pointingDate;  // Points the Date when Navigate between different Dates. 


    public DateIterator() {
    	/*
		*   Purpose: Default Constructor, Inilialize the Object with the current system date and time
    	*/

        Date date = new Date(System.currentTimeMillis());  // Get the Date Object, Using System current time

        // Initilize the Current Date and Pointing Date Fileds.	
        this.currentDate = date;
        this.pointingDate = date;
    }

    public Date getDate() {
    	/*
		*   Purpose: Returns the pointingDate 
		*   Parms: none
		*	Returns: java.util.Date
    	*/	
        return pointingDate;
    }

    public Date now() {
    	/**
		*   Purpose: Return the current Date
		*   Parms: none
		*   Returns: java.util.Date 
    	*/
        return currentDate;
    }


    public Date next() {
    	/*
		*   Purpose: Compute the next date, after pointing date and return that Date
		*   Parms: none
		*   Return java.util.Date 
    	*/
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(pointingDate);
        calendar.add(Calendar.DATE, 1);

        pointingDate = calendar.getTime();
        return pointingDate;

    }


    public Date previous() {
    	/*
		*   Purpose: Compute the previous date, before pointing date and return that Date
		*   Parms: none
		*   Return java.util.Date 
    	*/
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(pointingDate);
        calendar.add(Calendar.DATE, -1);

        pointingDate = calendar.getTime();
        return pointingDate;
    }

    public String toString(){
    	String s = "DateIterator( currentDate="+currentDate+", pointingDate="+pointingDate+" )";
    	return s; 
    } 
}
