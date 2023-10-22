<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Done</title>
</head>
<body>
	<%@ page import="miscellaneous.Dataloader"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="miscellaneous.PieceOfdata"%>
	<%@ page import="java.time.LocalDate"%>
	<h1>Done</h1>
	<%-- Retrieve the submitted values using request.getParameter() --%>
	<% request.setCharacterEncoding("utf-8"); %>
	<% int codec =  Integer.parseInt(request.getParameter("codec")); %>
	<% int paid = Integer.parseInt(request.getParameter("paid")); %>
	<% String notation = request.getParameter("notation"); %>
	<% String name = request.getParameter("name"); %>
	<% String others = request.getParameter("others"); %>
	<%  
	LocalDate currentDate = LocalDate.now(); 
	int month=currentDate.getMonth().ordinal()+1;
	int year=currentDate.getYear();
	int day=currentDate.getDayOfMonth();
	PieceOfdata datanew=new PieceOfdata();
	datanew.setAttribute(codec,name,paid, day, month, year,notation,others);
	
	Dataloader my_data = (Dataloader) application.getAttribute("sharedDatatable");
	if (my_data == null) {
		my_data = new Dataloader();
	    application.setAttribute("sharedDatatable", my_data);
	}
	my_data.addRecord(datanew);
	%>
	<h1>跳转</h1>


	<a href="Chargeup.jsp">记账</a>

</body>
</html>