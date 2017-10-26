<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
      <!-- Main component for a primary marketing message or call to action -->
      
           <div class="panel panel-info">
         <header class="panel-heading"><h4>Change password</h4></header>
        <div class="panel-body">
        <p> <b>Current username:&nbsp;<s:property value="#session.a" /></b></p>
        <h4 class="text-danger"><s:actionerror /></h4>
         <form method="post" action="pass-success">      
          <div class="row col-lg-12">
          <div class="col-lg-8 col-md-7">
          <input type="text" class="form-control" placeholder="current password" name="currentpassword" required >
          </div>
           <div class="col-lg-8 col-md-7">
          <input type="text" class="form-control" placeholder="new password?" name="newpassword" required >
          </div>
          <div class="col-lg-3 col-md-2">
          <button class="btn btn-primary btn-block" value=" " name="submit" type="submit">
          <span class="glyphicon glyphicon-import"></span>&nbsp;Change</button>
          </div>
           </div>
        </form>               
      </div>
      </div>
      
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 
 
 

    
    
    
    