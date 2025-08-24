<!DOCTYPE html>
<html>
<head>
    <title>Loans</title>
</head>
<body>
<h1>Loans</h1>

<!-- List of loans -->
<table border="1">
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Book</th>
        <th>Loan Date</th>
        <th>Return Date</th>
    </tr>
    <c:forEach var="loan" items="${loans}">
        <tr>
            <td>${loan.id}</td>
            <td>${loan.user.username}</td>
            <td>${loan.book.title}</td>
            <td>${loan.loanDate}</td>
            <td>${loan.returnDate}</td>
        </tr>
    </c:forEach>
</table>

<!-- Add loan -->
<h2>Add Loan</h2>
<form action="/loans/add" method="post">
    User ID: <input type="number" name="user.id"><br>
    Book ID: <input type="number" name="book.id"><br>
    Loan Date: <input type="date" name="loanDate"><br>
    Return Date: <input type="date" name="returnDate"><br>
    <button type="submit">Add Loan</button>
</form>

<a href="/index.jsp">Back to Home</a>
</body>
</html>
