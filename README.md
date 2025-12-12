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
Make sure MySQL is running and the hospital_db database with patients table is created.
Update database credentials in HospitalSystem.java if needed:
Java
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
Compile the Java program:
Bash
javac HospitalSystem.java
Run the program:
Bash
java HospitalSystem
Use the menu in the console to add, update, view, or search patient records.
