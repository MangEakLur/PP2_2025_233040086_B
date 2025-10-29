/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul5;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author iqbalnurfikri
 */
public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                JFrame frame = new JFrame ("Tugas BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new BorderLayout());
                
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                JButton buttonW = new JButton("WEST");
                JButton buttonE = new JButton("EAST");
                JButton buttonC = new JButton("CENTER");
                
                buttonW.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });
                
                buttonE.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });
                
                buttonC.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });
                
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonW, BorderLayout.WEST);
                frame.add(buttonE, BorderLayout.EAST);
                frame.add(buttonC, BorderLayout.CENTER);
                
                frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
                frame.setVisible(true);
            }
        });
    }
}
