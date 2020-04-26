$(document).ready(function() {
	$(".helptool").fadeOut(2000);
		$("#help").mouseenter(function(){
			$(".helptool").fadeIn(2000);
		});
		$("#help").mouseleave(function() {
		$(".helptool").fadeOut(2000);
		});
$("#help").click(function()
{
});
$("#menu").click(function(){
	$("#menuconatiner").css("width","100%");
});
$("#closemenu").click(function(){
	$("#menuconatiner").css("width","0");
});
});
