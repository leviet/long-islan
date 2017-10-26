package redpepperp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;
import redpepperp.model.GetTerrisModel;

import com.opensymphony.xwork2.ActionSupport;

public class MapUpdateAction extends ActionSupport implements CommonConstants, SessionAware, ServletRequestAware{
	/**
 * 
 */
private static final long serialVersionUID = 1L;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private String territoryname;
	private int idc;
	private int count=0;
	Map m;
	private HttpServletRequest servletRequest;
	
    public void setSession(Map m)
    {
    	this.m=m;
    }

	public String execute() {
		
		 Connection conn = null;
		 Statement stmt = null;
		 String found="error";
		 
         String admin=m.get('a').toString().toLowerCase().substring(0, 2);
        System.out.println(admin+"---"+admin.equals("zz"));
        if (admin.equals("zz")) {
		try {

			String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
			System.out.println("Server path:" + filePath);
			File fileToCreate = new File(filePath, this.userImageFileName);

			FileUtils.copyFile(this.userImage, fileToCreate);
			
			System.out.println(userImageFileName+"----"+filePath+this.userImage.getAbsolutePath());
			
			//-------------------database image start-------------------------------
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      count++;
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      InputStream inputStream = new FileInputStream(new File(this.userImage.getAbsolutePath()));
		      //STEP 4: Execute a query
		      //----------------------------------------------------- GET ID
		      stmt = conn.createStatement(); 
		      String sqlr="SELECT id, name FROM TERRIS_MAPS";
		 	    ResultSet rsr = stmt.executeQuery(sqlr);     
		 	      //STEP 5: Extract data from result set
		 	      while(rsr.next()){
		 	         //Retrieve by column name
		 	         int idv  = rsr.getInt("id");
		 	         String namev =rsr.getString("name");
		 	        System.out.println(namev+"--"+idv+"---"+territoryname);
		 	         if(namev.equals(territoryname)){ setIdc(idv); System.out.println(namev+"--"+idv+"---"+territoryname); break;}
		 	         
		 	      }rsr.close();
		      
		      //###########################################################################
		      System.out.println("Inserting map into the table...TERRIS_MAPS");

	          String sql = "REPLACE INTO TERRIS_MAPS (id, name, map) values (?, ?, ?)";
	          PreparedStatement statement = conn.prepareStatement(sql);
	          statement.setInt(1, getIdc());
	          statement.setString(2, territoryname);
	          statement.setBlob(3, inputStream);

	          int row = statement.executeUpdate();
	          if (row > 0) {
	              System.out.println("A record was inserted with photo image.");
	          }	      
		      System.out.println("Inserted map into the table...TERRIS_MAPS");
		    //########################################################################### 
			//-------------------database image end-----------------------------------
		      count++;
		      found="success";
		      
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			return INPUT;
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
	 	System.out.println(m.get('e'));
	 	System.out.println(m.get('f'));
	 	
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

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}
	
	public String getTerritoryname() {
		return territoryname;
	}
 
	public void setTerritoryname(String territoryname) {
		this.territoryname = territoryname;
	}
	
	public int getIdc() {
		return idc;
	}
 
	public void setIdc(int idc) {
		this.idc = idc;
	}

}
