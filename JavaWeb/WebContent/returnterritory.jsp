<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
      <!-- Main component for a primary marketing message or call to action -->
      
      <s:if test="%{assignedcount==0}">
	   <div class="panel panel-info">
         <header class="panel-heading"><h4>Return territories</h4></header>
        <div class="panel-body">
        <br>
         <p><b class="text-success">You have no territories to return.</b></p>
         <br>
      </div>  
      </div>
      </s:if>
      
      <s:else>
      <s:iterator value="territories">
           <div class="panel panel-info">
         <header class="panel-heading"><h4>Return territory&nbsp;<s:property value="name"/></h4></header>
        <div class="panel-body">
         <p>Due date:&nbsp;<b class="text-danger"><s:property value="duedate"/></b></p>
         <form method="post" action="returnterrisx">
          <input type="hidden" name="terrisdate" value="<s:property value="dateassigned"/>" />
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />       
          <div class="row col-lg-12">
          <div class="col-lg-9 col-md-8">
          <input type="text" class="form-control" placeholder="Your comments:Completed? New DoNotCalls?" name="comment" required >
          </div><br class="hidden-lg hidden-md">
          <div class="col-lg-3 col-md-2">
          <button class="btn btn-primary btn-block" value="<s:property value="id"/>" name="password" type="submit">
          <span class="glyphicon glyphicon-retweet"></span>&nbsp;Return</button>
          </div>
           </div>
        </form>               
      </div>
      </div>
      </s:iterator>  
      </s:else>
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 
 
 

    
    
    
    