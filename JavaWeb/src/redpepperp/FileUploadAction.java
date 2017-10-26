package redpepperp;

import java.sql.*;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

public class FileUploadAction extends ActionSupport implements CommonConstants, SessionAware, ServletRequestAware{

	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
    private int id;
	private String terrisname;
	private String terrisname1;
	private int count=0;
	
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	
	byte[] imageInByte = null;
	String imageId;
	
	private HttpServletRequest servletRequest;
	
	  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public FileUploadAction(){}
   
   public String execute() { return "success";}
   
	public File originalFile() {
		   Connection conn = null;
		   Statement stmt = null;
		   
		   String result="error";
		   //String filePathc = "C:/Users/tttt_000/Desktop/Territory/DOWNLOAD.jpg";   download file to this path       
	      	
		   if( (m.get('a'))!=null){
			   
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      count++;
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      String sql = "SELECT map FROM TERRIS_MAPS WHERE name=?";
	          PreparedStatement statement = conn.prepareStatement(sql);
	          statement.setString(1,m.get('t').toString());
	          System.out.println(m.get('t'));
	          File temp = File.createTempFile("tempfile", ".jpg"); 
	          setUserImageFileName(temp.getName());
	          System.out.println("userImageFileName = "+userImageFileName);
	          ResultSet rs = statement.executeQuery();
	          if (rs.next()) {
	              Blob blob = rs.getBlob("map");
	              InputStream inputStream = blob.getBinaryStream();
	              OutputStream outputStream = new FileOutputStream(temp);
	             //OutputStream outputStreamd = new FileOutputStream(filePathc); to download file

	              int bytesRead = -1;
	              byte[] buffer = new byte[BUFFER_SIZE];
	              while ((bytesRead = inputStream.read(buffer)) != -1) {
	                  outputStream.write(buffer, 0, bytesRead); 
	                  //outputStreamd.write(buffer, 0, bytesRead); download file
	              }

					String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
					System.out.println("Server path:" + filePath);
					File fileToCreate = new File(filePath, userImageFileName);
					        userImage = new File(filePath, userImageFileName);
					     

					FileUtils.copyFile(temp, fileToCreate);
					FileUtils.copyFile(temp, userImage);
					System.out.println("copied temp to = fileTocreate");
					setUserImage(userImage);
					setUserImageFileName(userImage.getName());
					setImageId(userImage.getName());
	              
	              inputStream.close();
	              outputStream.close();
	             // outputStreamd.close(); download file
	              System.out.println("File saved");
	              count++;

					
	          }

		 	      
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
			}
		   
		   finally{
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
		 
		   return userImage;
		
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
 
	
	public String getTerrisname() {
		return terrisname;
	}
 
	public void setTerrisname(String terrisname) {
		this.terrisname = terrisname;
	}
	public String getTerrisname1() {
		return terrisname1;
	}
 
	public void setTerrisname1(String terrisname1) {
		this.terrisname1 = terrisname1;
	}
	
		  
		   public int getId() {
			      return id;
			   }
			   public void setId(int id) {
			      this.id = id;
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
					
					//------------------------------
					
					public String getImageId() {
						return imageId;
					}
				 
					public void setImageId(String imageId) {
						this.imageId = imageId;
					}
					
					public byte[] getCustomImageInBytes1() {
						
						return imageInByte;
					}
					
					public byte[] getCustomImageInBytes() {
				 
						System.out.println("userImageFileName" + userImageFileName);
				 
						BufferedImage originalImage;
						try {
							originalImage = ImageIO.read(originalFile());
							// convert BufferedImage to byte array
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							ImageIO.write(originalImage, "jpg", baos);
							baos.flush();
							imageInByte = baos.toByteArray();
							baos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 
						return imageInByte;
					}
				 
				 
					public String getCustomContentType() {
						return "image/jpeg";
					}
				 
					public String getCustomContentDisposition() {
						return "anyname.jpg";
					}
				 
					   
}




