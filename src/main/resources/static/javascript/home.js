/**
 * 
 */

$(document).ready(function() {
	$("#basicSearch").click(function() {
		$.ajax({
			url: 'basicSearch',
			dataType: "json",
			data: {
				courseName: $("#courseName").val(),
				courseSkillFamily: $("#courseSkillFamily").val(),
				courseProficiency: $("#courseProficiency").val()
			},
			success: function(data) {
				displayCourseList(data);

			}

		});
	});

	$("#advanceSearch").click(function() {
		$.ajax({
			url: 'advanceSearch',
			dataType: "json",
			data: {
				courseCode: $("#courseCode").val(),
				courseDescription: $("#courseDescription").val(),
				courseLicence: $("#courseLicence").val(),
				courseActivityType: $("#courseActivityType").val()
			},
			success: function(data) {
				displayCourseList(data);

			}

		});
	});
	

	$('#exportToExcel').click(function() {
		$("#tblCourse").table2excel({
			exclude: ".excludeThisClass",
			filename: "CourseList.xls",
			name: "Worksheet Name",
			preserveColors: true
		});

	});

})
