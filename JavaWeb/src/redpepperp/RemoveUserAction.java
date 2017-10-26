package redpepperp;
import redpepperp.model.ReturnTerrisModel;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

 
public class RemoveUserAction extends ActionSupport implements CommonConstants, SessionAware{
 
    private static final long serialVersionUID = 1L;
 
    private ReturnTerrisModel messageStore;
    private int id;
	private String name;
	private String dateassigned;
	private String duedate;
	private int count=0;
	private int assignedcount=0;
	Map m;	
	 
    public void setSession(Map m)
    {
    	this.m=m;
    }
	
 public RemoveUserAction(){}
 
 public RemoveUserAction(int id,String name, String dateassigned)
 {
 	this.id = id;
 	this.name = name;
 	this.dateassigned = dateassigned;
 }
 
 private List<RemoveUserAction> territories;

     
    public String execute() throws Exception {
         
        messageStore = new ReturnTerrisModel() ;
        territories = new ArrayList<RemoveUserAction>();
        Connection conn = null;
 	    Statement stmt = null;
 	    String result="error";
 	    
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
 	      System.out.println("Creating statement...");
 	      
 	         stmt = conn.createStatement();          
 	        String sqlr="SELECT id, username, password FROM TERRIS_LOGIN";
	 	     ResultSet rsr = stmt.executeQuery(sqlr);     
	 	      //STEP 5: Extract data from result set
	 	      while(rsr.next()){
	 	         //Retrieve by column name
	 	         int id  = rsr.getInt("id");
	 	         String name = rsr.getString("username");
	 	         String dateassigned = rsr.getString("password");

	 	         //Display values
	 	         System.out.print("ID: " + id);
	 	         System.out.print(", Name: " + name);
	 	         System.out.print(", Datea: " + dateassigned);
	 	        
	 	       territories.add(new RemoveUserAction(id,name,dateassigned));
	 	      assignedcount++;
	 	         
	 	      }
	 	     count++;
	 	      rsr.close();
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
         if(count==2)result="success";
         else addActionError(getText("error.database.login"));
 	   }
 	   else   addActionError(getText("error.return"));
 	  System.out.println(m.get('a'));
 	 System.out.println(m.get('b'));
 	   return result;
    }
 
    public ReturnTerrisModel getMessageStore() {
        return messageStore;
    }
 
    public void setMessageStore(ReturnTerrisModel messageStore) {
        this.messageStore = messageStore;
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
			   public int getAssignedcount() {
				      return assignedcount;
				   }
				   public void setAssignedcount(int assignedcount) {
				      this.assignedcount = assignedcount;
				   }
	   
	   public List<RemoveUserAction> getTerritories() {
	      return territories;
	   }
	   public void setterritories(List<RemoveUserAction> territories) {
	          this.territories = territories;
	   }
	     
 
}