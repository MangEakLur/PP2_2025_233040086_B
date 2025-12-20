/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul10_main;

import id.ac.unpas.praktikumpemograman2.modul10.controller.MahasiswaController;
import id.ac.unpas.praktikumpemograman2.modul10.model.Mahasiswa;
import id.ac.unpas.praktikumpemograman2.modul10.view.MahasiswaView;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author iqbalnurfikri
 */
public class Main {
    private MahasiswaView view;
    private MahasiswaController controller;

    public Main() {
        view = new MahasiswaView();
        controller = new MahasiswaController();

        // Load awal
        refreshTable("");

        // Event Simpan (Latihan 2 & 4)
        view.btnSimpan.addActionListener(e -> {
            String nama = view.txtNama.getText().trim();
            String nim = view.txtNIM.getText().trim();
            String jurusan = view.txtJurusan.getText().trim();

            if (nama.isEmpty() || nim.isEmpty() || jurusan.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Data tidak boleh kosong! (Latihan 2)");
                return;
            }

            try {
                if (controller.cekNIMDuplikat(nim)) {
                    JOptionPane.showMessageDialog(view, "NIM sudah ada! (Latihan 4)");
                    return;
                }
                controller.simpan(new Mahasiswa(nama, nim, jurusan));
                refreshTable("");
                kosongkan();
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        // Event Cari (Latihan 3)
        view.btnCari.addActionListener(e -> refreshTable(view.txtCari.getText().trim()));

        // Event Edit
        view.btnEdit.addActionListener(e -> {
            try {
                controller.ubah(new Mahasiswa(view.txtNama.getText(), view.txtNIM.getText(), view.txtJurusan.getText()));
                refreshTable("");
                kosongkan();
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        // Event Hapus
        view.btnHapus.addActionListener(e -> {
            try {
                controller.hapus(view.txtNIM.getText());
                refreshTable("");
                kosongkan();
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        // Event Tabel Click
        view.tableMahasiswa.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = view.tableMahasiswa.getSelectedRow();
                view.txtNama.setText(view.model.getValueAt(row, 1).toString());
                view.txtNIM.setText(view.model.getValueAt(row, 2).toString());
                view.txtJurusan.setText(view.model.getValueAt(row, 3).toString());
                view.txtNIM.setEnabled(false);
            }
        });

        view.btnClear.addActionListener(e -> kosongkan());
        view.setVisible(true);
    }

    private void refreshTable(String kw) {
        try {
            view.displayData(controller.getAllMahasiswa(kw));
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void kosongkan() {
        view.txtNama.setText(""); view.txtNIM.setText(""); view.txtJurusan.setText("");
        view.txtNIM.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
