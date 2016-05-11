$(document).ready(function() {
	var q = window.location.pathname;
	console.log("q = " + q);
	q = q.split("/");
	q = q[3].split(".");

	$("#" + q).addClass("uk-active");
})