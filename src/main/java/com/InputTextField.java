package com;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


public class InputTextField extends KeyAdapter {
    private final JTextField textField;
    private final JTextField secondTextField;
    private String type;

    public InputTextField(JTextField textField, String type, JTextField secondTextField) {
        this.textField = textField;
        this.type = type;
        this.secondTextField = secondTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        String text = textField.getText().trim();
        switch (type){
            case "WithNegativeNumbers" ->{

                if((text.indexOf('.') > -1) && key == '.'){
                    e.consume();
                }
                if(!Character.isDigit(key) && key != '.' && key != '-'){
                    e.consume();
                }
                if((text.indexOf('-') > -1) && key == '-'){
                    try{
                        DecimalFormat df = new DecimalFormat("#.#");
                        df.setMaximumFractionDigits(20);
                        textField.setText(String.valueOf(df.format((Double.parseDouble(text))*(-1))));
                    }catch(Exception ignored){}
                    e.consume();
                }
                if((text.indexOf('-') == -1) && key == '-' && !text.equals("") && !text.equals(".")){
                    DecimalFormat df = new DecimalFormat("#.#");
                    df.setMaximumFractionDigits(20);
                    textField.setText(String.valueOf(df.format((Double.parseDouble(text))*(-1))));
                    e.consume();
                }
                if(text.equals(".") && key == '-'){
                    e.consume();
                }

            }
            case "WithoutNegativeNumbers" ->{

                if((text.indexOf('.') > -1) && key == '.'){
                    e.consume();
                }
                if(!Character.isDigit(key) && key != '.'){
                    e.consume();
                }

            }
            case "Inertia" ->{

                secondTextField.setDocument(textField.getDocument());

                if((text.indexOf('.') > -1) && key == '.'){
                    e.consume();
                }
                if(!Character.isDigit(key) && key != '.'){
                    e.consume();
                }

            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(type.equals("Inertia")){secondTextField.setDocument(textField.getDocument());}
        boolean isAccepted = true;
        String data = null;
        boolean isWholeSelected = true;
        if(!textField.getText().equals("")){
            if(textField.getSelectedText() == null){
                isWholeSelected = false;
            }else{
                if(!textField.getText().equals(textField.getSelectedText())){
                    isWholeSelected = false;
                }
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
            if(!isWholeSelected){
                e.consume();
            }else{
                try {
                    data = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                    data = data.trim();
                    data = data.replace(",",".");
                    Double.parseDouble(data);
                } catch (Exception ex) {
                    isAccepted = false;
                }
                if(!isAccepted){
                    e.consume();
                }else{
                    if((type.equals("WithoutNegativeNumbers") || type.equals("Inertia"))
                            && !(Double.parseDouble(data) > 0)){
                        e.consume();
                    }else{
                        textField.setText(data);
                        e.consume();
                    }

                }
            }

        }

    }




}


