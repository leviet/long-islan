package redpepperp;
import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;  
 
public class LoginAction extends ActionSupport implements CommonConstants, SessionAware{
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
	private String duedate;
	private int count=0;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public LoginAction(){}
   
   public LoginAction(int id, String name, String dateassigned, String duedate)
   {
   	this.id = id;
   	this.name = name;
      this.dateassigned = dateassigned;
      this.duedate = duedate;
   }
   
   private List<LoginAction> terrisassigned;

 
	public String authenticate() {
		terrisassigned = new ArrayList<LoginAction>();
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
		 	         String sql="SELECT id, username, password FROM TERRIS_LOGIN";
		 	                ResultSet rs = stmt.executeQuery(sql);     
		 	     
		 	   		    if(m.get('a')!=null){found= "success";}//already logged on
		 			    else{//never logged on
		 	      //STEP 5: Extract data from result set
		 	      while(rs.next()){
		 	         //Retrieve by column name
		 	         int idc  = rs.getInt("id");
		 	         String logname = rs.getString("username");
		 	         String logpass = rs.getString("password");

		 	         //Display values
		 	         System.out.print("ID: " + idc);
		 	         System.out.print(", Name: " + logname);
		 	         System.out.print(", Password: " + logpass);
		 	         
		 	        if (this.username.equals(logname)&& this.password.equals(logpass)) {
		 	        m.put("a",username.toUpperCase());
		 	        m.put("b",password);
		 	        m.put("y",idc);
		 	        m.put("z",username);
		 				found= "success";
		 				break;
		 			} else {
			 	         System.out.print("ID: " + id);
			 	         System.out.print(", Name: " + logname);
			 	         System.out.print(", Password: " + logpass);

		 			}
		 	         
		 	      }
		    }//end else
		 	     count++;
		 	      rs.close();
		 	      if(found=="success"){
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
		 	         System.out.print("ID: " + id);
		 	         System.out.print(", Name: " + name);
		 	         System.out.print(", Datea: " + dateassigned);
		 	        System.out.print(", Dated: " + duedate);
		 	        
		 	       terrisassigned.add(new LoginAction(id,name,dateassigned,duedate));
		 	         
		 	      }
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
		 		   if(count==2)addActionError(getText("error.login"));
		 		   else addActionError(getText("error.database.login"));
		 	   }
		 	  System.out.println(m.get('a'));
		 	 System.out.println(m.get('b'));
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
				   public List<LoginAction> getTerrisassigned() {
					      return terrisassigned;
					   }
					   public void setTerrisassigned(List<LoginAction> terrisassigned) {
					          this.terrisassigned = terrisassigned;
					   }
}