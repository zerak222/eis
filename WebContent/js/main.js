/*Declaring dialog variables*/ 
var addEmployeeDialog , confirmationDialog, addEmployeeForm , showEmployeeDialog;
 
$(document).ready(function() {

	initializeAddEmployeeDialog();
	initializeConfirmationDialog();
	
	/*register events for desired action buttons*/
	$("#edit").button("option", "disabled", true);

	$("#addEmployee").button().on("click", function() {//register add employee button event to render popup
		addEmployeeDialog.dialog('open');
		var ifr = document.getElementById("frame");
		var ifrDoc = ifr.contentDocument || ifr.contentWindow.document;
		addEmployeeForm = ifrDoc.getElementById("myForm");

		addEmployeeForm.addEventListener("submit", function(event) {
			event.preventDefault();
			if ($(this).data("update") == "1") {
				updateEmployee($(this).serializeArray());
			} else {
				saveEmployee($(this).serializeArray());
			}

		})
	});

	$("#showEmployees").button().on("click", function() { //register show employee button event to render popup
		initializeShowEmployeesDialog();
		showEmployeeDialog.dialog('open');
	});

	$('i#employee-actions-grid-delete').click(function(aData) {
		deleteEmployee(aData.target.dataset);
		//re rendering show employee dialog will be handled later.
	});

	$('i#employee-grid-edit').click(function(aData) {
		//edit action will be implemented later
	});

});

/*Initializes Add Employee dialog content*/
function initializeAddEmployeeDialog(){
	addEmployeeDialog = $('<div id="addEmployeeDialog"></div>')
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
              {$( this ).dialog( "destroy" );
              initializeAddEmployeeDialog();
              }
            
         }
    ]
    });
};

/*Initializes show Employee dialog content*/
function initializeShowEmployeesDialog() {

	showEmployeeDialog = $('<div id="showEmployeeDialog"></div>')
			.html('<iframe id="frame" style="border: 0px;" src="ShowEmployeeList.html" width="100%" height="100%"></iframe>')
			.dialog({
				autoOpen : false,
				modal : true,
				height : 800,
				width : 1000,
				title : 'Employee List',
				open: function (event, ui) {
				    $(this).css('overflow', 'hidden');
				},
				buttons : {
					Cancel : function() {
						$(this).dialog("destroy");
					}
				}
			});
};

/*Initializes confirmation dialog overview*/
function initializeConfirmationDialog() {

	confirmationDialog = $('<div id="confirmationDialog"></div>').dialog({
		autoOpen : false,
		modal : true,
		height : 300,
		width : 400,
		title : 'confirmation',
		dialogClass : "myClass",
		buttons : {
			OK : function() {
				$(this).dialog("close");
			}
		}
	});
};

/*Saves employee via service call to AddEmployee servlet*/
function saveEmployee(aData) {
	$.ajax({
		url : 'AddEmployee',
		async : false,
		data : aData,
		type : 'post',
		success : function(responseText) {
			$(addEmployeeForm).find(':input:not(:disabled)').prop('disabled',
					true)
			$("#edit").button("option", "disabled", false);
			confirmationDialog.html(responseText).dialog('open');
		},
		error : function(responseText) {
			confirmationDialog.html(responseText).dialog('open');
		}
	});
};
 
/*updates employee data via service call to UpdateEmployee servlet*/
 function updateEmployee(aData) {
	$.ajax({
		url : 'UpdateEmployee',
		async : false,
		data : aData,
		type : 'post',
		success : function(responseText) {
			$(addEmployeeForm).find(':input:not(:disabled)').prop('disabled', true)
			$("#edit").button("option", "disabled", false);
			confirmationDialog.html(responseText).dialog('open');
		},
		error : function(responseText) {
			confirmationDialog.html(responseText).dialog('open');
		}
	});
};

/*deletes employee via service call to deleteEmployee servlet*/
 function deleteEmployee(aPK) {
	$.ajax({
		url : 'deleteEmployee',
		async : false,
		data : aPK,
		type : 'post',
		success : function(responseText) {
			$(showEmployeeDialog).dialog( "close" );
		},
		error : function(responseText) {
			confirmationDialog.html(responseText).dialog('open');
		}
	});
};