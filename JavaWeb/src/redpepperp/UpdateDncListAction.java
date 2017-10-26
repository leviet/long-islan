package redpepperp;
import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;  
 
public class UpdateDncListAction extends ActionSupport implements CommonConstants, SessionAware{
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private int count=0;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public UpdateDncListAction(){}

 
	public String authenticate() {
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
		 	        System.out.println(admin+",,,,"+admin.equals("zz"));
		 	        if (admin.equals("zz")) {
		 				found= "success";
		 				 m.put("w",true);
		 			} else {			 	        

		 			}      
		 	      
		 	     count++;
		 	      if(found=="success"){     
		 	    
		 	    
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
		 		   if(count==2)addActionError(getText("error.admin.login"));
		 		   else addActionError(getText("error.database.login"));
		 	   }
		 	   
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
 

}