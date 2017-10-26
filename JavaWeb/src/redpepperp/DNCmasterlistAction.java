package redpepperp;
import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;  
 
public class DNCmasterlistAction extends ActionSupport implements CommonConstants, SessionAware{
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
    private int id;
	private String name;
	private String dateassigned;
	private String comment;
	private String duedate;
	private int count=0;
	private int end=-1;
	private int end2=-1;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public DNCmasterlistAction(){}
   
   public DNCmasterlistAction(int id, String name, String dateassigned, String duedate)
   {
   	this.id = id;
   	this.name = name;
      this.dateassigned = dateassigned;
      this.duedate = duedate;
   }
   
   private List<DNCmasterlistAction> terrisassigned;
   private List<DNCmasterlistAction> terriscomment;
   private List<DNCmasterlistAction> terriscm;

 
	public String authenticate() {
		terrisassigned = new ArrayList<DNCmasterlistAction>();
		terriscomment = new ArrayList<DNCmasterlistAction>();
		terriscm = new ArrayList<DNCmasterlistAction>();
		    Connection conn = null;
		    Statement stmt = null;
		    String found="error";
		    try{
		 	      //STEP 2: Register JDBC driver
		 	      Class.forName("com.mysql.jdbc.Driver");

		 	      //STEP 3: Open a connection
		 	      System.out.println("Connecting to a selected database...");
		 	     count++;
		 	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 	      System.out.println("Connected database successfully...");
		 	      
		 	      
		 	      //STEP 4: Execute a query
		 	      //------------------------------------------------------------
		 	      System.out.println("Creating statement...");
		 	         stmt = conn.createStatement();          
		 	        
		 	         String admin=m.get('a').toString().toLowerCase().substring(0, 1);
		 	        System.out.println(admin+",,,,"+admin.equals("z"));
		 	        if (admin.equals("z")) {
		 				found= "success";
		 			} else {
			 	         System.out.print(", Name: " + admin.equals("z"));

		 			}
		 	      
		 	     count++;
		 	      if(found=="success"){
		 	      //-----------------------------------------------------
		 	     String sqlr="SELECT id, address, date, terrisnum FROM TERRIS_DNCBA";
		 	     ResultSet rsr = stmt.executeQuery(sqlr);     
		 	      //STEP 5: Extract data from result set
		 	      while(rsr.next()){
		 	         //Retrieve by column name
		 	         int id  = rsr.getInt("id");
		 	         String name = rsr.getString("address");
		 	         String dateassigned = rsr.getString("date");
		 	         String duedate = rsr.getString("terrisnum");

		 	         //Display values
		 	         System.out.println("ID: " + id);
		 	         System.out.println(", Name: " + name);
		 	         System.out.println(", Datea: " + dateassigned);
		 	        System.out.println(", Dated: " + duedate);
		 	        
		 	       terrisassigned.add(new DNCmasterlistAction(id,name,dateassigned,duedate));
		 	         
		 	      }
		 	      //---------------------------------------------------------
		 	   //-----------------------------------------------------
			 	     sqlr="SELECT id, address, date, terrisnum FROM TERRIS_DNCCM";
			 	     rsr = stmt.executeQuery(sqlr);     
			 	      //STEP 5: Extract data from result set
			 	      while(rsr.next()){
			 	         //Retrieve by column name
			 	         int id  = rsr.getInt("id");
			 	         String name = rsr.getString("address");
			 	         String dateassigned = rsr.getString("date");
			 	         String duedate = rsr.getString("terrisnum");

			 	         //Display values
			 	         System.out.println("ID: " + id);
			 	         System.out.println(", Name: " + name);
			 	         System.out.println(", Datea: " + dateassigned);
			 	        System.out.println(", Dated: " + duedate);
			 	        
			 	       terriscm.add(new DNCmasterlistAction(id,name,dateassigned,duedate));
			 	         
			 	      }
			 	      //---------------------------------------------------------
		 	      //try adding new comment
			 	     sqlr="SELECT id FROM TERRIS_COMMENT";
			 	     rsr = stmt.executeQuery(sqlr);  
		 	      if(comment!=null &&comment!=""){
		 	      while(rsr.next()){
			 	         //Retrieve by column name
			 	    	  int current=rsr.getInt("id");
			 	         if(end<current)end=current;
			 	        end2++;
			 	        System.out.println("end-----------------: " + end);
			 	       System.out.println("end2-----------------: " + end2);
			 	      } end++;
			 	      		 	      
		 	     SimpleDateFormat df= new SimpleDateFormat("d MMM, yyyy");
		 	     Date date = new Date();
		 	     String date1=df.format(date);
			    	Calendar cal = Calendar.getInstance();
			    	cal.setTime(date);
			    	cal.add(Calendar.MONTH, 3);
			    	String date2=df.format(cal.getTime());
			    	String table= m.get('a').toString();
		 	     
		 	     // Insert comment into table
		 	       sqlr = "INSERT INTO TERRIS_COMMENT VALUES ("+(end)+",'"+m.get("a")+"', '"+comment+"', '"+date1+"')";
		 	      stmt.executeUpdate(sqlr);
		 	    }
		 	     //-----------------------------------------------------
			 	     sqlr="SELECT id, user, comment, date FROM TERRIS_COMMENT";
			 	     rsr = stmt.executeQuery(sqlr);     
			 	      //STEP 5: Extract data from result set
			 	      while(rsr.next()){
			 	         //Retrieve by column name
			 	         int id  = rsr.getInt("id");
			 	         String name = rsr.getString("user");
			 	         String dateassigned = rsr.getString("comment");
			 	         String duedate = rsr.getString("date");

			 	         //Display values
			 	         System.out.println("ID: " + id);
			 	         System.out.println(", Name: " + name);
			 	         System.out.println(", comment: " + dateassigned);
			 	        System.out.println(", datecomment: " + duedate);
			 	        
			 	       terriscomment.add(new DNCmasterlistAction(id,name,dateassigned,duedate));
			 	         
			 	      }Collections.reverse(terriscomment);
		 	      rsr.close();
		 	      }
		 	      //--------------------------------------------------------------
		 	   }catch(SQLException se){
		 	      //Handle errors for JDBC
		 	      se.printStackTrace();
		 	   }catch(Exception e){
		 	      //Handle errors for Class.forName
		 	      e.printStackTrace();
		 	   }finally{
		 	      //finally block used to close resources
		 	      try{
		 	         if(stmt!=null)
		 	            conn.close();
		 	      }catch(SQLException se){
		 	      }// do nothing
		 	      try{
		 	         if(conn!=null)
		 	            conn.close();
		 	      }catch(SQLException se){
		 	         se.printStackTrace();
		 	      }//end finally try
		 	   }//end try
		 	   System.out.println("Goodbye!");
		 	   if(found=="error" ) {
		 		   if(count==2)addActionError(getText("error.dnc.login"));
		 		   else addActionError(getText("error.database.login"));
		 	   }
		 	  System.out.println(m.get('a'));
		 	 System.out.println(m.get('b'));
		 	System.out.println(comment);
		 	   return found;
		
	}
	
