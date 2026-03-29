
<%@ page import="java.util.*,model.Event" %>
<html>
<body>
<h2>Add Event</h2>
<form method="post">
Name:<input name="name" required minlength="5"/><br/>
Date:<input type="date" name="date" required/><br/>
Venue:<input name="venue" required/><br/>
Seats:<input type="number" name="seats" required min="1"/><br/>
<button>Add Event</button>
</form>

<h2>Event List</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Date</th><th>Venue</th><th>Seats</th></tr>
<%
List<Event> list=(List<Event>)request.getAttribute("events");
if(list!=null)
for(Event e:list){
%>
<tr>
<td><%=e.getId()%></td>
<td><%=e.getName()%></td>
<td><%=e.getDate()%></td>
<td><%=e.getVenue()%></td>
<td><%=e.getSeats_available()%></td>
</tr>
<% } %>
</table>
</body>
</html>
