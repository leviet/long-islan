package redpepperp;
import java.sql.*;
import java.util.Map;


import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePassSuccessAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private String currentpassword;
	private String newpassword;
	private int count=0;
	private int end=-1;
	private boolean insertsuccess=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public ChangePassSuccessAction(){}
   
 
	public String execute() {

		    Connection conn = null;
		    Statement stmt = null;
		    String found="error";
		    
 	         if(m.get('a')!=null){
 	        	System.out.println("id"+m.get('y')+currentpassword +m.get('b'));System.out.println(currentpassword.equals(m.get('b')));
 	        	 if(currentpassword.equals(m.get('b'))==false){found ="passmismatch";addActionError(getText("error.pass"));}
 	        	 else{
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
			 	     ResultSet rse = stmt.executeQuery(sql);     
			 	      //STEP 5: Extract data from result set
			 	      		 	      
		 	       sql = "REPLACE INTO TERRIS_LOGIN VALUES (" + m.get('y')+ ",'"+m.get('z')+ "', '"+newpassword+"')";
		 	      System.out.println(sql);
		 	      stmt.executeUpdate(sql);
		 	     System.out.println("Inserted-------, " +newpassword+" at "+ m.get('y')+" on TERRIS_LOGIN");
                 count++;
		 	     rse.close();
		 	     	insertsuccess=true;
		 	     	found="success";

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
 	        	 }//else
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
 
	public String getCurrentpassword() {
		return currentpassword;
	}
 
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
 
	public String getNewpassword() {
		return newpassword;
	}
 
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	

	public boolean getInsertsuccess() {
		return insertsuccess;
	}
 
	public void setInsertsuccess(boolean insertsuccess) {
		this.insertsuccess = insertsuccess;
	}
		  

}