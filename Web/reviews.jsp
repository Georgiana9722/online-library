<!DOCTYPE html>
<html>
<head>
  <title>Reviews</title>
</head>
<body>
<h1>Reviews</h1>

<!-- List of reviews -->
<table border="1">
  <tr>
    <th>ID</th>
    <th>User</th>
    <th>Book</th>
    <th>Rating</th>
    <th>Comment</th>
    <th>Created At</th>
  </tr>
  <c:forEach var="review" items="${reviews}">
    <tr>
      <td>${review.id}</td>
      <td>${review.user.username}</td>
      <td>${review.book.title}</td>
      <td>${review.rating}</td>
      <td>${review.comment}</td>
      <td>${review.createdAt}</td>
    </tr>
  </c:forEach>
</table>

<!-- Add review -->
<h2>Add Review</h2>
<form action="/reviews/add" method="post">
  User ID: <input type="number" name="user.id"><br>
  Book ID: <input type="number" name="book.id"><br>
  Rating (1-5): <input type="number" min="1" max="5" name="rating"><br>
  Comment: <textarea name="comment"></textarea><br>
  <button type="submit">Add Review</button>
</form>

<a href="/index.jsp">Back to Home</a>
</body>
</html>
