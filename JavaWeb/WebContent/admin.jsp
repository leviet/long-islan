
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp"/>
<h5 class="text-right"><span class="glyphicon glyphicon-user"></span><s:property value="#session.a" />&nbsp;|&nbsp;
      				    <span class="glyphicon glyphicon-off"></span>&nbsp;<a href="logout">Logout</a><h5>
      				    <link href="bootstrap-3.3.1/commentBox/comment.css" rel="stylesheet">  
      <!-- Main component for a primary marketing message or call to action -->
              <!-----------Comments start----------->
        <div class="panel panel-info">
         <header class="panel-heading"><h4>Administartion</h4></header>
        <div class="panel-body"><p><b>Below is a list of pending updates submitted by publishers while returning territories.</b></p>
    <div class="actionBox">
        <ul class="commentList">
        <s:iterator value="pcomment">
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
    </div>
</div>

<!--comments end-->
 
 <br><br>
       <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="adduser.jsp" role="button"><span class="glyphicon glyphicon-import"></span>&nbsp;Add publisher</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='remove-user'/>" role="button"><span class="glyphicon glyphicon-export"></span>&nbsp;Remove publisher</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='add-territory'/>"><span class="glyphicon glyphicon-import"></span>&nbsp;Add territory</a></div>
        </div>
        <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='delete-territory'/>" role="button"><span class="glyphicon glyphicon-ban-circle"></span>&nbsp;Delete territory</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='circulate-territory'/>" role="button"><span class="glyphicon glyphicon-repeat"></span>&nbsp;Circulate territory</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='uncirculate'/>" role="button"><span class="glyphicon glyphicon-remove-circle"></span>&nbsp;Stop circulation </a></div>
       </div> 
               <div class="row">
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="UserImage.jsp" role="button"><span class="glyphicon glyphicon-folder-open"></span>&nbsp;Update map</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='territory-list'/>" role="button"><span class="glyphicon glyphicon-tasks"></span>&nbsp;Territories list</a></div>
        <div class="col-sm-4 col-xs-12 mrgn-tp-sm"><a class="btn btn-primary btn-block" href="<s:url action='user-list'/>" role="button"><span class="glyphicon glyphicon-remove-user"></span>&nbsp;Users List</a></div>
       </div> 
       <br><br>   
      </div> <!-- /panel-->
    </div> <!-- /container -->
    
    <s:include value="Footer.jsp"/>
 