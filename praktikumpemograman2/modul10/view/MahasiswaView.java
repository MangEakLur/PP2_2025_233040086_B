/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul10.view;

import id.ac.unpas.praktikumpemograman2.modul10.controller.MahasiswaController;
import id.ac.unpas.praktikumpemograman2.modul10.model.Mahasiswa;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
/**
 *
 * @author iqbalnurfikri
 */
public class MahasiswaView extends JFrame {
    public JTextField txtNama, txtNIM, txtJurusan, txtCari;
    public JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    public JTable tableMahasiswa;
    public DefaultTableModel model;

    public MahasiswaView() {
        setTitle("Aplikasi CRUD Mahasiswa MVC");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Setup UI
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.add(new JLabel("Nama:")); txtNama = new JTextField(); panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM:")); txtNIM = new JTextField(); panelForm.add(txtNIM);
        panelForm.add(new JLabel("Jurusan:")); txtJurusan = new JTextField(); panelForm.add(txtJurusan);

        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan"); btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus"); btnClear = new JButton("Clear");
        panelTombol.add(btnSimpan); panelTombol.add(btnEdit); panelTombol.add(btnHapus); panelTombol.add(btnClear);

        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtCari = new JTextField(20); btnCari = new JButton("Cari");
        panelCari.add(new JLabel("Cari:")); panelCari.add(txtCari); panelCari.add(btnCari);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.NORTH);
        panelAtas.add(panelTombol, BorderLayout.CENTER);
        panelAtas.add(panelCari, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        tableMahasiswa = new JTable(model);
        add(new JScrollPane(tableMahasiswa), BorderLayout.CENTER);
    }

    public void displayData(List<Mahasiswa> list) {
        model.setRowCount(0);
        int no = 1;
        for (Mahasiswa m : list) {
            model.addRow(new Object[]{no++, m.getNama(), m.getNim(), m.getJurusan()});
        }
    }
}
