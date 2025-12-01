/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul7;

/**
 *
 * @author iqbalnurfikri
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManajemenNilaiSiswaAppTugas extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public ManajemenNilaiSiswaAppTugas() {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabPane = new JTabbedPane();
        tabPane.addTab("Input Data", createInputPanel());
        tabPane.addTab("Daftar Nilai", createTablePanel());

        add(tabPane);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNama = new JLabel("Nama Siswa:");
        JLabel lblNilai = new JLabel("Nilai:");
        JLabel lblMatkul = new JLabel("Mata Kuliah:");

        txtNama = new JTextField();
        txtNilai = new JTextField();

        cmbMatkul = new JComboBox<>(new String[]{
                "Pemrograman I", "Struktur Data", "Basis Data", "Jaringan Komputer"
        });

        JButton btnSimpan = new JButton("Simpan Data");

        // ============================
        // INSTRUKSI 4 — TOMBOL RESET
        // ============================
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> resetInput());

        btnSimpan.addActionListener(e -> prosesSimpan());

        panel.add(lblNama);
        panel.add(txtNama);
        panel.add(lblNilai);
        panel.add(txtNilai);
        panel.add(lblMatkul);
        panel.add(cmbMatkul);
        panel.add(btnSimpan);
        panel.add(btnReset); // INSTRUKSI 4

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{
                "Nama", "Nilai", "Grade", "Mata Kuliah"
        }, 0);

        tableData = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tableData);

        // ============================
        // INSTRUKSI 2 — TOMBOL HAPUS
        // ============================
        JButton btnHapus = new JButton("Hapus");
        btnHapus.addActionListener(e -> hapusData());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnHapus); // INSTRUKSI 2

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = txtNama.getText().trim();

        // ============================================
        // INSTRUKSI 3 — VALIDASI NAMA MINIMAL 3 KARAKTER
        // ============================================
        if (nama.isEmpty() || nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama minimal terdiri dari 3 karakter!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String strNilai = txtNilai.getText().trim();
        int nilai;

        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berada dalam rentang 0–100!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ============================
        // INSTRUKSI 1 — SWITCH CASE GRADE
        // ============================
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9: grade = "A"; break;
            case 8: grade = "B"; break;
            case 7: grade = "C"; break;
            case 6: grade = "D"; break;
            default: grade = "E";
        }

        String matkul = (String) cmbMatkul.getSelectedItem();

        tableModel.addRow(new Object[]{nama, nilai, grade, matkul});
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        resetInput();
    }

    // ============================
    // INSTRUKSI 2 — METHOD HAPUS
    // ============================
    private void hapusData() {
        int selectedRow = tableData.getSelectedRow();

        if (selectedRow > -1) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Pilih data yang ingin dihapus!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // ============================
    // INSTRUKSI 4 — METHOD RESET
    // ============================
    private void resetInput() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}