/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul8.controller;

import id.ac.unpas.praktikumpemograman2.modul8.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.modul8.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author iqbalnurfikri
 */
public class PersegiPanjangController {
    // Model dan View  sebagai atribut kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;
    
    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;
        
        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        view.getReset().addActionListener(new ResetListener());
    }
    
    // Latihan 3 //
    class ResetListener implements ActionListener { // Mereset
        @Override
        public void actionPerformed(ActionEvent e) {
                view.resetInput();
        }
    }
    // Inner Class untuk menangani event click tombol
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                // 1. Ambil data dari view
                double p = view.getPanjang();
                double l = view.getLebar();
                
                // 2. Kirim data ke model
                model.setPanjang(p);
                model.setLebar(l);
                
                // latihan 2 
                model.getKel();
                
                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();
                model.hitungkeliling();
                
                // 4. Ambil hasil dari Model  dan  tampilkan kembali di View
                double hasil = model.getLuas();
                double hasilKel = model.getKel();
                view.setHasilKel(hasilKel);
                view.setHasil(hasil);
                
            } catch (NumberFormatException ex){
                // Handle jika user memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }       
        }
    }
}
