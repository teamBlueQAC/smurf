		
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
	
		   	}
		   	else if (updateStatus == fadeOutStatus) {
		   		if (document.getElementById("wrapper").style.opacity > 0) {
		   			slideAlpha -= 0.1;
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
		   			slideAlpha = slideAlpha + 0.1;
		   			document.getElementById("wrapper").style.opacity = slideAlpha;
		   		}
		   		else {
		   		   	updateStatus = pendingStatus;
		   		 	changeTmr = setInterval(ChangeSlide,  2000);
		   		}
		   	}		
	   	
		   	BoxArrangement();
	   }
	   var changeTmr = setInterval(ChangeSlide,  4000);
	   var updateTmr = setInterval(updateSlider,  24);
	   document.getElementById("wrapper").style.opacity = 1;
	   
	   function BoxArrangement() {
		   if (window.innerWidth >= 999) {
			   document.getElementById("box1").style.width = '33.3%'; //'333px';
			   document.getElementById("box2").style.width = '33.3%'; //'333px';
			   document.getElementById("box3").style.width = '33.3%'; //'333px';
		   }
		   else if (window.innerWidth >= 666) {
			   document.getElementById("box1").style.width = '100%'; //'666px';
			   document.getElementById("box2").style.width = '50%'; //'333px';
			   document.getElementById("box3").style.width = '50%'; //'333px';
		   }
		   else {
			   document.getElementById("box1").style.width = '100%'; //'333px';
			   document.getElementById("box2").style.width = '100%'; //'333px';
			   document.getElementById("box3").style.width = '100%'; //'333px';
		   }
	   }

			document.getElementById("box1").style.backgroundImage = "url(img/seeds.jpg)";
			document.getElementById("box2").style.backgroundImage = "url(img/seeds2.jpg)";
			document.getElementById("box3").style.backgroundImage = "url(img/purple-garden.jpg)";
	