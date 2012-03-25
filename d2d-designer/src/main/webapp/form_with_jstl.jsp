<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h1>Sign Up</h1>

<form action="submit.html">
  <c:if test="${not empty errors}">
  <div id="errors" class="error_messages">
    <h2>Form is invalid</h2>
    <ul>
        <c:forEach var="message" items="${errors}">
        <li>${message}</li>
        </c:forEach>
    </ul>
  </div>
  </c:if>
  <p>
    <label for="email">${email.label}</label><br/>
    <input type="text" value="${email.value}"/><br/>
  </p>
  <p>
    <label for="password">${password.label}</label><br/>
    <input type="password" value="${password.value}"/><br/>
  </p>
  <p class="button"><input type="submit" value="Create User" /></p>
</form>

</body>
</html>
