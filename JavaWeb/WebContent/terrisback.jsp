
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
 <h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5>             
      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">
       <header class="panel-heading"><h4>Territory assignments</h4></header>
        <div class="panel-body">
	           <p><b>Territory <b class="text-success"><s:property value="#session.f" /></b> has been successfully returned.
                 Your comment was "<b class="text-success">&nbsp;<s:property value="comment"/></b>".
                 Below is a list of territories currently assigned to you.</b></p>
       <table class="table table-striped">
        <tr>
        <th id="name" class="text-center">Territory number</th>
        <th id="datea" class="text-center">Date-assigned/ due-date</th>
        <th id="dated" class="text-center">Territory map</th>
        </tr>
        <s:iterator value="terrisassigned">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="datea" class="text-center"><em class="text-nowrap"><s:property value="dateassigned"/></em>&nbsp;to&nbsp;
        <br><em class="text-danger text-nowrap"><s:property value="duedate"/></em>
        </td>
        <td headers="dated" class="text-center">
        <form method="post" action="Display">
          <input type="hidden" name="terrisname1" value="<s:property value="#session.a"/>" />
          <input type="hidden" name="terrisname" value="<s:property value="name"/>" />
          <button class="btn btn-primary" value="<s:property value="id"/>" name="password" type="submit"><span class="glyphicon glyphicon-download-alt"></span>&nbsp;Map</button>
         </form>
        </td>
        </tr>
        </s:iterator>
        
        </table>
       <br><br>
       <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='getterritory'/>" role="button"><span class="glyphicon glyphicon-briefcase"></span>&nbsp;Get territory</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='returnterritory'/>" role="button"><span class="glyphicon glyphicon-retweet"></span>&nbsp;Return territory</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="map.jsp"><span class="glyphicon glyphicon-folder-open"></span>&nbsp;View master map</a></div>
        </div>
        <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="#" role="button"><span class="glyphicon glyphicon-stats"></span>&nbsp;View statistics</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="admin.action" role="button"><span class="glyphicon glyphicon-wrench"></span>&nbsp;Administration</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="dncmasterlist.action" role="button"><span class="glyphicon glyphicon-tasks"></span>&nbsp;DNC master list</a></div>
       </div>
       </div>
      </div>

    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 