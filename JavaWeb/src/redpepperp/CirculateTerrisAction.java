package redpepperp;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class CirculateTerrisAction extends ActionSupport implements CommonConstants, SessionAware{
 
    private static final long serialVersionUID = 1L;
 
    private GetTerrisModel messageStore;
    private int id;
	private String name;
	private String status;
	private String date;
	private int count=0;
	Map m;	
	 
    public void setSession(Map m)
    {
    	this.m=m;
    }
     
    public CirculateTerrisAction(){}
    
    public CirculateTerrisAction(int id,String name,String status, String date)
    {
    	this.id = id;
    	this.name = name;
       this.status = status;
       this.date = date;
    }
    
    private List<CirculateTerrisAction> territories;
    private List<CirculateTerrisAction> territoriescm;
    private List<CirculateTerrisAction> territoriesct;
    private List<CirculateTerrisAction> territorieslf;
    private List<CirculateTerrisAction> territoriesmn;
    private List<CirculateTerrisAction> territoriesrs;
    
    public String execute() throws Exception {
        messageStore = new GetTerrisModel();
        messageStore.setMessage("  Barrhaven");
        
        territories = new ArrayList<CirculateTerrisAction>();
        territoriescm = new ArrayList<CirculateTerrisAction>();
        territoriesct = new ArrayList<CirculateTerrisAction>();
        territorieslf = new ArrayList<CirculateTerrisAction>();
        territoriesmn = new ArrayList<CirculateTerrisAction>();
        territoriesrs = new ArrayList<CirculateTerrisAction>();        
        
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
 	     //-------------------------------------------------------
 	                String sql="SELECT id, name, status, date FROM TERRIS_BA";
 	                ResultSet rs = stmt.executeQuery(sql);     
 	      //STEP 5: Extract data from result set
 	      while(rs.next()){
 	         //Retrieve by column name
 	         int id  = rs.getInt("id");
 	         String name = rs.getString("name");
 	         String status = rs.getString("status");
 	         String date = rs.getString("date");
 	        
 	         if(status.contentEquals("No")){
 		     territories.add(new CirculateTerrisAction(id,name,status,date));
 	            }
 	      }
 	      //-------------------------------------------------------------
				 //-------------------------------------------------------
				           sql="SELECT id, name, status, date FROM TERRIS_CM";
				           rs = stmt.executeQuery(sql);     
				 //STEP 5: Extract data from result set
				 while(rs.next()){
				    //Retrieve by column name
				    int id  = rs.getInt("id");
				    String name = rs.getString("name");
				    String status = rs.getString("status");
				    String date = rs.getString("date");
				   
				    if(status.contentEquals("No")){
				    territoriescm.add(new CirculateTerrisAction(id,name,status,date));
				       }
				 }
				 //---------------------------------------------------------
				 //-------------------------------------------------------
		           sql="SELECT id, name, status, date FROM TERRIS_CT";
		           rs = stmt.executeQuery(sql);     
				 //STEP 5: Extract data from result set
				 while(rs.next()){
				    //Retrieve by column name
				    int id  = rs.getInt("id");
				    String name = rs.getString("name");
				    String status = rs.getString("status");
				    String date = rs.getString("date");
				   
				    if(status.contentEquals("No")){
				    territoriesct.add(new CirculateTerrisAction(id,name,status,date));
				       }
				 }
				 //-------------------------------------------------------------
				 //-------------------------------------------------------
		           sql="SELECT id, name, status, date FROM TERRIS_LF";
		           rs = stmt.executeQuery(sql);     
				 //STEP 5: Extract data from result set
				 while(rs.next()){
				    //Retrieve by column name
				    int id  = rs.getInt("id");
				    String name = rs.getString("name");
				    String status = rs.getString("status");
				    String date = rs.getString("date");
				   
				    if(status.contentEquals("No")){
				    territorieslf.add(new CirculateTerrisAction(id,name,status,date));
				       }
				 }
				 //-------------------------------------------------------------
				 //-------------------------------------------------------
		           sql="SELECT id, name, status, date FROM TERRIS_MN";
		           rs = stmt.executeQuery(sql);     
				 //STEP 5: Extract data from result set
				 while(rs.next()){
				    //Retrieve by column name
				    int id  = rs.getInt("id");
				    String name = rs.getString("name");
				    String status = rs.getString("status");
				    String date = rs.getString("date");
				   
				    if(status.contentEquals("No")){
				    territoriesmn.add(new CirculateTerrisAction(id,name,status,date));
				       }
				 }
				 //-------------------------------------------------------------				 
				 //-------------------------------------------------------
		           sql="SELECT id, name, status, date FROM TERRIS_RS";
		           rs = stmt.executeQuery(sql);     
				 //STEP 5: Extract data from result set
				 while(rs.next()){
				    //Retrieve by column name
				    int id  = rs.getInt("id");
				    String name = rs.getString("name");
				    String status = rs.getString("status");
				    String date = rs.getString("date");
				   
				    if(status.contentEquals("No")){
				    territoriesrs.add(new CirculateTerrisAction(id,name,status,date));
				       }
				 }
				 //-------------------------------------------------------------
				 
 	     count++;
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
       if(count==2)result="success";
       else addActionError(getText("error.database.login"));
	   }
	   else   addActionError(getText("error.get"));
	  System.out.println(m.get('a'));
	 System.out.println(m.get('b'));
	   return result;
    }
 
    public GetTerrisModel getMessageStore() {
        return messageStore;
    }
 
    public void setMessageStore(GetTerrisModel messageStore) {
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
		   public String getStatus() {
		      return status;
		   }
		   public void setStatus(String status) {
		      this.status = status;
		   }
		   
		   public String getDate() {
			      return date;
			   }
			   public void Date(String date) {
			      this.date = date;
			   }
		   
		   public List<CirculateTerrisAction> getTerritories() {
		      return territories;
		   }
		   public void setterritories(List<CirculateTerrisAction> territories) {
		          this.territories = territories;
		   }
		   public List<CirculateTerrisAction> getTerritoriescm() {
			      return territoriescm;
			   }
			   public void setterritoriescm(List<CirculateTerrisAction> territoriescm) {
			          this.territoriescm = territoriescm;
			   }
			   public List<CirculateTerrisAction> getTerritoriesct() {
				      return territoriesct;
				   }
				   public void setterritoriesct(List<CirculateTerrisAction> territoriesct) {
				          this.territoriesct = territoriesct;
				   }
				   public List<CirculateTerrisAction> getTerritorieslf() {
					      return territorieslf;
					   }
					   public void setterritorieslf(List<CirculateTerrisAction> territorieslf) {
					          this.territorieslf = territorieslf;
					   }
					   public List<CirculateTerrisAction> getTerritoriesmn() {
						      return territoriesmn;
						   }
						   public void setterritoriesmn(List<CirculateTerrisAction> territoriesmn) {
						          this.territoriesmn = territoriesmn;
						   }
						   public List<CirculateTerrisAction> getTerritoriesrs() {
							      return territoriesrs;
							   }
							   public void setterritoriesrs(List<CirculateTerrisAction> territoriesrs) {
							          this.territoriesrs = territoriesrs;
							   }						   
 
}