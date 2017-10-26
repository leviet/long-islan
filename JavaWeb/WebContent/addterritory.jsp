<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
      <!-- Main component for a primary marketing message or call to action -->     
           <div class="panel panel-info">
         <header class="panel-heading"><h4>Add territory</h4></header>
        <div class="panel-body">
        <h4 class="text-danger"><s:actionerror /></h4>
        <p><b>The following are territories names available to be added next.</b></p>
      
       <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory name</th>
        <th id="add" class="text-center">Add</th>
        </tr>
        <tr>
        <td headers="name" class="text-center">BA-<s:property value="endba"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success">
                  <input type="hidden" name="name1" value="BA" />
                  <input type="hidden" name="position" value="<s:property value="endba"/>" />                       
          		<button class="btn btn-primary" value="<s:property value="ba"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr>
         <tr>
        <td headers="name" class="text-center">CM-<s:property value="endcm"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success">
                  <input type="hidden" name="name1" value="CM" /> 
                  <input type="hidden" name="position" value="<s:property value="endcm"/>" />      
          		<button class="btn btn-primary " value="<s:property value="cm"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr>
        <tr>
        <td headers="name" class="text-center">CT-<s:property value="endct"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success">
                  <input type="hidden" name="name1" value="CT" />  
                  <input type="hidden" name="position" value="<s:property value="endct"/>" />     
          		<button class="btn btn-primary " value="<s:property value="ct"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr>
        <tr>
        <td headers="name" class="text-center">LF-<s:property value="endlf"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success">  
                  <input type="hidden" name="name1" value="LF" /> 
                  <input type="hidden" name="position" value="<s:property value="endlf"/>" />    
          		<button class="btn btn-primary " value="<s:property value="lf"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr>
        <tr>
        <td headers="name" class="text-center">MN-<s:property value="endmn"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success"> 
                  <input type="hidden" name="name1" value="MN" />
                  <input type="hidden" name="position" value="<s:property value="endmn"/>" />      
          		<button class="btn btn-primary " value="<s:property value="mn"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr> 
        <tr>
        <td headers="name" class="text-center">RS-<s:property value="endrs"/></td>
         <td headers="add" class="text-center">
                  <form method="post" action="add-terris-success">
                  <input type="hidden" name="name1" value="RS" />
                  <input type="hidden" name="position" value="<s:property value="endrs"/>" />       
          		<button class="btn btn-primary " value="<s:property value="rs"/>" name="name" type="submit">
          		<span class="glyphicon glyphicon-import"></span>&nbsp;Add</button>
       			 </form>
         </td>
        </tr>                            
        </table>
   
      </div>
      </div>
      
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 
 
 

    
    
    
    