<!DOCTYPE html>
<html>
<head>
  <title>Authors</title>
</head>
<body>
<h1>Authors</h1>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  <c:forEach var="author" items="${authors}">
    <tr>
      <td>${author.id}</td>
      <td>${author.name}</td>
    </tr>
  </c:forEach>
</table>

<h2>Add Author</h2>
<form action="/authors/add" method="post">
  Name: <input type="text" name="name"><br>
  <button type="submit">Add</button>
</form>

<a href="/books">Go to Books</a> |
<a href="/users">Go to Users</a> |
<a href="/index.jsp">Back to Home</a>
</body>
</html>
