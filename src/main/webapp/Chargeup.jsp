<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@ page import="miscellaneous.Dataloader"%>


<head>
<meta charset="UTF-8">
<title>Table Example</title>
</head>
<body>
	<h3 style="text-align: center">数据检索</h3>
		<%@ page import="java.time.LocalDate"%>
	
	<%  
	LocalDate currentDate = LocalDate.now(); 
	int month=currentDate.getMonth().ordinal()+1;
	int year=currentDate.getYear();
	int day=currentDate.getDayOfMonth();
	%>
	<form action="SearchForDataByDate.jsp" method="post">
		<table border="1" cellpadding="10" style="margin: 0px auto">
			<tr>
				<td align="center">按照日期检索</td>
				<td><label for="year">Year:</label> <input type="number"
					id="year" name="year" value=<%=year%> required><br> <br>
					<label for="month">Month:</label> <input type="number" id="month"
					name="month" value=<%=month%> required><br> <br> <label
					for="day">Day:</label> <input type="number" id="day" name="day"
					value=<%=day%> required><br> <br></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="检索" /></td>
			</tr>
		</table>
	</form>

	<form action="SearchForDatabyorder.jsp" method="post">
		<table border="1" cellpadding="10" style="margin: 0px auto">
			<tr>
				<td align="center">按照编号检索</td>
				<td><input type="number" name="order" /></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="检索" /></td>
			</tr>
		</table>
	</form>
	<h3 style="text-align: center">数据显示页面</h3>
	<div style="text-align: center;">
		<a href="ShowDatas.jsp" style="font-size: 32px;">DataTables</a>
	</div>


	<form action="AddRecord.jsp" method="post">
		<table border="1" cellpadding="10" style="margin: 0px auto">
			<tr>
				<td align="center">添加新的数据</td>
			</tr>
			<tr align="center">
				<td colspan="2">
				
				<label for="codec">编号</label>
				 <input type="number" id="codec" name="codec" value="1112" required>
				 <br> <br>
				 
						<label for="name">姓名</label> 
					<input type="text" id="name" name="name" value="小野" required>
					<br> <br> 
					
					<label for="paid">款项</label> 
					<input type="number" id="paid" name="paid" value="100" required>
					<br> <br> 
			
									<label for="notation">备注</label> 
					<input type="text" id="notation" name="notation" value=" " required>
					<br> <br>
													<label for="others">其它</label> 
					<input type="text" id="others" name="others" value=" " required>
					<br> <br>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="添加" /></td>
			</tr>
			
		</table>
	</form>

</body>
</html>
