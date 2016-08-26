<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<td>
<form action="MovieHandler" method="post">
<input type="submit" value="Add Movies"/>
</form>
</td>

<td>
<form action="BookTicket" method="post">
<input type="submit" value="Book Ticket"/>
</form>
</td>


<td>
<form action="DisplayBookingHistory" method="post">
<input type="submit" value="Display Booking History">
</form>
</td>

<td>
<form action="DisplayMoviesShow" method="post">
<input type="submit" value="Remove Movies">
</form>
</td>

<td>
<form action="Logout" method="post">
<input type="submit" value="Log out"/>
</form>
</td>

</table>
</body>
</html>