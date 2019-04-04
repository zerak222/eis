 var addEmployeeDialog , confirmationDialog, addEmployeeForm , showEmployeeDialog;
	 var showEmployeeClicked = false; 
$(document).ready(function() {
	
	 addEmployeeDialog = $('<div></div>')
	    .html('<iframe id="frame" style="border: 0px; " src="AddEmployee.html" width="100%" height="100%"></iframe>')
	    .dialog({
	        autoOpen: false,
	        modal: true,
	        height: 800,
	        width: 1000,
	        title: 'Add Employee',
	        buttons:[
	        {    		
	          id:"edit",
	          text:"Edit",
	          click:function()
	            {$(addEmployeeForm).find(':input(:disabled)').prop('disabled',false);
	            $(addEmployeeForm).find('#saveEmployee').hide();
	            $(addEmployeeForm).find('#updateEmployee').show();
	            $(addEmployeeForm).data("update",1);
	            }
	        },
	        {
	           id:"cancel",
	 	       text:"Cancel",
	           click: function() 
	              {$( this ).dialog( "close" );}
	            
	         }
	    ]
	    });
	 
	 $("#edit").button("option", "disabled", true);
	 
		 showEmployeeDialog = $('<div></div>')
		 .html('<iframe id="frame" style="border: 0px; " src="ShowEmployeeList.jsp" width="100%" height="100%"></iframe>')
		    .dialog({
		        autoOpen: false,
		        modal: true,
		        height: 800,
		        width: 1000,
		        title: 'Employee List',
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
			 if($(this).data("update")=="1")
				 {
			 updateEmployee($( this ).serializeArray());}
			 else
				 {
				 saveEmployee($( this ).serializeArray());}
				 
		 })
	 }
	 );
	
	 
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
				 $("#edit").button("option", "disabled", false);
				confirmationDialog.html(responseText).dialog('open');
			},
			error : function(responseText) {
				confirmationDialog.html(responseText).dialog('open');
			}
		});
	}
	 
	 function updateEmployee(aData){
			$.ajax({
				url : 'UpdateEmployee',
				async:false,
				data : aData,
				type : 'post',
				success : function(responseText) {
					$(addEmployeeForm).find(':input:not(:disabled)').prop('disabled',true)
					 $("#edit").button("option", "disabled", false);
					confirmationDialog.html(responseText).dialog('open');
				},
				error : function(responseText) {
					confirmationDialog.html(responseText).dialog('open');
				}
			});
		}
	 
	
	});