------------
1. Overview
------------

	Ticketz is a web application made in Java 1.6 for the 2.5 Servlet specification, 
that can be deployed in the Apache Tomcat 6.0 (or higher) application server.

	It uses Maven (Open Source - Apache build manager for Java projects) to manage the 
dependencies and build the system, Spring 3 (Open Source Java application framework) and
Hibernate 3 (open source Java persistence framework) for the server implementation, 
and just a common internet browser as a client. For the database server, it uses HSQLDB, 
(Open Source lightweight relational database engine written in Java). It was coded in Eclipse
(Open Source IDE for java), on a Ubuntu Linux machine (Open Source operational system).
 

--------------
2. How to use
--------------

	After installing the server application, a partner using a common Internet browser as 
client application can login to the server URL, and will be presented with the first screen.

	The client can enter his name and number of seats desired, and press "Reserve Tickets".
If there are enough tickets available, the system will show a confirmation screen, where the
seat numbers are displayed. 

	The client can accept the displayed seats, request different seats or cancel the request.
If he request different seats, different seat numbers will be shown in the same page for 
confirmation.

	After the client confirms his request, the tickets will be reserved for him. A success page
will be shown, and client can go back to the first page to request more tickets.    


--------------------
3. Things to improve
--------------------

	Ticketz uses a simple implementation for security (BASIC authentication), considering that 
the security requirements are not so high. If the security should be improved, Spring Security 
can be used to add complete user management, and the server can be configured to use encripted
(https) connection.

	Ticketz was completly based on the "Skype Web developer test assignment" documentation, and
lacks some features. It would be interesting to add Events to the system, so that partners can
create an Event for a specific date, with a specific number of seats, and clients could see and
choose from the list of events available. Also, clients could be able to select the seat number
from the available seats.


---------------
3. Requirements
---------------
To install the Ticketz webapp, the following is required:
- Computer with an OS (windows/unix/linux) capable of running java
- Sun Java JRE 1.6 or higher installed
- Apache Tomcat 6.0 or higher installed
     