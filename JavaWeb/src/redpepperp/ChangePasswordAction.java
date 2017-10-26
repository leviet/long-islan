package redpepperp;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import constants.CommonConstants;


import org.apache.struts2.interceptor.SessionAware;

 
public class ChangePasswordAction extends ActionSupport implements CommonConstants, SessionAware{
 
    private static final long serialVersionUID = 1L;
 
	Map m;	
	 
    public void setSession(Map m)
    {
    	this.m=m;
    }
	
 public ChangePasswordAction(){}
 

    public String execute(){

 	    String result="error";
 	    
 	   if( (m.get('a'))!=null){result="success";}
 	  
 	   else  { addActionError(getText("error.return"));}
 	  System.out.println(m.get('a'));
 	 System.out.println(m.get('b'));
 	   return result;
    }
}
