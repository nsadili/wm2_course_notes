<%@ page import = "ada.wm2.helper.Counter" %>
<html>
<head>
	<title>Counter!</title>
</head>
<body>
	<h2>Welcome to my counter</h2>
 You are the visitor no
	<%
	out.print(Counter.getCount());
    %>
 !

</body>
</html>