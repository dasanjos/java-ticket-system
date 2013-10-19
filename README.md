java-ticket-system
==================

Java server-based ticket selling solution for 2010 Skype Web developer test assignment.


1. Overview
------------

Ticketz is a web application made in Java 1.6 for the 2.5 Servlet specification that can be deployed in the Apache Tomcat 6.0 (or higher) application server.
It uses Maven (Open Source - Apache build manager for Java projects) to manage the  dependencies and build the system, Spring 3 (Open Source Java application framework) and
Hibernate 3 (open source Java persistence framework) for the server implementation, and just a common internet browser as a client. 
For the database server, it uses HSQLDB, 
(Open Source lightweight relational database engine written in Java). 
It was developed using Eclipse (Open Source IDE for java) on a Ubuntu Linux machine (Open Source operational system).
 

2. How to use
--------------

After installing the server application, a client using an Internet browser as client application can login to the server URL, and will be presented with the first screen.

The client can enter his name and number of seats desired, and press "Reserve Tickets". If there are enough tickets available, the system will show a confirmation screen, where the seat numbers are displayed. 

The client can accept the displayed seats, request different seats or cancel the request. If he request different seats, different seat numbers will be shown in the same page for confirmation.

After the client confirms his request, the tickets will be reserved for him. A success page will be shown, and client can go back to the first page to request more tickets.    


3. Things to improve
--------------------

Ticketz uses a simple implementation for security (BASIC authentication), considering that the security requirements are not so high. If the security should be improved, Spring Security can be used to add complete user management, and the server can be configured to use encripted (https) connection.

Ticketz was completly based on the "Skype Web developer test assignment" documentation, and lacks some features. It would be interesting to add Events to the system, so that partners can create an Event for a specific date, with a specific number of seats, and clients could see and choose from the list of events available. Also, clients could be able to select the seat number
from the available seats.


4. Requirements
---------------

To install the Ticketz webapp, the following is required:
- Computer with an OS (windows/unix/linux) capable of running java
- Sun Java JRE 1.6 or higher installed
- Apache Tomcat 6.0 or higher installed
     

5. Skype Web developer test assignment
--------------------------------------

Web development - “Ticket selling service” Implement a server based ticket selling solution. Tickets are stored in central server and accessed by clients over public internet. Client applications are installed on our partner’s kiosks (or internet sites). Each partner can have multiple client installations.

### Client functionality
- User enters the number of tickets he/she wants to buy 
- System presents user with available seat numbers 
- User can accept the seats by entering his/her name and confirming 
- If the user does not like the seats provided he/she can ask for new set of seat numbers.

### Server functionality 
- Incoming requests have to come from our partners only 
- Theater has seats from 0 to 60 
- Only one person per seat :) 
- The tickets are very popular so prepare for concurrent requests.

### Example communication: 
* Customer: give me 3 tickets 
* System: places 1,2,3, OK? 
* Customer: No, give me other 3 
* System: places 4, 5, 6, OK? 
* Customer: Yes, I take them, my name is “John Doe” 
* System: OK, places 4, 5, 6 booked by “John Doe”

### Requirements 
* Server is standalone Java application or Java web application (runs on Tomcat, Jetty, Netty, ...) 
* Embedded or standalone SQL database (Hypersonic SQL, Derby, MySQL, PostgreSQL, …) 
* Optionally you may use Java Content Repository implementation (Jackrabbit) instead of SQL. 
* All components and frameworks used are generally available and open source

### Deliverables 
ZIP file containing the following: 
* README - overview of the system and solutions used, things to improve,  environment requirements
* server/ 
  * INSTALL - step-by-step setup guide for the ticket server application and related database 
  * setup_database.sql - data structure and initial data in case of standalone SQL server 
  * server binaries and source files 
* client/ 
  * INSTALL - step-by-step setup guide for the ticket client application and connection to the ticket server 
  * client binaries and source files
 
### Evaluation criterias: 
* System and solution architecture 
* Code style, readability and maintainability 
* Correct functioning, system security 
* Modularity, (unit) testability, loose coupling 
* User experience

### FAQ
**Q: Can client application be simply a web browser**  
A: Can you satisfy all functional requirements with browser only?

**Q: What frameworks should I use?**  
A: Use the right tool for the job. Choose what you feel comfortable with and what is suitable for the task. You may even write your own socket server if you find it's the right thing to do.

**Q: The task does not specify how system should act in situation X**  
A: Use your best judgment and think about the user. Ask for more info if needed.

Good luck!     
