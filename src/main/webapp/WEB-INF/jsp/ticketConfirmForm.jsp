<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <li class="active">Confirm</li>
        <li>Booked</li>
    </ul>
</div>

<div id="content">
<h2>Confirm ticket reservation</h2>
<form:form method="POST" commandName="ticketRequest">
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
		<td colspan="2">
		<c:choose>
		    <c:when test="${ticketRequest.amount > fn:length(ticketRequest.tickets)}">
				<div class="error">Sorry, not enough tickets available to fulfill your request</div>
			</c:when>
			<c:otherwise>
				<input type="submit" class="button" name="save" value="Confirm" />
				<input type="submit" class="button" name="cancel" value="Request other tickets" />
			</c:otherwise>      
		</c:choose>
		<input type="submit" class="button" name="delete" value="Cancel" />
		</td>
	</tr>
</table>
</form:form>
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