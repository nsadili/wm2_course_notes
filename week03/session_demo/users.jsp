<%@ page import = "java.util.*"%>

<html>
<head>
	<title>User Listing</title>
</head>
<body>



<%
   List<String> users =(List)session.getAttribute("user_list");
   String current_user =(String)session.getAttribute("current_user");
   out.println("Welcome " + current_user);
   for(String user : users){
   	out.println(user);
   }
   //comment
%>

	
</body>
</html>