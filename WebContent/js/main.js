// Get modal element
var modal = document.getElementById('simpleModal');
 // Get open modal button
 var modalBtn = document.getElementById('modalBtn');
 //var showEmployeeModalBtn = document.getElementById('showEmployeeModalBtn');
 //Get close button
 var closeBtn = document.getElementById('closeBtn');
 //var closeBtn1 = document.getElementById('closeBtn1');
 
 //Listen for open click
 modalBtn.addEventListener('click',openModal);
 //showEmployeeModalBtn.addEventListener('click',showEmployeeOpenModal);
 //Listen for close click
 closeBtn.addEventListener('click',closeModal);
 //closeBtn1.addEventListener('click',closeModal1);
 //Listen for outside click
 window.addEventListener('click',clickOutside);
 
 //Function to openModal
 function openModal()
 {
	 modal.style.display ="block";
 }
 function showEmployeeOpenModal()
 {
	 showEmployeeModal.style.display ="block";
 }
 
 //Function to closeModal
 function closeModal()
 {
	 modal.style.display ="none";
	 //showEmployeeModal.style.display ="none";
 }
 function closeModal1()
 {
	 showEmployeeModal.style.display ="none";
 }
 
 //Function to closeModal if outside click
 function clickOutside(e)
 {
	 if(e.target == modal){
	 modal.style.display ="none";
	 }
 }
 
 $(document).ready(function() {
		$('#saveDetails').click(function() {
			var name=$("#name").val();
			var email=$("#email").val();
			var phone=$("#phone").val();
			var gender=$("#gender").val();
			var dob=$("#datepicker").val();
			var designation=$("#designation").val();
			var location=$("#location").val();
			$.ajax({
				url : 'AddEmployee',
				async:false,
				data:{'name': name,'email': email,'phone': phone,'gender':gender,'dob': dob,'designation': designation,'location': location},
				type : 'post',
				success : function(responseText) {
					$('#data-message').text(responseText);
					$('#myForm *').prop('disabled', true); 
				},
				error : function(responseText) {
					$('#data-message').text(responseText);
				}
			});
		});
		$('#editForm').click(function(){
			$('#myForm *').prop('disabled', false); 
			
		});
	});