
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
 <h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5>             
      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">
       <header class="panel-heading"><h4>Update DNCs list</h4></header>
        <div class="panel-body">
       <br><br>
       <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='delete-dnc-comment'/>" role="button"><span class="glyphicon glyphicon-import"></span>&nbsp;Delete comment</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='delete-dnc'/>" role="button"><span class="glyphicon glyphicon-export"></span>&nbsp;Delete DNC</a></div>
        </div>
       
       <br><br>  
       
      </div>

    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 