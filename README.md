# Sample Company Task

For the following task, a application in the selected programming language should be written and managed in a git repository.
The system administrator of our SampleCompany wants to keep track of the computers issued by the company. For this purpose, computer details should be stored in an arbitrary database.
The system administrator needs to store the following elements for each computer: MAC address (required), computer name (required), IP address (required), employee abbreviation (required) and description (optional). 

The employee abbreviation consists of 3 letters. For example Max Mustermann should be mmu.

The system administrator wants to access the data via REST interface. The operations CREATE, READ, UPDATE, DELETE are to be implemented.

The system administrator would like to be notified if 3 or more devices are already assigned to a single user. It is to be assumed that another messaging service already exists to notify the system administrator. This service informs the system administrator team when the following REST endpoint is called: POST https://localhost:8080/api/notify 

The expected body of this REST endpoint is defined as follows:

content_type: application/json

body:
 {
 "level": "warning",
 "employeeAbbreviation": "mmu",
 "message": "some message"
 }
 
The messaging service with this REST endpoint is running in a docker container. The image can be retrieved with docker pull greenbone/exercise-admin-notification. Within the image is a small service listening to
requests on port 8080.

Requirements:

The system administrator wants to be able to add a new computer to an employee

The system administrator wants to be informed when an employee is assigned 3 or more computers.

The system administrator wants to be able to get all assigned computers for an employee

The system administrator wants to be able to remove a computer from an employee

The system administrator wants to be able to assign a computer to another employee
