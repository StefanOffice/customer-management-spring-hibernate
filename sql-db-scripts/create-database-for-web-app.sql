CREATE DATABASE  IF NOT EXISTS web_spring_customer_tracker_demo_db;
USE web_spring_customer_tracker_demo_db;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
  id int NOT NULL AUTO_INCREMENT primary key,
  firstName varchar(50) DEFAULT NULL,
  lastName varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL);

INSERT INTO Customer VALUES 
	(1,'Lily','Aldrin','lily.aldrin@email.com'),
	(2,'Marshal','Eriksen','marshal.eriksen@email.com'),
	(3,'Robin','Scherbatsky','robin.scherbatsky@email.com'),
	(4,'Ted','Mosby','ted.mosby@email.com'),
	(5,'Barney','Stinson','barney.stinson@email.com'),
    (6,'Joey','Tribbiani','joey.tribbiani@email.com'),
    (7,'Phoebe','Buffay','phoebe.buffay@email.com'),
    (8,'Ross','Geller','ross.geller@email.com'),
    (9,'Monica','Geller','monica.geller@email.com'),
    (10,'Chandler','Bing','chandler.bing@email.com'),
    (11,'Rachel','Greene','rachel.greene@email.com');