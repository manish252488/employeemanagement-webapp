
    <head>
    <style type="text/css">
    #deleteempform{
    width:40%;
    padding:1vw;
    position:fixed;
    z-index:2;
    background:#fff;
    filter:brightness(2);
    border:0.1vw solid #333;
    margin-left:30%;
    margin-top:10%;
    display:none;
    overflow:hidden;
    transition:0.2s;
    }
    
    .inputdel{
    width:80%;
    padding:0.5vw;
    color:#fff;
    background:#333;
    border-radius:1vw;
    font-size:1.2vw;
    border:0.2vw solid #ddd;
    }
    .btndel
    {
    width:20%;
    padding:0.5vw;
    font-size:1.5vw;
    background:red;
    color:#fff;
    font-weigth:bolder;
    cursor:pointer;
    }
    #fl001{
    border:0.2vw solid black;
    }
   #l001{
    margin:auto;
    font-size:1.2vw;
    text-transform:capitalize;
    }
    #closebutton{
    width:2vw;
    height:2vw;
    position:absolute;
    right:0;
    top:0;
    overflow:hidden;
    background:red;
    border-radius:50%;
    cursor:pointer;
    } #closebutton:hover
    {
    transform:scale(1.1);
    }
    </style>
    </head>
<div id="deleteempform">
<div id="closebutton" onclick="closedeleteform()"><img src="icons/close.png" style="width:100%"></div>
<fieldset id="fl001">
<legend id="l001">delete Employee</legend>
<form action="deleteemp" method="get" onsubmit="return validate()">
<input type="text" name="empid" id="empid" class="inputdel" required><input type="submit" value="delete" class="btndel">
</form>
</fieldset>
<script>
function validate()
{
var id=	document.getElementById("empid").value;
var x=window.confirm("sure to delete? employee id:"+id);
if(x)
	{
	return true;
	}else{
		return false;
	}
}
function closedeleteform()
{
document.getElementById("deleteempform").style.display="none";
}
</script>
</div>
