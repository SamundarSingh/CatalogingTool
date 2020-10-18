function displayCourseList(data) {

	var course = data;
	if (course.length != 0) {
		var courseList = '';
		courseList += '<table id="tblCourse" border=1 width=100%>';
		courseList += '<tr>';
		courseList += '<th>Course Code</th>';
		courseList += '<th>Course Name</th>';
		courseList += '<th>Skill Family</th>';
		courseList += '<th>Description</th>';
		courseList += '<th>Proficiency</th>';
		courseList += '<th>Status</th>';
		courseList += '<th>Licence</th>';
		courseList += '<th>Activity Type</th>';
		courseList += '<th>Creation Date</th>';
		courseList += '</tr>'
		for (var i = 0; i < course.length; i++) {

			courseList += '<tr>';
			courseList += '<td>' + course[i].courseCode + '</td>';
			courseList += '<td>' + course[i].courseName + '</td>';
			courseList += '<td>' + course[i].courseSkillFamily + '</td>';
			courseList += '<td>' + course[i].courseDescription + '</td>';
			courseList += '<td>' + course[i].courseProficiency + '</td>';
			courseList += '<td>' + course[i].courseStatus + '</td>';
			courseList += '<td>' + course[i].courseLicence + '</td>';
			courseList += '<td>' + course[i].courseActivityType + '</td>';
			courseList += '<td>' + course[i].courseCreationDate + '</td>';
			courseList += '</tr>';

		}
		courseList += '</table>';
		$("#displayCourseList").html(courseList);
	} else {
		$("#displayCourseList").text(
			" Sorry :) No Course for the Above Search is Available");
	}
}