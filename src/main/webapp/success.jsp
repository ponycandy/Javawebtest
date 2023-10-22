<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>登录成功</title>
</head>
<body>
	<h3 style="text-align: center">
		恭喜，<%=request.getParameter("username")%>，登录成功！
	</h3>
</body>
<%@ page import="miscellaneous.Dataloader"%>

<h3 style="text-align: center">事务</h3>


<!-- Link to your SampleServlet -->

<%
	Dataloader my_data = (Dataloader) application.getAttribute("sharedDatatable");
	if (my_data == null) {
		my_data = new Dataloader();
	    application.setAttribute("sharedDatatable", my_data);
	}
	%>

<div style="text-align: center;">
	<a href="Chargeup.jsp" style="font-size: 32px;">记账</a>
</div>

<div style="text-align: center;">
	<a href="RecordMoney.jsp" style="font-size: 32px;">记录</a>
</div>
<div style="text-align: center;">
	<a href="Notation.jsp" style="font-size: 32px;">撰写</a>
</div>
<div style="text-align: center;">
	<a href="Feedback.jsp" style="font-size: 32px;">反馈</a>
</div>

</html>
