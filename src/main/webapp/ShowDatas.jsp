<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data show</title>
</head>
<body>
	<%@ page import="miscellaneous.Dataloader"%>

	<%
	Dataloader my_data = (Dataloader) application.getAttribute("sharedDatatable");
	if (my_data == null) {
		my_data = new Dataloader();
	    application.setAttribute("sharedDatatable", my_data);
	}
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
		for (int i = 0; i < my_data.PersonDataList.size(); i++) {
		%>
		
			<%
			for (int j = 0; j < my_data.PersonDataList.get(i).Datalist.size(); j++) {
			%>
			<tr>
			<%
			for (int k = 0; k < my_data.PersonDataList.get(i).Datalist.get(j).AttributeList.size(); k++) {
			%>
			<%
			String Attribute = my_data.PersonDataList.get(i).Datalist.get(j).AttributeList.get(k);
			%>
			<td><%=Attribute%></td>
			<%
			}
			%>
			</tr>
			<%
			}
			%>
		

		<%
		}
		%>

	</table>
</body>
</html>