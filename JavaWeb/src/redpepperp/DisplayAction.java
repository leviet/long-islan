package redpepperp;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import constants.CommonConstants;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayAction extends ActionSupport implements CommonConstants, SessionAware{

	/**
	 * 
	 */
	Map m;
	private static final long serialVersionUID = 1L;
    private int id;
	private String terrisname;
	private String terrisname1;
		  
    public void setSession(Map m)
    {
    	this.m=m;
    } 

   
   public DisplayAction(){}
  
	public String execute() {
		
		   String result="error";	      	
		   if( (m.get('a'))!=null){
			   m.put("t",terrisname);
			   result="success";
		   }
		   else   addActionError(getText("error.get"));
		  System.out.println(m.get('a'));
		  System.out.println(m.get('b'));
		   return result;
		
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

					   
}




