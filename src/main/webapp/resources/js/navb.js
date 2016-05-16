$(document).ready(function() {
	var q = window.location.pathname;
	q = q.split("/");
	q = q[3].split(".");

	$("#" + q).addClass("uk-active");

	var docHeight = $(window).height();
	var footerHeight = $('#footer').height();
	var footerTop = $('#footer').position().top + footerHeight;

	if (footerTop < docHeight) {
		$('#footer').css('margin-top', 10 + (docHeight - footerTop) + 'px');
	}
})
