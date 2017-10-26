package redpepperp.model;
import java.text.*;
import java.util.*;

public class ReturnTerrisModel {

    
   private String message;
   private String[] terrisNum;
   private String customDate;
   private String dueDateString;
   private int sizeOnHand=6;
   private boolean overDue=false;
   
    
   public ReturnTerrisModel() {
        
       setMessage("The following territories are currently in your possession.");
       setTerrisNum(terrisNum);            
       setCustomDate(customDate); 
       setDueDateString(dueDateString);
   }

   public String getMessage() {

       return message;
   }

   public void setMessage(String message) {

       this.message = message;
   }
   
   public boolean getOverDue() {

       return overDue;
   }

   public void setOverDue(boolean overDue) {

       this.overDue = overDue;
   }
   
   public  String getCustomDate() {

       return customDate;
   }

   public void setCustomDate(String customDate) {
	   GregorianCalendar due= new GregorianCalendar(2015,Calendar.MARCH,1); 
       Date d = due.getTime();
       SimpleDateFormat df= new SimpleDateFormat("d MMM, yyyy");
       this.customDate = df.format(d);
   }

   public String getDueDateString() {

       return dueDateString;
   }

   public void setDueDateString(String dueDateString) {
	   SimpleDateFormat df= new SimpleDateFormat("d MMM, yyyy");
	    try
	    {
	    	Date date=df.parse(getCustomDate());
	    	Date current= new Date();
	    	
	    	if(date.compareTo(current)<0) overDue=true;
	    	
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(date);
	    	cal.add(Calendar.MONTH, 2);
	    	this.dueDateString=df.format(cal.getTime());
	    }
	    catch(ParseException e)
	    {
	    	e.printStackTrace();
	    }
	    

   }
   
   public String[] getTerrisNum() {

       return terrisNum;
   }

   public void setTerrisNum(String[] terrisNum) {

       terrisNum = new String[sizeOnHand];
       terrisNum[0]="BA-23";
       terrisNum[1]="CM-17";
       terrisNum[2]="LF-33";
       terrisNum[3]="CT-8";
       terrisNum[4]="MN-12";
       terrisNum[5]="RS-38";
       this.terrisNum = terrisNum;
       
       
   }
}
