<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
       <p><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></p>
       <sec:authorize access="hasRole('ROLE_ADMINISTRATOR')">
			<form action="j_spring_security_switch_user" method="POST">
				Switch to user: <input type="text" name="j_username" /><br/>
				<input type="submit" value="Switch"/>
			</form>
       </sec:authorize>
	</c:if>
</body>
</html>