package com;

import javax.swing.*;

public class ChoseFasteningType{

    private JPanel panel;
    private JComboBox<Icon> fasteningComboBox;
    private JButton acceptButton;
    private JButton cancelButton;

    private JFrame frame = new JFrame();

    private int selectedChoice = 0;

    public ChoseFasteningType(DefaultComboBoxModel<Icon> comboBoxModel){

        fasteningComboBox.setModel(comboBoxModel);
        fasteningComboBox.setMaximumRowCount(3);
        fasteningComboBox.setEditor(new ScrollBarForJComboBox());

        acceptButton.addActionListener(e ->{
            selectedChoice = fasteningComboBox.getSelectedIndex();
            frame.dispose();
            Main.view.refresh();
            Main.view.mainFrame.setEnabled(true);
            Main.view.mainFrame.setVisible(true);
        });

        cancelButton.addActionListener(e -> {
            frame.dispose();
            fasteningComboBox.setSelectedIndex(Main.view.visionType.type);
            Main.view.mainFrame.setEnabled(true);
            Main.view.mainFrame.setVisible(true);
        });

        frame.setVisible(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }

    public void showFrame(){
        frame.setVisible(true);
    }

    public int getSelectedChoice(){
        return selectedChoice;
    }

    public void setLanguage(String frameTxt, String acceptTxt, String cancelTxt){
        frame.setTitle(frameTxt);
        acceptButton.setText(acceptTxt);
        cancelButton.setText(cancelTxt);
    }

}