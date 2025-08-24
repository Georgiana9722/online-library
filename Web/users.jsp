<!DOCTYPE html>
<html>
<head>
  <title>Users</title>
</head>
<body>
<h1>Users</h1>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Username</th>
  </tr>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.username}</td>
    </tr>
  </c:forEach>
</table>

<h2>Add User</h2>
<form action="/users/add" method="post">
  Username: <input type="text" name="username"><br>
  <button type="submit">Add</button>
</form>

<a href="/index.jsp">Back to Home</a>
</body>
</html>
