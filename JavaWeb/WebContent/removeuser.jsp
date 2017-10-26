<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
      <!-- Main component for a primary marketing message or call to action -->
      
	   <div class="panel panel-info">
         <header class="panel-heading"><h4>Remove publisher</h4></header>
        <div class="panel-body">
 
        <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Username</th>
        <th id="date" class="text-center">Password</th>
        <th id="download" class="text-center">Remove</th>
 
        <s:iterator value="territories">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center">*************</td>
        <td headers="download" class="text-center">
          <form method="post" action="remove-userx">
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Remove</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 
 
 

    
    
    
    