<%@ page import="java.util.*, com.tracker.entity.JobPosting" %>
<table border="1">
<tr><th>ID</th><th>Title</th><th>Company</th><th>Location</th><th>Date</th></tr>
<%
List<JobPosting> jobs = (List<JobPosting>) request.getAttribute("jobs");
for(JobPosting j : jobs){
%>
<tr>
<td><%=j.getId()%></td>
<td><%=j.getTitle()%></td>
<td><%=j.getCompany()%></td>
<td><%=j.getLocation()%></td>
<td><%=j.getDate_posted()%></td>
</tr>
<% } %>
</table>