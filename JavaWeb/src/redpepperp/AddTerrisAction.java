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

public class AddTerrisAction extends ActionSupport implements CommonConstants, SessionAware{
 
	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
	private GetTerrisModel messageStore;
	private int endba=0,endcm=0,endct=0,endlf=0,endmn=0,endrs=0, count=0;
	private int endba1=0,endcm1=0,endct1=0,endlf1=0,endmn1=0;

	
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public AddTerrisAction(){}
   
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
		 	      //------------------------------------------------------------BA count
			 	     String sql="SELECT id FROM TERRIS_BA";
			 	     ResultSet rs = stmt.executeQuery(sql);     
			 	      //STEP 5: Extract data from result set
			 	      while(rs.next()){
			 	         //Retrieve by column name
			 	        endba++;
			 	       System.out.println("endba-----------------: " + endba);
			 	      } 
			 	     rs.close();
			 	   //-------------------------------------------------------------------
			 	      //------------------------------------------------------------CM count
				 	     String sqla="SELECT id FROM TERRIS_CM";
				 	     ResultSet rsa = stmt.executeQuery(sqla);     
				 	      //STEP 5: Extract data from result set
				 	      while(rsa.next()){
				 	         //Retrieve by column name
				 	    	endcm++;
				 	       System.out.println("endcm-----------------: " + endcm);
				 	      }
				 	     rsa.close();
				 	   //-------------------------------------------------------------------
				 	      //------------------------------------------------------------CT count
					 	     String sqlb="SELECT id FROM TERRIS_CT";
					 	     ResultSet rsb = stmt.executeQuery(sqlb);     
					 	      //STEP 5: Extract data from result set
					 	      while(rsb.next()){
					 	         //Retrieve by column name
					 	    	endct++;
					 	        System.out.println("endct-----------------: " + endct);
					 	      } 
					 	     rsb.close();
					 	   //-------------------------------------------------------------------
					 	      //------------------------------------------------------------LF count
						 	     String sqlc="SELECT id FROM TERRIS_LF";
						 	     ResultSet rsc = stmt.executeQuery(sqlc);     
						 	      //STEP 5: Extract data from result set
						 	      while(rsc.next()){
						 	         //Retrieve by column name
						 	    	endlf++;
						 	        System.out.println("endlf-----------------: " + endlf);
						 	      }
						 	     rsc.close();
						 	   //-------------------------------------------------------------------
						 	      //------------------------------------------------------------MN count
							 	     String sqld="SELECT id FROM TERRIS_MN";
							 	     ResultSet rsd = stmt.executeQuery(sqld);     
							 	      //STEP 5: Extract data from result set
							 	      while(rsd.next()){
							 	         //Retrieve by column name
							 	    	endmn++;
							 	        System.out.println("endmn-----------------: " + endmn);
							 	      } 
							 	     rsd.close();
							 	   //-------------------------------------------------------------------
							 	      //------------------------------------------------------------RS count
								 	     String sqle="SELECT id FROM TERRIS_RS";
								 	     ResultSet rse = stmt.executeQuery(sqle);     
								 	      //STEP 5: Extract data from result set
								 	      while(rse.next()){
								 	         //Retrieve by column name
								 	    	endrs++;
								 	        System.out.println("endrs-----------------: " + endrs);
								 	      } 
								 	   //-------------------------------------------------------------------							 	      
								 	     rse.close();
		 	      found="success";
		 	      count++;
		 	      		 	      
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
 	         }   
 	        else   addActionError(getText("error.get"));
		 	
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
 
	public int getEndba() {
		return endba+1;
	}
 
	public void setEndba(int endba) {
		this.endba = endba;
	}
	public int getEndcm() {
		return endcm+1;
	}
 
	public void setEndcm(int endcm) {
		this.endcm = endcm;
	}
	public int getEndct() {
		return endct+1;
	}
 
	public void setEndct(int endct) {
		this.endct = endct;
	}
	public int getEndlf() {
		return endlf+1;
	}
 
	public void setEndlf(int endlf) {
		this.endlf = endlf;
	}
	public int getEndmn() {
		return endmn+1;
	}
 
	public void setEndmn(int endmn) {
		this.endmn = endmn;
	}
	public int getEndrs() {
		return endrs+1;
	}
 
	public void setEndrs(int endrs) {
		this.endrs = endrs;
	}
	public int getBa() {
		return endba;
	}	
	public int getCm() {
		return endcm;
	}
	public int getCt() {
		return endct;
	}
	public int getLf() {
		return endlf;
	}
	public int getMn() {
		return endmn;
	}
	public int getRs() {
		return endrs;
	}	
					   
}