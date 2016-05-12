		

var slideArray = [];
var currentSlide = 0;
var screenWidth = 500;
var screenHeight = 400;	   
var counter = 1;
	   
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
	   }


	   function initialiseSlides() {

	      	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10), (screenHeight - 10)));
	   	slideArray[currentSlide].src = "img/gnome.jpg";
	      	currentSlide++;

	      	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10), (screenHeight - 10)));
	   	slideArray[currentSlide].src = "img/spade2.0.jpg";
	      	slideArray[currentSlide].a = 0;
	      	currentSlide++;

	      	slideArray.push(new Slide(currentSlide, 5, 5, (screenWidth - 10), (screenHeight - 10)));
	   	slideArray[currentSlide].src = "img/seeds2.jpg";
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
				
		   	}
		   	else if (updateStatus == fadeOutStatus) {
		   		if (document.getElementById("wrapper").style.opacity > 0) {
		   			slideAlpha -= 0.05;
		   			document.getElementById("wrapper").style.opacity = slideAlpha;
		   		} 
		   		else {
		   			counter++;
		   			if (counter > 3) {
		   				counter = 1;
		   			} 
		   			if (counter == 1) {
		   				document.getElementById("wrapper").style.backgroundImage = "url(img/gnome.jpg)";
		   				//document.getElementById("slideLink").href = "https://www.google.co.uk"
		   			}	
		   			else if (counter == 2) {
		   				document.getElementById("wrapper").style.backgroundImage = "url(img/spade2.0.jpg)";
		   				//document.getElementById("slideLink").href = "https://www.google.co.uk"
		   			}
		   			else if (counter == 3) {
		   				document.getElementById("wrapper").style.backgroundImage = "url(img/seeds2.jpg)";
		   				//document.getElementById("slideLink").href = "https://www.google.co.uk"
		   			}  
		   			updateStatus = fadeInStatus;
		   		}   		
		   	}
		   	else if (updateStatus == fadeInStatus) {
		   		if (slideAlpha < 1) {
		   			slideAlpha = slideAlpha + 0.05;
		   			document.getElementById("wrapper").style.opacity = slideAlpha;
		   		}
		   		else {
		   		   	updateStatus = pendingStatus;
		   		 	changeTmr = setInterval(ChangeSlide,  4000);
		   		}
		   	}		
	   	
		   	BoxArrangement();
	   }
	   
	   function drawOnCanvas() {

			var canvas = document.getElementById("canvas_1");

			if (canvas.getContext) {
				var canvas_context = canvas.getContext("2d");

		     	canvas_context.clearRect( 0, 0, screenWidth, screenHeight );

				canvas_context.globalAlpha = slideArray[currentSlide].a;
				var img = new Image();
				img.src = slideArray[currentSlide].src;
				width = document.getElementById("canvas_1").width; 
				canvas_context.drawImage( img , slideArray[currentSlide].xPos, slideArray[currentSlide].yPos, (width - 10), (150 - 10) );  
				
			}
		}
	   
	   var changeTmr = setInterval(ChangeSlide,  4000);
	   var updateTmr = setInterval(updateSlider,  24);
	   document.getElementById("wrapper").style.opacity = 1;

	   function BoxArrangement() {
		   if (window.innerWidth >= 999) {
			   document.getElementById("box1").style.width = '27.3%'; 
			   document.getElementById("box2").style.width = '27.3%'; 
			   document.getElementById("box3").style.width = '27.3%'; 
		   }
		   else if (window.innerWidth >= 666) {
			   document.getElementById("box1").style.width = '94%'; 
			   document.getElementById("box2").style.width = '44%'; 
			   document.getElementById("box3").style.width = '44%'; 
		   }
		   else {
			   document.getElementById("box1").style.width = '94%'; 
			   document.getElementById("box2").style.width = '94%'; 
			   document.getElementById("box3").style.width = '94%'; 
		   }
	   }
 
			document.getElementById("boxa").style.backgroundImage = "url(img/seeds.jpg)";
			document.getElementById("boxb").style.backgroundImage = "url(img/seeds2.jpg)";
			document.getElementById("boxc").style.backgroundImage = "url(img/purple-garden.jpg)";
