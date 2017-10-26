package redpepperp;
import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import constants.CommonConstants;


	 
	public class StatisticsAction extends ActionSupport implements CommonConstants, SessionAware{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String username;
		private String password;
		private int count=0;
		Map m;
		
	    public void setSession(Map m)
	    {
	    	this.m=m;
	    }
	 
		public String authenticate() {
			
	 	    String result="error";
	 	    
	  	   if( (m.get('a'))!=null){result="success";}

			   else {  addActionError(getText("error.get"));}
			  
	  	   return result;
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
			return username;
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
	}