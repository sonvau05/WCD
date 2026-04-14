<%@ page import="java.util.*,com.aptech.dao.GroupDAO"%>
<%
GroupDAO dao=new GroupDAO();
List groups=dao.getAll();
%>
<form action="AddContactServlet" method="post">
First: <input name="firstName"/><br>
Last: <input name="lastName"/><br>
Phone: <input name="phoneNumber"/><br>
Group:
<select name="groupId">
<% for(Object o:groups){ %>
<option value="<%=((com.aptech.entity.Group)o).getId()%>">
<%=((com.aptech.entity.Group)o).getName()%>
</option>
<% } %>
</select><br>
<button>Save</button>
</form>
<a href="ListContacts.jsp">Return To Contact List</a>
