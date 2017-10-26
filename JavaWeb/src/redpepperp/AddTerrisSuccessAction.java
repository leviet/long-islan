package redpepperp;
import java.sql.*;
import java.util.Collections;
import java.util.Map;







import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class AddTerrisSuccessAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private String name;
	private String name1;
	private String position;
	private int count=0;
	private int end=-1;
	private int end2=-1;
	private boolean insertsuccess=false;
	//getters and setters  
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public AddTerrisSuccessAction(){}
   
 
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
 
		 	      //------------------------------------------------------------add territory
		 	        String sql="SELECT id FROM TERRIS_"+name1;
			 	     ResultSet rse = stmt.executeQuery(sql);     			 	      		 	      
		 	       sql = "INSERT INTO TERRIS_"+name1+" VALUES ("+name+",'"+name1+"-"+position+"', 'No',' ')";
		 	      System.out.println(sql);
		 	      stmt.executeUpdate(sql);
		 	   //--------------create territory table for user logs
		 	     sql = "CREATE TABLE TERRIS_"+name1+position+
		                   " (id INTEGER not NULL, " +
		                   " pname VARCHAR(255), " + 
		                   " sdate VARCHAR(255), " + 
		                   " rdate VARCHAR(255), " +
		                   " PRIMARY KEY ( id ))"; 
		      System.out.println(sql);
		      stmt.executeUpdate(sql);
		 	     rse.close();
	              //-------add territory name in maps table
			      String sqlr="SELECT id FROM TERRIS_MAPS";
			 	     ResultSet rsr = stmt.executeQuery(sqlr);     
			 	      //STEP 5: Extract data from result set
			 	      while(rsr.next()){
			 	         //Retrieve by column name
			 	    	  int current=rsr.getInt("id");
			 	         if(end<current)end=current;			 	        
			 	        System.out.println("ID-----------------: " + end);
			 	      }end++; 
			 	     sql = "INSERT INTO TERRIS_MAPS VALUES ("+end+",'"+name1+"-"+position+"', '')";
			 	      System.out.println(sql);
			 	      stmt.executeUpdate(sql);
	                 count++;
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
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getName1() {
		return name1;
	}
 
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPosition() {
		return position;
	}
 
	public void setPosition(String position) {
		this.position = position;
	}		
	

	public boolean getInsertsuccess() {
		return insertsuccess;
	}
 
	public void setInsertsuccess(boolean insertsuccess) {
		this.insertsuccess = insertsuccess;
	}
		  

}