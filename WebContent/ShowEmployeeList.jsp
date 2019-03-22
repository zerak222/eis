<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavJavJavaScriptUtils.escapeQuotes(aScriptUtils.escapeQuotes( -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body onload="getEmployees()">
<!-- <div class="modal fade" id="ShowEmployeeList" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body"> -->
      <!-- modal body starts here -->
      <div
		style="margin: 200px 200px 300px 300px; padding: 50px 50px 50px 50px; ">
		<div id="container">
			<div class="buttons" style="float: right; margin-top: -60px;">
				<button class="grid " title = "Grid View">
					<i id = "gridButton" class="material-icons "> view_module </i>
				</button>
				<button class="list " style = "color:darkgray" title = "List View">
					<i id = "listbutton" class="material-icons "> view_list </i>
				</button>
			</div>
			<c:forEach items="${allEmployeesList}" var="post">
				<ul class="grid">
					<li>
						<div class="parent"
							style="margin-left: 25px; margin-bottom: 55px; display: inline-flex;">
							<div class="pull-left">
								<a href="#employee/${post.code}"> <i class="material-icons"
									style="font-size: 2.5em; color: lightsteelblue;"> person </i></a>
							</div>
							<div>
								<div style="color: lightsteelblue">${post.name}</div>
								<div style="color: #7C7C7C;">${post.email}</div>
							</div>
							<div class=" grid-view-action-button" style="color: darkgray">
								<span> <a href="#employee/${post.code}"
									class="employee-grid-edit"> <i class="material-icons"
										style="font-size: 1em; color: darkgray;"> edit </i>
								</a>
								</span> <span><a href="#employee/${post.code}"
									id="employee-actions-grid-delete"> <i
										class="material-icons"
										style="font-size: 1em; color: darkgray;"> delete </i></a> </span>
							</div>
						</div>

					</li>

				</ul>
			</c:forEach>
		</div>
	</div>
      <!-- modal body ends here -->
    <!--   </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div> -->

</body>

<style>
.employees-grid-view-temp:hover div.grid-view-actions {
	display: block;
}

.grid-view-action-button {
	right: 22px;
}

div.grid-view-actions {
	display: none;
}

.grid-edit-color {
	color: rgb(118, 114, 114) !important
}

.grid-delete-color {
	color: rgb(240, 92, 92)
}

#container ul {
	list-style: none;
}

#container .buttons {
	margin-bottom: 20px;
}

#container .list li {
	width: 100%;
	border-bottom: 1px dotted #CCC;
	margin-bottom: 10px;
	padding-bottom: 10px;
}

#container .grid li {
	float: left;
	width: 20%;
	height: 50px;
	border-right: 1px dotted #CCC;
	border-bottom: 1px dotted #CCC;
	
}
</style>

<script>

 var allEmployeesList;
 function getEmployees(){
	 $.ajax({
		 url : 'ShowEmployeeList',
		 async:false,
		 type : 'post',
		 success : function(allEmployees) {
			 allEmployeesList = allEmployees; 
		 },
		 error : function(responseText) {
		 }
	 });
}
	$('button').click(function(e) {
		if ($(this).hasClass('grid')) {
			$('#container ul').removeClass('list').addClass('grid');
			$('#listbutton').css('color','darkgray')
			$('#gridButton').css('color','black')
		} else if ($(this).hasClass('list')) {
			$('#container ul').removeClass('grid').addClass('list');
			$('#gridButton').css('color','darkgray')
			$('#listbutton').css('color','black')
		}
	});
</script>
</html>


