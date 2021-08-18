# Customer Management Web-app

This project aims to demonstrate commonly used combination of spring and hibernate to store and retrieve data from a database and alow the user to perform _CRUD_(**C**reate, **R**ead, **U**pdate, **D**elete) operations on the data.   

## Setup

In order to run this app, you will need a database with which the app can interact.  
Assuming that you have MySQL installed, i have provided two SQL scripts that will help you get the app running. They are both in the sql-db-scripts folder
+ **create-database-for-web-app.sql** - this script will create the required database and fill it with starter data (you might recognize these names if you are a fan of Friends and/or HIMYM) 
+ **create-user-for-webapp.sql** - this scrip will create the user with a username and password, which the app will use to access the database created from the scrip above, and give that user required permissions. I've kept these permissions to the minimum that will allow the app to run correctly.

After creating the database 
Import the project into IDE.  
**Eclipse JEE**
1) Select _File > Import... > Existing maven project_
2) Right click on the project folder witin eclipse project list on the left hand side and select  
_Maven... > Update project_
3) After that the project will be ready to run on server (assuming that you have a server setup on your machine(I was using Apache Tomcat 9.0 for development) )
4) Right click on the project folder again and select _Run As.. > Run on Server_

### UI

Once the app is running you will see the list of current customers but you can also add new ones, update their information, or delete them as you see fit, using the respective buttons.  
Any changes made through this page will be reflected in the database.


## Thank you!
Thank you for checking out my project,  it's purpose was to demonstrate how a web app can communicate with a database. I hope you've found it informative. :smile:

***All the best,  
Stefan Stefanovic***
