/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul10.controller;

import id.ac.unpas.praktikumpemograman2.modul10_main.KoneksiDB;
import id.ac.unpas.praktikumpemograman2.modul10.model.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author iqbalnurfikri
 */
public class MahasiswaController {

    // Read & Latihan 3: Pencarian
    public List<Mahasiswa> getAllMahasiswa(String keyword) throws SQLException {
        List<Mahasiswa> list = new ArrayList<>();
        Connection conn = KoneksiDB.configDB();
        String sql = keyword.isEmpty() ? "SELECT * FROM mahasiswa" : "SELECT * FROM mahasiswa WHERE nama LIKE ? OR nim LIKE ?";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        if (!keyword.isEmpty()) {
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
        }
        
        ResultSet res = pst.executeQuery();
        while (res.next()) {
            list.add(new Mahasiswa(res.getString("nama"), res.getString("nim"), res.getString("jurusan")));
        }
        return list;
    }

    // Latihan 4: Cek Duplikat NIM
    public boolean cekNIMDuplikat(String nim) throws SQLException {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, nim);
            ResultSet res = pst.executeQuery();
            return res.next() && res.getInt(1) > 0;
        }
    }

    public void simpan(Mahasiswa m) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, m.getNama());
            pst.setString(2, m.getNim());
            pst.setString(3, m.getJurusan());
            pst.execute();
        }
    }

    public void ubah(Mahasiswa m) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, m.getNama());
            pst.setString(2, m.getJurusan());
            pst.setString(3, m.getNim());
            pst.executeUpdate();
        }
    }

    public void hapus(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = KoneksiDB.configDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, nim);
            pst.execute();
        }
    }
}
