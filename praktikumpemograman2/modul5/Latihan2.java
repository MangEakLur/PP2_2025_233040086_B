/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul5;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author iqbalnurfikri
 */
public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Jendela dengan Label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JLabel label =  new JLabel ("Ini adalah JLabel.");
                frame.add(label);
                frame.setVisible(true);
            }
        });
    }
}
