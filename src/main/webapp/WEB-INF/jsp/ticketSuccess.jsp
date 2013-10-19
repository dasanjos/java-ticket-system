<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Skype TicketSystem</title>
<link type="text/css" rel="stylesheet" href="img/style.css" > 
</head>
<body>
<div id="header">
	<a title="skype.com" id="skypeLogo" href="<%=request.getContextPath() %>">
		<img width="105" height="47" alt="Skype Logo" src="img/skype_logo.png">
		TicketSystem
	</a>
</div>
<div id="mainNavigation">
    <ul>
        <li>Reserve</li> 
        <li>Confirm</li>
        <li class="active">Booked</li>
    </ul>
</div>

<div id="content">
<c:if test="${not empty tickets}">
<div id="tickets">
<h2>Reserved Seats</h2>
<table><tr>
<c:forEach var="ticket" items="${tickets}">
	<td <c:if test="${ticket.reserved}">style="color:red"</c:if>><c:out
		value="${ticket.seat}"></c:out></td>
	<c:if test="${ticket.seat%12==0}"></tr><tr></c:if>
</c:forEach>
</tr></table>
</div>
</c:if>

<h2>Ticket reservation confirmed</h2>
<table>
	<tr>
		<td>Name :</td>
		<td>${ticketRequest.name}</td>
	</tr>
	<tr>
		<td>Tickets :</td>
		<td>${ticketRequest.tickets}</td>
	</tr>
	<tr>
		<td colspan="2"><a href="<%=request.getContextPath() %>">Back to start</a></td>
	</tr>
</table>
</div>

<div id=footer>
	<div id="footerNavigation">
		<a href="http://www.skype.com/go/about">About us</a> · <a href="http://www.skype.com/go/partners">Partners</a> · <a href="http://www.skype.com/go/jobs">Jobs</a> · <a href="http://www.skype.com/go/prices">Prices</a> · <a href="http://www.skype.com/go/security">Security</a>
	</div>
	<div id="legalLinks">
		<a title="" href="http://www.skype.com/go/legal.privacy">Privacy policy</a> · <a href="http://www.skype.com/go/legal">Legal</a> · <span>&copy; 2010  Skype Limited</span>
	</div>	
</div>
</body>
</html>