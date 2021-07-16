create user springwebappuser@localhost 
	identified by 'springwebpass';

grant select, insert, update, delete, execute
on web_spring_customer_tracker_demo_db.*
to springwebappuser@localhost;

