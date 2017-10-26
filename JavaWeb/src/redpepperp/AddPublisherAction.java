package redpepperp;
import java.sql.*;
import java.util.Collections;
import java.util.Map;




import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class AddPublisherAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int count=0;
	private int end=-1;
	private boolean insertsuccess=false;
	private boolean alreadyexist=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public AddPublisherAction(){}
   
 
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
		 	         
		 	        //-----------------------check if user already exist -----------------
		 	        String sqlr="SELECT username FROM TERRIS_LOGIN";
			 	    ResultSet rsr = stmt.executeQuery(sqlr);     
			 	      //STEP 5: Extract data from result set
			 	      while(rsr.next()){
			 	         //Retrieve by column name			 	        
			 	         String usernamecurrent = rsr.getString("username");
			 	         //Display values
			 	         System.out.println("Username: " + usernamecurrent);
			 	        if(usernamecurrent.equals(username)){
			 	        	alreadyexist=true;
			 	        	found ="alreadyexist";addActionError(getText("error.addalreadyexist"));
			 	        	break;
			 	        	}
			 	      }
			 	      rsr.close();
		 	       //----------------------------------------------------------------- 
			 	      if(!alreadyexist){
		 	      //------------------------------------------------------------add user
		 	        String sql="SELECT id FROM TERRIS_LOGIN";
			 	     ResultSet rse = stmt.executeQuery(sql);     
			 	      //STEP 5: Extract data from result set
			 	      while(rse.next()){
			 	         //Retrieve by column name
				 	         end++;
					 	        System.out.println("end-----------------: " + end);		 	         
			 	      } end++;
			 	      		 	      
		 	       sql = "INSERT INTO TERRIS_LOGIN VALUES ("+end+",'"+username+"', '"+password+"')";
		 	      stmt.executeUpdate(sql);
		 	     System.out.println("Inserted-------, " +username+" at "+ end+" on TERRIS_LOGIN");
		 	   //--------------create table for user logs
		 	     sql = "CREATE TABLE TERRIS_"+username.toUpperCase()+
		                   " (id INTEGER not NULL, " +
		                   " terrisname VARCHAR(255), " + 
		                   " dateassigned VARCHAR(255), " + 
		                   " duedate VARCHAR(255), " +
		                   " PRIMARY KEY ( id ))"; 
		      System.out.println(sql);
		      stmt.executeUpdate(sql);
                 count++;
		 	     rse.close();
		 	     	insertsuccess=true;
		 	     	found="success";
		   }//end if !alreadyexistfalse
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
	

	public boolean getInsertsuccess() {
		return insertsuccess;
	}
 
	public void setInsertsuccess(boolean insertsuccess) {
		this.insertsuccess = insertsuccess;
	}
		  

}