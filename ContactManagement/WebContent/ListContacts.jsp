<%@ page import="java.util.*,com.aptech.dao.ContactDAO,com.aptech.entity.Contact"%>
<%
ContactDAO dao=new ContactDAO();
List<Contact> list=dao.getAll();
%>
<h3>Total: <%=list.size()%></h3>
<table border=1>
<tr><th>ID</th><th>Name</th><th>Phone</th><th>Group</th><th>Action</th></tr>
<% for(Contact c:list){ %>
<tr>
<td><%=c.getId()%></td>
<td><%=c.getFirstName()+" "+c.getLastName()%></td>
<td><%=c.getPhoneNumber()%></td>
<td><%=c.getGroup().getName()%></td>
<td>
<a href="DeleteContactServlet?id=<%=c.getId()%>">Remove</a>
</td>
</tr>
<% } %>
</table>
<a href="AddContact.jsp">Add Contact</a>
