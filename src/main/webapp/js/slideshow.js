var counter = 1;
var pendingStatus = 1;
var fadeOutStatus = 2;
var fadeInStatus = 3;
var updateStatus = pendingStatus;
var slideAlpha = 1;

function ChangeSlide() {
	updateStatus = fadeOutStatus;
	clearInterval(changeTmr);
}

function updateSlider() {
	if (updateStatus == pendingStatus) {

	} else if (updateStatus == fadeOutStatus) {
		if (document.getElementById("wrapper").style.opacity > 0) {
			slideAlpha -= 0.1;
			document.getElementById("wrapper").style.opacity = slideAlpha;
		} else {
			counter++;
			if (counter > 3) {
				counter = 1;
			}
			if (counter == 1) {
				document.getElementById("wrapper").style.backgroundImage = "url(images/gnome_banner.jpg)"; // "url(images/Ryan.png)";
				document.getElementById("slideLink").href = "https://www.google.co.uk"
			} else if (counter == 2) {
				document.getElementById("wrapper").style.backgroundImage = "url(images/garden-tools-banner.jpg)";// "url(images/Timothy.png)";
				document.getElementById("slideLink").href = "https://www.google.co.uk"
			} else if (counter == 3) {
				document.getElementById("wrapper").style.backgroundImage = "url(images/seeds2.jpg)";// "url(images/Tago.jpg)";
				document.getElementById("slideLink").href = "https://www.google.co.uk"
			}
			updateStatus = fadeInStatus;
		}
	} else if (updateStatus == fadeInStatus) {
		if (slideAlpha < 1) {
			slideAlpha = slideAlpha + 0.1;
			document.getElementById("wrapper").style.opacity = slideAlpha;
		} else {
			updateStatus = pendingStatus;
			changeTmr = setInterval(ChangeSlide, 2000);
		}
	}
}

var changeTmr = setInterval(ChangeSlide, 2000);
var updateTmr = setInterval(updateSlider, 24);
document.getElementById("wrapper").style.opacity = 1;
