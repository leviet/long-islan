package redpepperp;
import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;  
 
public class AdminAction extends ActionSupport implements CommonConstants, SessionAware{
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

   
   public AdminAction(){}
   
   public AdminAction(int id, String name, String dateassigned, String duedate)
   {
   	this.id = id;
   	this.name = name;
      this.dateassigned = dateassigned;
      this.duedate = duedate;
   }
   
   private List<AdminAction> pcomment;

 
	public String authenticate() {
		pcomment = new ArrayList<AdminAction>();
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
  		 	           
		 	         String admin=m.get('a').toString().toLowerCase().substring(0, 2);
		 	        System.out.println(admin);
		 	        if (admin.equals("zz")) {
		 				found= "success";
		 			} else {
			 	         System.out.print(", Name: " + admin.equals("zz"));

		 			}     
		 	      
		 	     count++;
		 	      if(found=="success"){     
		 	     //-----------------------------------------------------
		 	    String sqlr="SELECT id, user, comment, date FROM COMMENT_RETURN";
		 	    ResultSet rsr = stmt.executeQuery(sqlr);     
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
		 	        
		 	       pcomment.add(new AdminAction(id,name,dateassigned,duedate));
		 	         
		 	      }Collections.reverse(pcomment);
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
		 		   if(count==2)addActionError(getText("error.admin.login"));
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
				   public List<AdminAction> getPcomment() {
					      return pcomment;
					   }
					   public void setPcomment(List<AdminAction> pcomment) {
					          this.pcomment = pcomment;
					   }
}