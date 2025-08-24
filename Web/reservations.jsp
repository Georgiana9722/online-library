<!DOCTYPE html>
<html>
<head>
  <title>Reservations</title>
</head>
<body>
<h1>Reservations</h1>

<!-- List of reservations -->
<table border="1">
  <tr>
    <th>ID</th>
    <th>User</th>
    <th>Book</th>
    <th>Reserved At</th>
  </tr>
  <c:forEach var="reservation" items="${reservations}">
    <tr>
      <td>${reservation.id}</td>
      <td>${reservation.user.username}</td>
      <td>${reservation.book.title}</td>
      <td>${reservation.reservedAt}</td>
    </tr>
  </c:forEach>
</table>

<!-- Add reservation -->
<h2>Add Reservation</h2>
<form action="/reservations/add" method="post">
  User ID: <input type="number" name="user.id"><br>
  Book ID: <input type="number" name="book.id"><br>
  <button type="submit">Reserve</button>
</form>

<a href="/index.jsp">Back to Home</a>
</body>
</html>
