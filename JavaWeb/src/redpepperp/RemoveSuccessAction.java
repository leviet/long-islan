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

public class RemoveSuccessAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
    private int id;
    private int count =0;
	private String terrisname;
	private boolean insertsuccess=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public RemoveSuccessAction(){}
 

	public String execute() {
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
		 	      //------------------------------------------------------------
			 	     String sql="SELECT id FROM TERRIS_LOGIN";
			 	     ResultSet rs = stmt.executeQuery(sql);     
			 	      //STEP 5: Extract data from result set
			 	     
		 	      //delete record first
		 	      sql = "DELETE FROM TERRIS_LOGIN  WHERE id = "+password;
		 	     stmt.executeUpdate(sql);
		 	    System.out.println("Deleted--------------, " +terrisname+" record at"+ password);
		 	    
		 	      //delete user table 
		 	      sql = "DROP TABLE TERRIS_"+terrisname.toUpperCase();
		 	     System.out.println(sql);
		 	     stmt.executeUpdate(sql);
		 	    
	            
		 	     
		       count++;
		       found="success";
		 	      rs.close();
		 	      
		 	     
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
		return username;
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
	 
					   
}