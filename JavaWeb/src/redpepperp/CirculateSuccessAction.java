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

public class CirculateSuccessAction extends ActionSupport implements CommonConstants, SessionAware{
 
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
	private String terrisname2;
	private boolean insertsuccess=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public CirculateSuccessAction(){}
   
   public CirculateSuccessAction(int id, String name, String dateassigned, String duedate)
   {
   	this.id = id;
   	this.name = name;
      this.dateassigned = dateassigned;
      this.duedate = duedate;
   }
   
   private List<CirculateSuccessAction> terrisassigned;

 
	public String execute() {
		terrisassigned = new ArrayList<CirculateSuccessAction>();
		    Connection conn = null;
		    Statement stmt = null;
		    String found="error";
		    
	         String admin=m.get('a').toString().toLowerCase().substring(0, 2);
	         System.out.println(admin+"---"+admin.equals("zz"));
	         if (admin.equals("zz")) {		    
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
		 	       			 	    
		 	      String terristable = terrisname.substring(0,terrisname.lastIndexOf("-"));
		 	             terristable = terristable.replaceAll("[0-9]","");

		 	     // change status to Yes
		 	     //------------------------------------------------------------
			 	     String sql="SELECT id FROM TERRIS_"+m.get('a');
			 	     ResultSet rs = stmt.executeQuery(sql);   
                //sql = "REPLACE INTO TERRIS_"+terristable+" VALUES (" + password + ",'"+terrisname+ "', 'Yes', '"+terrisname2+"')";
                  sql="UPDATE TERRIS_"+terristable+"  SET status ='Yes'  WHERE name in ('"+terrisname+"')";
			 	 System.out.println(sql);
		 	     stmt.executeUpdate(sql);
		 	    System.out.println("Territory circulation successful");		 	     
		          count++;
		          found="success";
		 	      rs.close();
		 	      //-------------------------------------------------------------------
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
	public String getTerrisname2() {
		return terrisname2;
	}
 
	public void setTerrisname2(String terrisname2) {
		this.terrisname2 = terrisname2;
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
				   public List<CirculateSuccessAction> getTerrisassigned() {
					      return terrisassigned;
					   }
					   public void setTerrisassigned(List<CirculateSuccessAction> terrisassigned) {
					          this.terrisassigned = terrisassigned;
					   }
					   
}