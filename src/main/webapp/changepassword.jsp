<%@page import="ems.functions.EmsImages"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="ems.model.Employee"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.orm.hibernate5.HibernateTemplate"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<link href="<%=EmsImages.getMainIconPath()%>" rel="icon" type="png/jpg">
<%@ page language="java" isELIgnored="false"%>

<script>
function validatepassword(){
	$("#errorpanel").slideUp(200);
	var oldpass=$("input[name='opass']").val();
	var newpass1=$("input[name='newpass1']").val();
	var newpass2=$("input[name='newpass2']").val();
	if(newpass1!=newpass2){
		$("#errorpanel").text("re-entered password not matched!");
		$("#errorpanel").slideDown(200);
		return false;
	}
	else{
		var xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange=function(){
			if (this.readyState== 4 && this.status== 200) 
			{
				 var response = JSON.parse(this.responseText);
				 var res=response.value;
				 console.log(res);
				if(!res){
					$("#errorpanel").text("old password not matched!");
					$("#errorpanel").slideDown(200);
					return false;
					}
				else
					return true;
			}
		};
		xhttp.open("GET","checkpassword.jsp?x="+oldpass,true);
		xhttp.send();
	}
}

</script>
<%
ApplicationContext ctx=new ClassPathXmlApplicationContext("HibernateTemplate.xml");
HibernateTemplate template=(HibernateTemplate)ctx.getBean("template");
Session s=template.getSessionFactory().openSession();
	Transaction tx=s.beginTransaction();
	Employee emp=(Employee)s.get(Employee.class,(Integer)session.getAttribute("empid"));
	tx.commit();
// 	if(emp.getUser().getLastLogedIn()!=null) {
// 		response.sendRedirect("index.jsp");
// 	}
		
%>
<div id="errorpanel">im an error</div>

<div id="changepassword">
<fieldset>
		<legend>Enter your new Password</legend>
<form action="updateuser" method="post" onsubmit="return validatepassword()">
<table>
<tr><td>enter your old password</td><td><input type="text" class="fields" name="opass" onblur="validatepassword()"></td></tr>
<tr><td>enter new password</td><td><input type="text" class="fields" name="newpass1"></td></tr>
<tr><td>re-enter new password</td><td><input type="text" class="fields" name="newpass2" onblur="validatepassword()"></td></tr>
<tr><td><input type="submit" value="change password"  class="btn">
<tr>

</tr>
</table>
</form>
</fieldset>

</div>
