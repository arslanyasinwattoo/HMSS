//function getFacultyMemberCourses(facultyMemberId) {
//window.location = "manageCourseAllocations.bnu?f=" + facultyMemberId;
//}

function getCategoryByAJAX() {
	var url = "ajax.bnu";
	$.get(url, function(data) {
		document.getElementById("status").innerHTML = data;
	});
}