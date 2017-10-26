package redpepperp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.*;
import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class AssignTerrisAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private GetTerrisModel messageStore;
	private String username;
	private String password;
    private int id;
	private String name;
	private String dateassigned;
	private String duedate;
	private int count=0;
	private int end=-1;
	private int end2=-1;
	private String terrisname;
	private String terrisname1;
	private boolean insertsuccess=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public AssignTerrisAction(){}
   
   public AssignTerrisAction(int id, String name, String dateassigned, String duedate)
   {
   	this.id = id;
   	this.name = name;
      this.dateassigned = dateassigned;
      this.duedate = duedate;
   }
   
   private List<AssignTerrisAction> terrisassigned;

 
	public String execute() {
		terrisassigned = new ArrayList<AssignTerrisAction>();
		    Connection conn = null;
		    Statement stmt = null;
		    String found="error";
		    

 	         if( (m.get('a'))!=null){
 	        	 
 	 	          m.put("c",password);
 	 	          m.put("d",terrisname);
 	        	 
		   try{
		 	      //STEP 2: Register JDBC driver
		 	      Class.forName("com.mysql.jdbc.Driver");

		 	      //STEP 3: Open a connection
		 	      System.out.println("Connecting to a selected database...");
		 	     count++;
		 	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 	      System.out.println("Connected database successfully...");
		 	      
		 	      
		 	      //STEP 4: Execute a query
		 	         stmt = conn.createStatement(); 
		 	      //------------------------------------------------------------
			 	     String sql="SELECT id FROM TERRIS_"+m.get('a');
			 	     ResultSet rs = stmt.executeQuery(sql);     
			 	      //STEP 5: Extract data from result set
			 	      while(rs.next()){
			 	         //Retrieve by column name
			 	    	  int current=rs.getInt("id");
			 	         if(end<current)end=current;
			 	        end2++;
			 	        System.out.println("end-----------------: " + end);
			 	       System.out.println("end2-----------------: " + end2);
			 	      } end++;
			 	     
		 	    if(end2<2){  		 	      
		 	     SimpleDateFormat df= new SimpleDateFormat("d MMM, yyyy");
		 	     Date date = new Date();
		 	     String date1=df.format(date);
			    	Calendar cal = Calendar.getInstance();
			    	cal.setTime(date);
			    	cal.add(Calendar.MONTH, 3);
			    	String date2=df.format(cal.getTime());
			    	String table= m.get('a').toString();
		 	     
		 	     // Insert territory into publishers table
		 	       sql = "INSERT INTO TERRIS_"+m.get('a')+" VALUES ("+end+",'"+terrisname+"', '"+date1+"', '"+date2+"')";
		 	      stmt.executeUpdate(sql);
		 	     System.out.println("Inserted--------------, " +terrisname+"at"+ end);
		 	     //------------------------------------------------------------------
		 	      //change status to No
		 	      String terristable = terrisname.substring(0,terrisname.lastIndexOf("-"));
		 	             terristable = terristable.replaceAll("[0-9]","");
		 	     //REPLACE record
		 	       sql = "REPLACE INTO TERRIS_"+terristable+" VALUES ("+password+",'"+terrisname+"', 'No', '"+date1+"')";
		 	      System.out.println(sql);
		 	       stmt.executeUpdate(sql);
		 	     System.out.println("Inserted--------------, " +terrisname+"at"+ password);
		 	     	insertsuccess=true;	 	     
		 	     
		   }     count++;
		 	      rs.close();
		 	      
		 	      //-----------------------------------------------------
		 	     String sqlr="SELECT id, terrisname, dateassigned, duedate FROM TERRIS_"+m.get('a');
		 	     ResultSet rsr = stmt.executeQuery(sqlr);     
		 	      //STEP 5: Extract data from result set
		 	      while(rsr.next()){
		 	         //Retrieve by column name
		 	         int id  = rsr.getInt("id");
		 	         String name = rsr.getString("terrisname");
		 	         String dateassigned = rsr.getString("dateassigned");
		 	         String duedate = rsr.getString("duedate");

		 	         //Display values
		 	         System.out.println("ID: " + id);
		 	         System.out.println(", Name: " + name);
		 	         System.out.println(", Datea: " + dateassigned);
		 	        System.out.println(", Dated: " + duedate);
		 	        
		 	       terrisassigned.add(new AssignTerrisAction(id,name,dateassigned,duedate));
		 	      found="success";
		 	      }
		 	      rsr.close();
		 	      
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
		 		   if(count==2)addActionError(getText("error.login"));
		 		   else addActionError(getText("error.database.login"));
 	         } 
 	         }   
 	        else   addActionError(getText("error.get"));
		 	   
		 	  System.out.println(m.get('a'));
		 	 System.out.println(m.get('b'));
		 	System.out.println(m.get('c'));
		 	System.out.println(m.get('d'));
		 	System.out.println(insertsuccess);
		 	
		 	   return found;
		
	}
	
	public String logout(){  
	    if(m!=null){  
	        m.remove("a");
	        m.remove("b");
	        m.remove("c");
	        m.remove("d");
	    }
	    addActionError(getText("success.logout"));
	    return "success";  
	}
 
	public String getUsername() {
		return username.toUpperCase();
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
	
	public String getTerrisname() {
		return terrisname;
	}
 
	public void setTerrisname(String terrisname) {
		this.terrisname = terrisname;
	}
	public String getTerrisname1() {
		return terrisname1;
	}
 
	public void setTerrisname1(String terrisname1) {
		this.terrisname1 = terrisname1;
	}
	
	public boolean getInsertsuccess() {
		return insertsuccess;
	}
 
	public void setInsertsuccess(boolean insertsuccess) {
		this.insertsuccess = insertsuccess;
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
				   public List<AssignTerrisAction> getTerrisassigned() {
					      return terrisassigned;
					   }
					   public void setTerrisassigned(List<AssignTerrisAction> terrisassigned) {
					          this.terrisassigned = terrisassigned;
					   }
					   
}