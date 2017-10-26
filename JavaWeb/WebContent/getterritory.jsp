<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
 <h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5>            
      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">
        <header class="panel-heading"><h4>Get territory</h4></header>
        <br>
        <div class="panel-body">
             
                <div class="panel-group" id="accordion">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><span class="glyphicon glyphicon-chevron-right"></span>Old Barhaven</a>
            </h4>
          </div>
          <div id="collapse1" class="panel-collapse collapse">
            <div class="panel-body">
            
        <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territories">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
       <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            
           </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse2"><span class="glyphicon glyphicon-chevron-right"></span>Country</a>
            </h4>
          </div>
          <div id="collapse2" class="panel-collapse collapse">
            <div class="panel-body">
            <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territoriesct">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
          <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse3"><span class="glyphicon glyphicon-chevron-right"></span>Manotick</a>
            </h4>
          </div>
          <div id="collapse3" class="panel-collapse collapse">
            <div class="panel-body">
            <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territoriesmn">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
          <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse4"><span class="glyphicon glyphicon-chevron-right"></span>Riverside south</a>
            </h4>
          </div>
          <div id="collapse4" class="panel-collapse collapse">
            <div class="panel-body">
            <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territoriesrs">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
          <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            </div>
          </div>
        </div>
                <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse5"><span class="glyphicon glyphicon-chevron-right"></span>Longfields</a>
            </h4>
          </div>
          <div id="collapse5" class="panel-collapse collapse">
            <div class="panel-body">
            <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territorieslf">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
          <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            </div>
          </div>
        </div>
                <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse6"><span class="glyphicon glyphicon-chevron-right"></span>Chapman Mills</a>
            </h4>
          </div>
          <div id="collapse6" class="panel-collapse collapse">
            <div class="panel-body">
            <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory#</th>
        <th id="date" class="text-center">Last worked</th>
        <th id="download" class="text-center">Assign</th>
 
        <s:iterator value="territoriescm">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="date" class="text-center text-nowrap"><s:property value="date"/></td>
        <td headers="download" class="text-center">
          <form method="post" action="assignterrisba">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
        <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit">Assign</button>
      </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
            </div>
          </div>
        </div>
                     
      </div>
      </div>
       </div>
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 
 
 

    
    
    
    