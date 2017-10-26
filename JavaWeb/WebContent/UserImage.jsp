
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>

            <h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      						 <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5>
      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">
       <header class="panel-heading"><h4>Map update</h4></header>
        <div class="panel-body">	    
	
       <br><br>


<s:actionerror />
<s:form action="userImage" method="post" enctype="multipart/form-data">
<div class="col-lg-4"><input type="text" class="form-control" placeholder="Territory name e.g BA-1" name="territoryname" required ></div>	
	
	<s:file name="userImage" label="Select map" />
	<button class="btn btn-primary" value="Upload" name="password" type="submit">
          <span class="glyphicon glyphicon-save"></span>&nbsp;Upload</button>
</s:form>



       </div>
      </div>

    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>