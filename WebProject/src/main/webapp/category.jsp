
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Category list</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Description</th><th>Action</th></tr>
<c:forEach items="${categories}" var="c">
<tr>
<td>${c.id}</td>
<td>${c.name}</td>
<td>${c.description}</td>
<td><a href="product?catId=${c.id}">Show Products</a></td>
</tr>
</c:forEach>
</table>
