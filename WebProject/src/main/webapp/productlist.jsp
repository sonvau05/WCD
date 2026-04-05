
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>Product list</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Description</th><th>Action</th></tr>
<c:forEach items="${products}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.name}</td>
<td><fmt:formatNumber value="${p.price}" type="currency" currencySymbol="$"/></td>
<td>${p.description}</td>
<td><a href="assign?prodId=${p.id}&prodName=${p.name}">Assign</a></td>
</tr>
</c:forEach>
</table>
<a href="category">Back</a>
