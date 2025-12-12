import java.sql.*;
import java.util.*;

public class HospitalSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // change this

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("MySQL Driver Error: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("
===== HOSPITAL PATIENT RECORD SYSTEM =====");
            System.out.println("1. Add Patient Record");
            System.out.println("2. Update Patient Record");
            System.out.println("3. View All Patients");
            System.out.println("4. Search Patient by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: addPatient(sc); break;
                case 2: updatePatient(sc); break;
                case 3: viewAll(); break;
                case 4: searchPatient(sc); break;
                case 5: System.out.println("Exiting... Goodbye!"); return;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addPatient(Scanner sc) {
        try (Connection con = getConnection()) {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt(); sc.nextLine();

            System.out.print("Enter disease: ");
            String disease = sc.nextLine();

            String sql = "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);

            ps.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updatePatient(Scanner sc) {
        try (Connection con = getConnection()) {
            System.out.print("Enter patient ID to update: ");
            int id = sc.nextInt(); sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new age: ");
            int age = sc.nextInt(); sc.nextLine();

            System.out.print("Enter new disease: ");
            String disease = sc.nextLine();

            String sql = "UPDATE patients SET name=?, age=?, disease=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Record updated!");
            else System.out.println("Patient not found!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAll() {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM patients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("
===== ALL PATIENTS =====");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Disease: " + rs.getString("disease")
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchPatient(Scanner sc) {
        try (Connection con = getConnection()) {
            System.out.print("Enter patient ID: ");
            int id = sc.nextInt(); sc.nextLine();

            String sql = "SELECT * FROM patients WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("
===== PATIENT DETAILS =====");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Disease: " + rs.getString("disease"));
            } else {
                System.out.println("No patient found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
