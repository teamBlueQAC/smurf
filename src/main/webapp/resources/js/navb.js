$(document).ready(function() {
	var q = window.location.pathname;
	q = q.split("/");
	q = q[3].split(".");

	$("#" + q).addClass("uk-active");

})