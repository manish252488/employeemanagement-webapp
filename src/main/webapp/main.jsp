
<div id="notificationbutton" draggable="true" ondragstart ="changepos(event)" ondblclick="setpos(event)">
	
	<span id="notification">drag and double click to set position!</span>
	<span id="quickicons">
	<button class="quick" onclick="window.location='index.jsp'">
		<img alt="h" src="icons/home.png" class="icons"></button>
		<button class="quick" onclick="opennotification()">
		<img alt="n" src="icons/noti.png" class="icons"></button>
		<button class="quick" id="registerbtn" onclick="window.location='Register.jsp?u=false'">
		<img alt="r" src="icons/register.png" class="icons"></button>
		<button class="quick" id="logout"  onclick="window.location='logout.jsp'"><img alt="l" src="icons/logou.png" class="icons"></button></span>
</div>


<div id="notificationpanel">
		<div class="notificationcontent">
		<div id="closenotipanel" onclick="opennotification()">
		<img src="icons/close.png">
		</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
		<div class="noti">im ma text here</div>
	</div>
</div>
	<div id="menucontainer">
	<img src="icons/close.png" id="closemenu">
	<div class="menuitems">
		<div class="menuitem"><span>item1</span></div>
		<div class="menuitem"><span>item1</span></div>
		<div class="menuitem"><span>item1</span></div>
		<div class="menuitem"><span>item1</span></div>
		<div class="menuitem"><span>item1</span></div>
		<div class="menuitem"><span>item1</span></div>
		
	</div>
	</div>

<header>
	<div class="menu" id="menu">
		<div class="bars"></div>
		<div class="bars"></div>
		<div class="bars"></div>

	</div>
	<div id="title">employee admin</div>
	<div id="dropdown" onclick="dropdown()"><img src="icons/Drop.png" class="icons"></div>
</header>
<nav id="tasks">
	<button class="link-btn" onclick="window.location='createdept.jsp'">create department</button>
	<button class="link-btn" onclick="window.location='Register.jsp?u=false'">add employee</button>
	<button class="link-btn" onclick="window.location='Register.jsp?u=true'">update employee</button>
	<button class="link-btn" onclick="deletePanel()">deleteEmployee</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>
	<button class="link-btn">button1</button>

</nav>
<%@include file="deleteemp.jsp" %>
<script>
function deletePanel(){
	document.getElementById("deleteempform").style.display="block";
}
</script>
