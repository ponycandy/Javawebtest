<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchDatas</title>
</head>
<body>
	<%@ page import="miscellaneous.Dataloader"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="miscellaneous.PieceOfdata"%>
	<h1>Result Page</h1>
	<%-- Retrieve the submitted values using request.getParameter() --%>
	<% String year = request.getParameter("year"); %>
	<% String month = request.getParameter("month"); %>
	<% String day = request.getParameter("day"); %>
	<% String searchKey = year+"/"+month+"/"+day+"/"; %>
	<%
	Dataloader my_data = (Dataloader) application.getAttribute("sharedDatatable");
	if (my_data == null) {
		my_data = new Dataloader();
	    application.setAttribute("sharedDatatable", my_data);
	}
	ArrayList<PieceOfdata> listdata=my_data.searchDatekey(searchKey);
	%>
	<table border="1" cellpadding="10" style="margin: 0px auto">

		<tr>
			<%
			for (int i = 0; i < my_data.headerNums; i++) {
			%>
			<th><%=my_data.headerList.get(i)%></th>
			<%
			}
			%>
		</tr>



		<%
			for (int j = 0; j < listdata.size(); j++) {
			%>
		<tr>
			<%
					PieceOfdata piecedata=listdata.get(j);
					
			for (int k = 0; k < piecedata.AttributeList.size(); k++) {
			%>
			<td><%=piecedata.AttributeList.get(k)%></td>
			<%
			}
			%>
			<%
			}
			%>
		</tr>




	</table>

</body>
</html>