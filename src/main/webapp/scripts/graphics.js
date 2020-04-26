$(document).ready(function(){
	var ele1=document.createElement("canvas");
	var b1=ele1.getContext("2d");
	ele1.width=$("#record1").width();
	ele1.height=$("#record1").height();
	b1.fillStyle="#333";
	b1.fillRect(0,ele1.height-60,ele1.width,40);
	b1.fillStyle="orange";
	var posY=ele1.height-40;
	var posX=0;
	b1.beginPath();
	b1.arc(0,posY,20,0,2 * Math.PI);
	b1.fill();	 
	getNoOfEmployee();	
	
	var ele2=document.createElement("canvas");
	var b2=ele2.getContext("2d");
	ele2.width=$("#record2").width();
	ele2.height=$("#record2").height();
	b2.fillStyle="#333";
	b2.fillRect(0,ele2.height-60,ele2.width,40);
	b2.fillStyle="orange";
	var posY2=ele2.height-40;
	var posX2=0;
	b2.beginPath();
	b2.arc(0,posY2,20,0,2 * Math.PI);
	b2.fill();
	getPresentEmployee();
	
	var ele3=document.createElement("canvas");
	var b3=ele3.getContext("2d");
	ele3.width=$("#record3").width();
	ele3.height=$("#record3").height();
	b3.fillStyle="#333";
	b3.fillRect(0,ele3.height-60,ele3.width,40);
	b3.fillStyle="orange";
	var posY3=ele3.height-40;
	var posX3=0;
	b3.beginPath();
	b3.arc(0,posY3,20,0,2 * Math.PI);
	b3.fill();
	getLeaveEmp();
			

function getNoOfEmployee(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==1){
			$("#record1").html("<img src='icons/loading.gif' class='icons'>");
		}
		if(this.readyState==4 && this.status==200){
			try{
				$("#record1").html("<div class='labels center'>Total Employees:<span id='totalemp'></span></div>");
				document.getElementById("record1").appendChild(ele1);
				var number=JSON.parse(this.responseText);
				var totalEmp=number.no;
				$("#totalemp").text(totalEmp);
				var recruitment=100;
				var progress=(totalEmp/recruitment)*ele1.width;
				var dx=1,dy=0;
				setInterval(function(){
					posX+=dx;
					b1.beginPath();
					b1.arc(posX,posY,20,0,2 * Math.PI);
					b1.fill();
					if(posX>progress){
						dx=0;
					}
				},20);
				
				
			return 0;
				
			}catch(Exception){console.log(Exception);return 0;}
		}
	};
	xhttp.open("GET","employeecount",true);
	xhttp.send();
	
}
function getPresentEmployee(){
	dx=1;

	$("#record2").html("<div class='labels center'>Employees present:<span id='emppresent'></span></div>");
	document.getElementById("record2").appendChild(ele2);
	setInterval(function(){
		posX2+=dx;
		b2.beginPath();
		b2.arc(posX2,posY2,20,0,2 * Math.PI);
		b2.fill();
		if(posX2>ele2.width-100){
			dx=0;
		}
	},5);
	return 0;
}

function getLeaveEmp(){
	dx=1;
	$("#record3").html("<div class='labels center'>Employees present:<span id='emppresent'></span></div>");
	document.getElementById("record3").appendChild(ele3);
	setInterval(function(){
		posX3+=dx;
		b3.beginPath();
		b3.arc(posX3,posY3,20,0,2 * Math.PI);
		b3.fill();
		if(posX3>ele3.width-100){
			dx=0;
		}
	},5);	
	return 0;
}
});