	public String logout(){  
	    if(m!=null){  
	        m.remove("a");
	        m.remove("b"); 
	    }
	    addActionError(getText("success.logout"));
	    return "success";  
	}
 
	public String getUsername() {
		return m.get("a").toString();
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComment() {
		return comment;
	}
 
	public void setComment(String comment) {
		this.comment = comment;
	}
	  
		   public int getId() {
			      return id;
			   }
			   public void setId(int id) {
			      this.id = id;
			   }  
	 
		   public String getName() {
			      return name;
			   }
			   public void setName(String name) {
			      this.name = name;
			   }
			   public String getDateassigned() {
			      return dateassigned;
			   }
			   public void setDateassigned(String dateassigned) {
			      this.dateassigned = dateassigned;
			   }
			   
			   public String getDuedate() {
				      return duedate;
				   }
				   public void SetDuedate(String duedate) {
				      this.duedate = duedate;
				   }
				   public List<DNCmasterlistAction> getTerrisassigned() {
					      return terrisassigned;
					   }
				   public void setTerrisassigned(List<DNCmasterlistAction> terriscomment) {
				          this.terriscomment = terriscomment;
				   }
					   public void setTerriscomment(List<DNCmasterlistAction> terriscomment) {
					          this.terriscomment = terriscomment;
					   }
					   public List<DNCmasterlistAction> getTerriscomment() {
						      return terriscomment;
						   }
					   public void setTerriscm(List<DNCmasterlistAction> terriscm) {
					          this.terriscm = terriscm;
					   }
					   public List<DNCmasterlistAction> getTerriscm() {
						      return terriscm;
						   }

}