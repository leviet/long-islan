<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">
        <header class="panel-heading"><h4> Complete territory mapping</h4></header>
        <div class="panel-body">
        <p><img src ="images/map.png" class="img-responsive" alt="complete territory mapping" width="1400" height="500"></p>
        </div>
 <s:property value="name"/>

      </div>

    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>