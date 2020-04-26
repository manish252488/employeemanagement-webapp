"use strict"
$(document).ready(function(){

});

		

function checkname(s)
{
	$("#err").text("");
	$("#err").html("");
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if (this.readyState== 4 && this.status== 200) 
		{
			 var response = JSON.parse(this.responseText);
			 var res=response.value;
			if(res && validateString(s)){
				$("#err").html("<img src='icons/giphy.gif' class='smallicons'>");
				}
			else{
				$("#err").html("<p>Invalid name or don't use special chars!</p>");
			
			}
		}
	};
	xhttp.open("GET","checkdepartment.jsp?x="+s,true);
	xhttp.send();

}
function validate2(str)
{
	var check=!validateString(str);
	$("#err2").html("");
	if(check)
		{
		$("#err2").html("<p>don't use special chars!</p>");
		}
	else
		$("#err2").html("<img src='icons/giphy.gif' class='smallicons'>");
}
function validate3(str)
{
	var check=!validateString(str);
	$("#err3").html("");
	if(check)
		{
		$("#err3").html("<p>don't use special chars!</p>");
		}
	else
		$("#err3").html("<img src='icons/giphy.gif' class='smallicons'>");
}

function setDept(val){
	$("#dept").val(val);
	}
function searchdepartment(value){
	var str="";
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if (this.readyState== 4 && this.status== 200) 
		{
			 var array= JSON.parse(this.responseText);
			for(var i=0;i<array.length;i++)
				{
				var id=array[i].deptid;
				var name=array[i].name;
				str+="<span onclick='setvalue("+id+",this)'>"+name+"</span>";
				}
			console.log(str);
			$("#searchresult").css({"overflow-y":"scroll","display":"block"});
			$("#searchresult").html(str);
		}
	};
	xhttp.open("GET","checkId.jsp?x="+value,true);
	xhttp.send();
}
function hide(){$("#searchresult").css({"overflow-y":"hidden","display":"none"});}
function setvalue(a,b)
{
	hide();
	var txt=$(b).text();
	txt=txt.trim();
	setDept(a);
	$("#deptname").val(txt);
	var code="";
	var k=0;
	while(k < txt.length-1)
		{
			if(k == 0)
				{
				code=code+txt.charAt(k);
				}
			if(txt.charAt(k)==" ")
				code=code+txt.charAt(k+1);
			k++;
		}
	$("#selectdept").html("<option selected>"+code+"</option>");
}
function setFields(value){
//	console.log(value);
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if (this.readyState== 4 && this.status== 200) 
		{
			var data=this.responseText;
			 var employee= JSON.parse(data);
			 $("input[name='salid']").val(employee.salid)
			 $("input[name='deptname']").val(employee.deptname);
			 $("#selectdept").html("<option selected>"+employee.deptcode+"</option>");
			 $("input[name='dept']").val(employee.deptid);
			 $("input[name='fname']").val(employee.fname);
			 $("input[name='mname']").val(employee.mname);
			 $("input[name='lname']").val(employee.lname);
			 $("input[name='bdate']").val(employee.bdate);
			 
			 $("input[name='sex']").val(employee.sex);
			 $("input[name='phno1']").val(employee.phno1);
			 $("input[name='phno2']").val(employee.phno2);
			 $("input[name='email']").val(employee.email);
			 $("input[name='salary']").val(employee.sal);
			 
			 $("input[name='bonus']").val(employee.bonus);
			 $("input[name='job']").val(employee.job);
			 $("input[name='add1']").val(employee.add1);
			 $("input[name='add2']").val(employee.add2);
			 $("input[name='adharno']").val(employee.adharno);
			 $("input[name='panno']").val(employee.panno);
			 $("input[name='state']").val(employee.state);
			 $("input[name='city']").val(employee.city);
			 $("input[name='pincode']").val(employee.pin);
			 $("input[name='accno']").val(employee.acc);
			 
			 $("input[name='ifsc']").val(employee.ifsc);
			 $("input[name='bank_name']").val(employee.bankname);
		}
	};
	xhttp.open("GET","employeeResource.jsp?id="+value,true);
	xhttp.send();
	
}