package com.myapp.soldier_management;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;
import java.io.File;

import org.apache.commons.dbcp2.BasicDataSource;

// Connection Pool Implementation
class ConnectionPool {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://34.205.43.78:3306/military_db");
        dataSource.setUsername("root");
        dataSource.setPassword("devintern");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new SQLException("Connection Error: " + e.getMessage());
        }
    }
}

// Generic DAO Interface
interface GenericDAO<T> {
    void insert(T entity);
    void update(T entity);
    void delete(int id);
    T getById(int id);
    List<T> getAll();
}

// Soldier Entity Class
class Soldier {
    private int id;
    private String firstName;
    private String lastName;
    private java.util.Date enlistmentDate; 
    
    // Constructor, Getters ve Setters
    public Soldier(int id, String firstName, String lastName, java.util.Date enlistmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enlistmentDate = enlistmentDate;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public java.util.Date getEnlistmentDate() { return enlistmentDate; }
}

// Soldier DAO Implementation
class SoldierDAO implements GenericDAO<Soldier> {
    @Override
    public void insert(Soldier soldier) {
        String query = "INSERT INTO Soldiers (first_name, last_name, enlistment_date) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, soldier.getFirstName());
            stmt.setString(2, soldier.getLastName());
            stmt.setDate(3, new java.sql.Date(soldier.getEnlistmentDate().getTime())); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Soldier soldier) {
        String query = "UPDATE Soldiers SET first_name=?, last_name=?, enlistment_date=? WHERE soldier_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, soldier.getFirstName());
            stmt.setString(2, soldier.getLastName());
            stmt.setDate(3, new java.sql.Date(soldier.getEnlistmentDate().getTime())); 
            stmt.setInt(4, soldier.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Soldiers WHERE soldier_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Soldier getById(int id) {
        String query = "SELECT * FROM Soldiers WHERE soldier_id=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Soldier(
                    rs.getInt("soldier_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("enlistment_date")  
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Soldier> getAll() {
        List<Soldier> soldiers = new ArrayList<>();
        String query = "SELECT * FROM Soldiers";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                soldiers.add(new Soldier(
                    rs.getInt("soldier_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("enlistment_date")  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soldiers;
    }
}

// Main Class to Test DAO
public class Main {
   public static void main(String[] args) {
        
        String xmlFilePath = "C:/Users/Ceren/Desktop/soldier-management/soldier_data.xml";
        String xsdFilePath = "C:/Users/Ceren/Desktop/soldier-management/soldier_schema.xsd";
        
        
        boolean isValid = XMLValidator.validateXML(xmlFilePath, xsdFilePath);

        if (!isValid) {
            System.out.println("Error: XML file does not comply with XSD schema. Database operations were aborted.");
            return;  
        }

        
        SoldierDAO soldierDAO = new SoldierDAO();

        
        Soldier newSoldier = new Soldier(0, "John", "Doe", new java.util.Date());  
        soldierDAO.insert(newSoldier);
        System.out.println("New soldier added successfully.");

        
        List<Soldier> soldiers = soldierDAO.getAll();
        System.out.println("Soldiers in the Database:");
        for (Soldier s : soldiers) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }

        
        if (!soldiers.isEmpty()) {
            Soldier firstSoldier = soldiers.get(0);
            firstSoldier = new Soldier(firstSoldier.getId(), "UpdatedFirstName", "UpdatedLastName", new java.util.Date());
            soldierDAO.update(firstSoldier);
            System.out.println("First soldier successfully updated.");
        }

        
        if (!soldiers.isEmpty()) {
            Soldier firstSoldier = soldiers.get(0);
            soldierDAO.delete(firstSoldier.getId());
            System.out.println("First soldier successfully deleted.");
        }
    }
}
