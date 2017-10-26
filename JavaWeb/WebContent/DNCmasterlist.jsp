
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5> 
<link href="bootstrap-3.3.1/commentBox/comment.css" rel="stylesheet"> 

      <!-- Main component for a primary marketing message or call to action -->
      <div class="panel panel-info">      	       
       <header class="panel-heading"><h4> DNC master list</h4></header>
        <div class="panel-body">
      <p><b>Use the comment box at the bottom of this page to report on the progress of the DNCs.</b></p>
      
      
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
        <th id="name" class="text-center">Address</th>
        <th id="datea" class="text-center">Date</th>
        <th id="dated" class="text-center">Territory#</th>
        </tr>
        <s:iterator value="terrisassigned">
        <tr>
        <td headers="name" class="text-center"><s:property value="name"/></td>
        <td headers="datea" class="text-center"><em class="text-nowrap"><s:property value="dateassigned"/></em>
        </td>
        <td headers="dated" class="text-center"><s:property value="duedate"/></td>
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
        <th id="namecm" class="text-center">Address</th>
        <th id="dateacm" class="text-center">Date</th>
        <th id="datedcm" class="text-center">Territory#</th>
        </tr>
        <s:iterator value="terriscm">
        <tr>
        <td headers="namecm" class="text-center"><s:property value="name"/></td>
        <td headers="dateacm" class="text-center"><em class="text-nowrap"><s:property value="dateassigned"/></em>
        </td>
        <td headers="datedcm" class="text-center"><s:property value="duedate"/></td>
        </tr>
        </s:iterator>       
        </table>
          </div>
        </div>
                     
      </div> 
      
        </div>
          <br><a class="btn btn-primary" href="<s:url action='update-dnc-list'/>">
        <span class="glyphicon glyphicon-folder-open"></span>&nbsp;Update list</a>
            </div>
        </div>
        
        <!-----------Comments start----------->
        <div class="panel panel-info">
         <header class="panel-heading"><h4> Comment Box</h4></header>
        <div class="panel-body">
    <div class="actionBox">
        <ul class="commentList">
        <s:iterator value="terriscomment">
             <li>
                <div class="commenterImage">
                  <span class="glyphicon glyphicon-user"></span>
                </div>
                <div class="commentText">
                    <p><b><s:property value="name"/>: </b><s:property value="dateassigned"/></p> <span class="date sub-text"><s:property value="duedate"/></span>

                </div>
            </li>
        </s:iterator> 
        </ul>
        <form class="form-inline" role="form" method="post" action="dncmasterlist">
            <div class="form-group">
                <input class="form-control" type="text" placeholder="Your comments: Completed? Still applies?... " name="comment" required >
            </div>
            <div class="form-group">
                <button class="btn btn-primary " type="submit">Send</button>
            </div>
        </form>
    </div>
</div>
</div>
<!--comments end-->

    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 