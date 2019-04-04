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
<script src="js/main.js"></script>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavJavJavaScriptUtils.escapeQuotes(aScriptUtils.escapeQuotes( -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body onload = "getEmployees()">
      <div
		style="margin: 200px 200px 300px 300px; padding: 50px 50px 50px 50px; ">
		<div id="container">
			<div class="buttons" style="float: right; margin-top: -60px; margin-right: -200px;">
				<button class="grid " title = "Grid View">
					<i id = "gridButton" class="material-icons "> view_module </i>
				</button>
				<button class="list " style = "color:darkgray" title = "List View">
					<i id = "listbutton" class="material-icons "> view_list </i>
				</button>
			</div>
			<ul class="grid">
			<div id = "listGridDiv"></div>
		</ul>
		
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
<script type="text/javascript">
var divHTML = "";
function getEmployees(){
	 $.ajax({
		 url : 'ShowEmployeeList',
		 async:false,
		 type : 'get',
		 success : function(allEmployees) {
		 	
			 $.each( allEmployees, function( key, value ) {
				 divHTML +='<li><div class="parent" style="margin-left: 25px; margin-bottom: 55px; display: inline-flex;">'
				+ '<div class="pull-left"><a href="#employee/'+allEmployees[key].code+'"> <i class="material-icons"style="font-size: 2.5em; color: lightsteelblue;"> person </i></a></div>'
				+ '<div><div style="color: lightsteelblue">'+allEmployees[key].name+'</div><div style="color: #7C7C7C;">'+allEmployees[key].email+'</div></div>'
				+ '<div class=" grid-view-action-button" style="color: darkgray"><span> <i id="employee-grid-edit" class="material-icons" style="font-size: 1em; color: darkgray; cursor:pointer"> edit </i>	</span> <span> <i id = "employee-actions-grid-delete" class="material-icons" style="font-size: 1em; color: darkgray;cursor:pointer;" data = '+allEmployees[key].code+'> delete </i> </span>	</div>'
				+ '</div></li>'

				});
			 $('#listGridDiv').append(divHTML);
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
	
	 $('#employee-actions-grid-delete').click(function(aData){
			$.ajax({
				url : 'deleteEmployee',
				async:false,
				data : aData,
				type : 'delete',
				success : function(responseText) {
					console.log('deleted')
				},
				error : function(responseText) {
					console.log('error in delete');
				}
			});
		 });
</script>
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
    margin-left: 350px;
    height: 60px;
    list-style-position: inside;
    border: 1px solid gray;
    width: 230px;
    border-style: dotted;
}

#container .grid li {
	float: left;
	height: 50px;
	list-style-position: inside;
    border: 1px solid gray;
    border-style: dotted;
	
}

 ul {
    margin-top: -200px;
    margin-bottom: 10px;
    margin-left: -350px;
    margin-right: -250px;
}



</style>


</html>


