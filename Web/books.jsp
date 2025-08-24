<!DOCTYPE html>
<html>
<head>
  <title>Books</title>
</head>
<body>
<h1>Books</h1>

<!-- List of books -->
<table border="1">
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.id}</td>
      <td>${book.title}</td>
      <td>${book.author.name}</td>
    </tr>
  </c:forEach>
</table>

<!-- Add book form -->
<h2>Add Book</h2>
<form action="/books/add" method="post">
  Title: <input type="text" name="title"><br>
  Author ID: <input type="number" name="author.id"><br>
  <button type="submit">Add</button>
</form>

<a href="/authors">Go to Authors</a> |
<a href="/categories">Go to Categories</a> |
<a href="/index.jsp">Back to Home</a>
</body>
</html>
