package com;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class OptionPanes {

    String somethingWentWrong;
    String warning;
    String yes;
    String no;
    String fasteningNotChosen;
    String errorDidNotCalculate;
    String mgDiagramTitle;
    String tDiagramTitle;
    String cantCalculate;
    String errorNotEverythingIsCalculated;
    String savingSuccessMsg;
    String success;
    String fileExistQuestion;
    String clearQuestion;
    String clear;

    public final String SOMETHING_WENT_WRONG = "somethingWentWrong";
    public final String FASTENING_NOT_CHOSEN = "fasteningNotChosen";
    public final String DID_NOT_CALCULATE = "errorDidNotCalculate";
    public final String CANT_CALCULATE = "cantCalculate";
    public final String NOT_EVERYTHING_WAS_CALCULATED = "errorNotEverythingIsCalculated";
    public final String CLEAR_QUESTION = "clearQuestion";
    public final String OVERWRITE_QUESTION = "overwriteQuestion";


    public void setLanguage(Language lang){
        this.somethingWentWrong = lang.somethingWentWrong;
        this.warning = lang.warning;
        this.yes = lang.yes;
        this.no = lang.no;
        this.fasteningNotChosen = lang.fasteningNotChosen;
        this.errorDidNotCalculate = lang.errorDidNotCalculate;
        this.mgDiagramTitle = lang.mgDiagramTitle;
        this.tDiagramTitle = lang.tDiagramTitle;
        this.cantCalculate = lang.cantCalculate;
        this.errorNotEverythingIsCalculated = lang.errorNotEverythingIsCalculated;
        this.savingSuccessMsg = lang.savingSuccessMsg;
        this.success = lang.success;
        this.fileExistQuestion = lang.fileExistQuestion;
        this.clear = lang.clear;
        this.clearQuestion = lang.clearQuestion;
    }

    public void showWarning(String type){
        if(type.equals("somethingWentWrong")){showWarningPane(somethingWentWrong);}
        if(type.equals("fasteningNotChosen")){showWarningPane(fasteningNotChosen);}
        if(type.equals("errorDidNotCalculate")){showWarningPane(errorDidNotCalculate);}
        if(type.equals("cantCalculate")){showWarningPane(cantCalculate);}
        if(type.equals("errorNotEverythingIsCalculated")){showWarningPane(errorNotEverythingIsCalculated);}
    }

    public int askYesNoUser(String type){
        int answer = 1;
        if(type.equals("clearQuestion")){
            answer = yesNoOptionPane(clearQuestion,"???");
        }
        if(type.equals("overwriteQuestion")){
            answer = yesNoOptionPane(fileExistQuestion,"???");
        }
        return answer;
    }

    public void showSavingSuccess(String path){
        uiManager("grey");
        try{
            JOptionPane.showMessageDialog(null, savingSuccessMsg + path, success,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(this.getClass().getResource("/other_images/success_icon.png")));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, savingSuccessMsg + path, success,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void showWarningPane(String warningMsg){
        uiManager("grey");
        try{
            JOptionPane.showMessageDialog(null, warningMsg,
                    warning, JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(this.getClass().getResource("/other_images/warning_icon.png")));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, warningMsg,
                    warning, JOptionPane.WARNING_MESSAGE);
        }
    }


    private int yesNoOptionPane(String question, String title){
        int option;
        String[] options = new String[2];
        options[0] = yes;
        options[1] = no;

        uiManager("grey");

        try {
            option = JOptionPane.showOptionDialog(null, question,
                    title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(this.getClass().getResource("/other_images/warning_icon.png")),
                    options, options[0]);
        }catch (Exception ex){
            option = JOptionPane.showOptionDialog(null, question,
                    title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }
        return option;
    }

    void uiManager(String type){
        if(type.equals("grey")){
            UIManager.put("Panel.background", new ColorUIResource(33,33,33));
            UIManager.put("OptionPane.background", new ColorUIResource(33,33,33));
            UIManager.put("OptionPane.messageForeground", new ColorUIResource(250,250,250));
        }
        if(type.equals("white")){
            UIManager.put("Panel.background", new ColorUIResource(250,250,250));
            UIManager.put("OptionPane.background", new ColorUIResource(250,250,250));
            UIManager.put("OptionPane.messageForeground", new ColorUIResource(250,250,250));
        }
    }

}
