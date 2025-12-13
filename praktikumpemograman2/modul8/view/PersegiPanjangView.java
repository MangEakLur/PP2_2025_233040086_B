/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul8.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author iqbalnurfikri
 */
public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai Atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel ("-");
    private JButton btnHitung = new JButton("Hitung");
    private JLabel lblHasilKel = new JLabel ("-");
    private JButton btnReset = new JButton("Reset");
            
    public PersegiPanjangView(){
        //Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLayout(new GridLayout(6, 2, 10, 10)); // Grid 6 baris dan 2 kolom, 10 itu jarak elemen
        this.setTitle("MVC Kalkulator");
        
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKel);
        this.add(new JLabel("")); // Spacer Kosong
        this.add(btnHitung); 
        this.add(new JLabel(""));
        this.add(btnReset);
}
    
 // Mengambil  nilai panjang dari TextField
        public double getPanjang() {
            return Double.parseDouble(txtPanjang.getText());
        };
        
        // Mengambil nilai  lebar dari TextField
        public double getLebar() {
            return Double.parseDouble(txtLebar.getText());
        }
        
        // Menampilkan hasil ke label Hasil Luas
        public void setHasil(double hasil) {
            lblHasil.setText(String.valueOf(hasil));
        }
        
        // Menampilkan hasil ke label Hasil Keliling
        public void setHasilKel (double hasilKel) {
            lblHasilKel.setText(String.valueOf(hasilKel));
        }
        
        // Menampilkan pesan error (jika input bukan angka)
        public void tampilkanPesanError(String pesan) {
            JOptionPane.showMessageDialog(this, pesan);
        }
        
        // Mendaftarkan Listener untuk tombol (Controller  yang akan memberikan aksinya)
        public void addHitungListener(ActionListener listener){
            btnHitung.addActionListener(listener);
    }
        // Latihan 3 //
        public void resetInput(){
            txtPanjang.setText("");
            txtLebar.setText("");
            lblHasil.setText("-");
            lblHasilKel.setText("-");    
        }
        
        public JButton getReset(){
            return btnReset;
        }
}