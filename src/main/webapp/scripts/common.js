var flag=true;
$(document).ready(function() {

	$("#notification").delay(4000).hide(10);
	$("#notificationbutton").click(function(){
		$("#quickicons").toggle(200);
		});
$("#menu").click(function(){
	$("#menucontainer").css("width","100%");
});
$("#closemenu").click(function(){
$("#menucontainer").css("width","0");

});
$("#dropdown").css({"transform":"rotate(180deg)","transition":"0.2s"});
$("nav").slideUp(200);
$("#dropdown").click(function(){
	if (flag) {
	$("#dropdown").css({"transform":"rotate(0deg)","transition":"0.2s"});
	$("nav").slideDown(200);
	flag=false;
}
else{
	$("#dropdown").css({"transform":"rotate(180deg)","transition":"0.2s"});
	$("nav").slideUp(200);
	flag=true;
}
});
$("#showed").hide();
});
var x = null;
var y = null;  
function changepos(ev) {
	document.addEventListener('mousemove', onMouseUpdate, false);
document.addEventListener('mouseenter', onMouseUpdate, false);
 

}
function setpos(e) {
	document.removeEventListener('mousemove', onMouseUpdate, false);
document.removeEventListener('mouseenter', onMouseUpdate, false);

}
function onMouseUpdate(e) {
  x = e.pageX;
  y = e.pageY;
     newPos = new Object();
    newPos.left = getMouseX()-30;
    newPos.top = getMouseY()-30;
$("#notificationbutton").offset(newPos);
}

function getMouseX() {
  return x;
}

function getMouseY() {
  return y;
}
var notp=true;
function opennotification()
{
	if(notp)
	{
$("#notificationpanel").css({"width":"20vw","overflow-y":"scroll"});
$(".notificationcontent").show();
notp=false;
	}
	else
	{
			$("#notificationpanel").css({"width":"0","overflow":"unset"});
			$(".notificationcontent").hide();
			notp=true;
	}
}
function validateString(str)
{
	var patt=/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;
	if (patt.test(str))
		{
			return false;
		}else
			{
			return true;
			}

}
function empDetails(value){
//	console.log(value);
	 $("#empname").html(""); 
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if (this.readyState== 4 && this.status== 200) 
		{
			var data=this.responseText;
			
		try{
			 var employee= JSON.parse(data);
			$("#empname").html("<span style='color:tomato'>Name: </span>"+employee.fname+employee.mname+employee.lname);
		}catch(Exception){
			 $("#empname").html("<span style='color:tomato'>No employee registered with this Id.</span>");
			
		}
		}
	};
	xhttp.open("GET","employeeResource.jsp?id="+value,true);
	xhttp.send();
	
}
function showflip(){
	$("#hovered").toggle(1000);
	$("#showed").toggle(1000);
}
function upload(ev){
	ev.preventDefault();
	
}