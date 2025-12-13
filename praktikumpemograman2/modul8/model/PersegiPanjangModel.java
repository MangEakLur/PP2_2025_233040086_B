/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul8.model;

/**
 *
 * @author iqbalnurfikri
 */
public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;
    
    // Menghitung luas (Logika Bisnis)
    public void hitungLuas(){
        this.luas = this.panjang * this.lebar;
    }
    
    public void hitungkeliling(){
        this.keliling = 2 * (this.panjang + this.lebar);
    }
    
    // Getters and setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    public double getLuas(){
        return luas;
    }
    
    public double getKel(){
        return keliling;
    }
} 
