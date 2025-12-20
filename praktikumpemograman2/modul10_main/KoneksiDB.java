/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul10_main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author iqbalnurfikri
 */
public class KoneksiDB {
    private static Connection mysqlconfig;
    
    public static Connection configDB() {
        if (mysqlconfig == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/kampus_db";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                mysqlconfig = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
            }
        }
        return mysqlconfig;
    }
}
