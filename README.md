Hospital Patient Record System
A simple Java console application to manage patient records in a hospital using MySQL.
Features
Add new patient records
Update existing patient records
View all patients
Search patient by ID
Requirements
Java JDK 8 or above
MySQL database
MySQL Connector/J (JDBC driver)
Database Setup
Create a database named hospital_db:
Sql
CREATE DATABASE hospital_db;
Create a table patients:
Sql
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    disease VARCHAR(100)
);
Update the database credentials in the code:
Java
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
How to Run
Compile the Java program:
Bash
javac HospitalSystem.java
Run the program:
Bash
java HospitalSystem
Follow the on-screen menu to add, update, view, or search patient records.
