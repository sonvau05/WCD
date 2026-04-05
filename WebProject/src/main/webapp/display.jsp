
<%@ page import="jakarta.servlet.http.Cookie" %>
<h2>Display</h2>
<%
Cookie[] cookies = request.getCookies();
if(cookies!=null){
 for(Cookie c: cookies){
  if(c.getName().equals("fname")) out.print("First Name: "+c.getValue()+"<br>");
  if(c.getName().equals("lname")) out.print("Last Name: "+c.getValue()+"<br>");
 }
}
%>
