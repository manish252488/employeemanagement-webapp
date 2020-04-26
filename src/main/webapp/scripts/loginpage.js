$(document).ready(function() {
$("#errorpanel").hide();
});
function error(val)
{

	if(validateString(val)){
		$("#errorpanel").text("");
		$("#errorpanel").slideUp(300);
		return true;
	}
	else{
		$("#errorpanel").text("specialcharacters not allowed!");
		$("#errorpanel").slideDown(300);
		return false;
	}
}
function validate()
{
	var username=$("input[name='empid']").val();
	if(error(username))
		return true;
	else
		return false;
	

}