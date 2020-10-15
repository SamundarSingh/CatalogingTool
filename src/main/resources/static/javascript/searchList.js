/**
 * 
 */
src = "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"

$(document).ready(function() {
	$("#basicSearch").click(function() {
		alert("The basic search was clicked.");
	});

	$("#advanceSearch").click(function() {
		alert("The advance search was clicked.");
	});
});



$(document).ready(function() {

	$("#basic").click(function() {

		$.ajax({

			url: 'getCourseListOnBasicSearch',
			data: {
				id: $("#id").val()
			},
			success: function(responseText) {

				$("#errorMessage").text(responseText);

				if (responseText != "") {
					$("#id").focus();
				}
			}


		});

	});

}); 
