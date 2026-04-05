
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="assign" method="post">
Do you want assign product <b>${prodName}</b> ?
<input type="hidden" name="prodId" value="${prodId}"/>
<select name="newCatId">
<c:forEach items="${categories}" var="c">
<option value="${c.id}">${c.name}</option>
</c:forEach>
</select>
<button type="submit">Update</button>
</form>
