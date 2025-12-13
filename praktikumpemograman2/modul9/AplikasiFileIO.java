/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {

    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText, btnAppendText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAppendText = new JButton("Append Text"); // LATIHAN 4
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");

        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event
        btnOpenText.addActionListener(e -> bukaFileTeks());
        btnSaveText.addActionListener(e -> simpanFileTeks());
        btnAppendText.addActionListener(e -> appendFileTeks()); // LATIHAN 4
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());

        // LATIHAN 2 → otomatis baca file saat aplikasi dibuka
        bacaFileOtomatis();
    }

    // ================= LATIHAN 1 =================
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");

                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membuka file");
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file");
            }
        }
    }

    // ================= LATIHAN 4 =================
    private void appendFileTeks() {
        File file = new File("last_notes.txt");

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file, true))) {

            writer.write(textArea.getText());
            writer.newLine();

            JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal append file");
        }
    }

    // ================= LATIHAN 2 =================
    private void bacaFileOtomatis() {
        File file = new File("last_notes.txt");

        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText("");
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            // diam saja sesuai instruksi modul
        }
    }

    // ================= LATIHAN 1 =================
    private void simpanConfigBinary() {
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream("config.bin"))) {

            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);

            JOptionPane.showMessageDialog(this,
                    "Ukuran font disimpan: " + fontSize);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan binary");
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream("config.bin"))) {

            int fontSize = dis.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));

            JOptionPane.showMessageDialog(this,
                    "Font diubah ke ukuran: " + fontSize);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca config");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new AplikasiFileIO().setVisible(true));
    }
}

