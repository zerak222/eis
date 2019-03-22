 $(document).ready(function() {
	 var addEmployeeDialog , confirmationDialog, addEmployeeForm , showEmployeeDialog;
	 addEmployeeDialog = $('<div></div>')
	    .html('<iframe id="frame" style="border: 0px; " src="AddEmployee.html" width="100%" height="100%"></iframe>')
	    .dialog({
	        autoOpen: false,
	        modal: true,
	        height: 800,
	        width: 1000,
	        title: 'Add Employee',
	        buttons: {
	            Cancel: function() {
	              $( this ).dialog( "close" );
	            }
	          }
	    });
	 
	 showEmployeeDialog = $('<div></div>')
	 .html('<iframe id="frame" style="border: 0px; " src="ShowEmployeeList.jsp" width="100%" height="100%"></iframe>')
	    .dialog({
	        autoOpen: false,
	        modal: true,
	        height: 800,
	        width: 1000,
	        title: 'Add Employee',
	        buttons: {
	            Cancel: function() {
	              $( this ).dialog( "close" );
	            }
	          }
	    });
	
	 confirmationDialog = $('<div></div>')
	        .dialog({
	        autoOpen: false,
	        modal: true,
	        height: 300,
	        width: 400,
	        title: 'Add Employee',
	        buttons: {
	            OK : function() {
	              $( this ).dialog( "close" );
	            }
	          }
	    });
	 
	 $("#addEmployee").button().on( "click", function() {
		 addEmployeeDialog.dialog('open'); 
		    var ifr = document.getElementById( "frame" );
			 var ifrDoc = ifr.contentDocument || ifr.contentWindow.document;
			 addEmployeeForm= ifrDoc.getElementById( "myForm" );
			 addEmployeeForm.addEventListener( "submit", function( event ) {
			      event.preventDefault();
			      saveEmployee($( this ).serializeArray());
			    });
	 });
	 
	 $("#showEmployees").button().on( "click", function() {
		 showEmployeeDialog.dialog('open');
	 });
	 
	 function saveEmployee(aData){
		$.ajax({
			url : 'AddEmployee',
			async:false,
			data : aData,
			type : 'post',
			success : function(responseText) {
				$(addEmployeeForm).find(':input:not(:disabled)').prop('disabled',true)
				confirmationDialog.html(responseText).dialog('open');
			},
			error : function(responseText) {
				confirmationDialog.html(responseText).dialog('open');
			}
		});
	}
	});