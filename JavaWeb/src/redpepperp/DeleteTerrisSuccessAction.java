package redpepperp;
import java.sql.*;
import java.util.Collections;
import java.util.Map;








import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteTerrisSuccessAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
    private int id;
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

   
   public DeleteTerrisSuccessAction(){}
   
 
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
		 	         
		 	         String terristable = name.replace("-","");
		 	         String table = name.substring(0,name.lastIndexOf("-"));
			 	     String maintable = table.replaceAll("[0-9]","");
 
		 	      //------------------------------------------------------------delete territory
		 	        String sql="SELECT id FROM TERRIS_"+maintable;
			 	     ResultSet rse = stmt.executeQuery(sql);     			 	      		 	      
			 	    sql = "DELETE FROM TERRIS_"+maintable+" WHERE name ='"+name+"'";
		 	      System.out.println(sql);
		 	      stmt.executeUpdate(sql);
		 	   //--------------delete territory table for user logs
		 	     sql = "DROP TABLE TERRIS_"+terristable; 
		      System.out.println(sql);
		      stmt.executeUpdate(sql);
		 	     
	              //-------delete territory name in maps table
			 	     sql = "DELETE FROM TERRIS_MAPS WHERE name ='"+name+"'";
			 	      System.out.println(sql);
			 	      stmt.executeUpdate(sql);
	                 count++;
		 	     	insertsuccess=true;
		 	     	found="success";
		 	     	rse.close();
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