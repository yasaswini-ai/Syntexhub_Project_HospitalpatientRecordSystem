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
