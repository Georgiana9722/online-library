<!DOCTYPE html>
<html>
<head>
  <title>Categories</title>
</head>
<body>
<h1>Categories</h1>

<!-- List of categories -->
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  <c:forEach var="category" items="${categories}">
    <tr>
      <td>${category.id}</td>
      <td>${category.name}</td>
    </tr>
  </c:forEach>
</table>

<!-- Add category -->
<h2>Add Category</h2>
<form action="/categories/add" method="post">
  Name: <input type="text" name="name"><br>
  <button type="submit">Add</button>
</form>

<a href="/index.jsp">Back to Home</a>
</body>
</html>
