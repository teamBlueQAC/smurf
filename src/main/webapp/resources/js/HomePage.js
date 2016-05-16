var slideArray = [];
var currentSlide = 0;
var screenWidth = 500;
var screenHeight = 400;
var counter = 0;

var pendingStatus = 1;
var fadeOutStatus = 2;
var fadeInStatus = 3;

var updateStatus = pendingStatus;
var slideAlpha = 1;

var width = 100;

function Slide(ID, x, y, width, height) {
	this.objectID = ID;
	this.xPos = x;
	this.yPos = y;
	this.object_width = width;
	this.object_height = height;
	this.a = 1;
	this.src = "img/seeds2.jpg";
	this.url = "catalogue.xhtml";
}

function initialiseSlides() {

	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10),
			(screenHeight - 10)));
	slideArray[currentSlide].src = "img/prod-img/PeaceGnome.jpg";
	currentSlide++;

	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10),
			(screenHeight - 10)));
	slideArray[currentSlide].src = "img/prod-img/WheelBarrow.jpg";
	slideArray[currentSlide].a = 0;
	currentSlide++;

	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10),
			(screenHeight - 10)));
	slideArray[currentSlide].src = "img/prod-img/SunflowerSeeds.jpg";
	slideArray[currentSlide].a = 0;
	currentSlide++;

	currentSlide = 0;
}
initialiseSlides();

function ChangeSlide() {
	updateStatus = fadeOutStatus;
	clearInterval(changeTmr);
}

function updateSlider() {
	if (updateStatus == pendingStatus) {

	} else if (updateStatus == fadeOutStatus) {
		if (document.getElementById("wrapper").style.opacity > 0) {
			slideAlpha -= 0.05;
			document.getElementById("wrapper").style.opacity = slideAlpha;
		} else {
			counter++;
			if (counter > 2) {
				counter = 0;
			}
			if (counter == 0) {
				document.getElementById("wrapper").style.backgroundImage = "url(img/prod-img/PeaceGnome.jpg)";
				document.getElementById("slideLink").href = slideArray[counter].url;
			} else if (counter == 1) {
				document.getElementById("wrapper").style.backgroundImage = "url(img/prod-img/WheelBarrow.jpg)";
				document.getElementById("slideLink").href = slideArray[counter].url;
			} else if (counter == 2) {
				document.getElementById("wrapper").style.backgroundImage = "url(img/prod-img/SunflowerSeeds.jpg)";
				document.getElementById("slideLink").href = slideArray[counter].url;
			}
			updateStatus = fadeInStatus;
		}
	} else if (updateStatus == fadeInStatus) {
		if (slideAlpha < 1) {
			slideAlpha = slideAlpha + 0.05;
			document.getElementById("wrapper").style.opacity = slideAlpha;
		} else {
			updateStatus = pendingStatus;
			changeTmr = setInterval(ChangeSlide, 4000);
		}
	}

	BoxArrangement();
}

function drawOnCanvas() {

	var canvas = document.getElementById("canvas_1");

	if (canvas.getContext) {
		var canvas_context = canvas.getContext("2d");

		canvas_context.clearRect(0, 0, screenWidth, screenHeight);

		canvas_context.globalAlpha = slideArray[currentSlide].a;
		var img = new Image();
		img.src = slideArray[currentSlide].src;
		width = document.getElementById("canvas_1").width;
		canvas_context.drawImage(img, slideArray[currentSlide].xPos,
				slideArray[currentSlide].yPos, (width - 10), (150 - 10));

	}
}

var changeTmr = setInterval(ChangeSlide, 4000);
var updateTmr = setInterval(updateSlider, 24);
document.getElementById("wrapper").style.opacity = 1;

function BoxArrangement() {
	if (window.innerWidth >= 999) {
		document.getElementById("box1").style.width = '27.3%';
		document.getElementById("box2").style.width = '27.3%';
		document.getElementById("box3").style.width = '27.3%';
	} else if (window.innerWidth >= 666) {
		document.getElementById("box1").style.width = '94%';
		document.getElementById("box2").style.width = '44%';
		document.getElementById("box3").style.width = '44%';
	} else {
		document.getElementById("box1").style.width = '94%';
		document.getElementById("box2").style.width = '94%';
		document.getElementById("box3").style.width = '94%';
	}
}

function NavigateToGnomes() {
	window.open("catalogue.xhtml", "_self");

}
