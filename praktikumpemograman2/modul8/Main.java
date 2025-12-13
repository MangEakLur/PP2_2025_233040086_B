/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul8;

import id.ac.unpas.praktikumpemograman2.modul8.controller.PersegiPanjangController;
import id.ac.unpas.praktikumpemograman2.modul8.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.modul8.view.PersegiPanjangView;

/**
 *
 * @author iqbalnurfikri
 */
public class Main {
    public static void main(String[] args) {
        // 1. Instansiasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();
        // 2. Instansiasi View
        PersegiPanjangView view =  new  PersegiPanjangView();
        // 3. Instansiasi Controller
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        // 4. Tampilan View
        view.setVisible(true);
    }
}
