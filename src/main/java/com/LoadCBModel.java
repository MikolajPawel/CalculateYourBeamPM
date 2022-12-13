package com;

import javax.swing.*;

public abstract class LoadCBModel {

    public static DefaultComboBoxModel<Icon> comboBoxModel(){
        DefaultComboBoxModel<Icon> comboBoxModel = new DefaultComboBoxModel<>();
        String source = null;
        for(int i=0; i<10; i++){
            switch(i){
                case 0 -> source = "/fastening_images/default.png";
                case 1 -> source = "/fastening_images/type_1.png";
                case 2 -> source = "/fastening_images/type_2.png";
                case 3 -> source = "/fastening_images/type_3.png";
                case 4 -> source = "/fastening_images/type_4.png";
                case 5 -> source = "/fastening_images/type_5.png";
                case 6 -> source = "/fastening_images/type_6.png";
                case 7 -> source = "/fastening_images/type_7.png";
                case 8 -> source = "/fastening_images/type_8.png";
                case 9 -> source = "/fastening_images/type_9.png";
            }
            comboBoxModel.addElement(new ImageIcon(LoadCBModel.class.getResource(source)));
        }
        return comboBoxModel;
    }

}
