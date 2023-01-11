package com;

import com.fastening_types.FasteningType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DeflectionTimeAnalysis {

    private JPanel panel;
    private JButton acceptButton;
    private JButton cancelButton;
    private JPanel dataPanel;
    private JTextField fMinTextField;
    private JLabel fLabel;
    private JLabel qLabel;
    private JLabel dimensionLabel;
    private JLabel minLabel;
    private JLabel maxLabel;
    private JLabel iZLabel;
    private JLabel eLabel;
    private JTextField fMaxTextField;
    private JTextField qMinTextField;
    private JTextField qMaxTextField;
    private JTextField dimensionMinTextField;
    private JTextField dimensionMaxTextField;
    private JTextField iZMinTextField;
    private JTextField iZMaxTextField;
    private JTextField eMinTextField;
    private JTextField eMaxTextField;
    private JSpinner iterationsSpinner;
    private JLabel iterationsLabel;

    private JFrame frame = new JFrame();
    private double[] ranges = new double[10];
    private String progressFasteningMsg;
    private String progressTitle;

    public DeflectionTimeAnalysis(OptionPanes optionPanes){

        restrainInvalidInputInTextFields();

        iterationsSpinner.setModel(new SpinnerNumberModel(1,1,500,1));
        ((JSpinner.DefaultEditor) iterationsSpinner.getEditor()).getTextField().setEditable(false);

        acceptButton.addActionListener(e ->{
            if(getValuesAndCheck()){proceed(optionPanes);}
            else{optionPanes.showWarning("cantCalculate");}
        });

        cancelButton.addActionListener(e -> {
            frame.dispose();
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

    private void proceed(OptionPanes optionPanes){
        frame.dispose();

        SwingWorker<Void,String> worker = new SwingWorker<>() {
            ProgressFrame progressFrame = null;
            @Override
            protected void done() {
                progressFrame.stopIt();
            }
            @Override
            protected Void doInBackground(){
                progressFrame = new ProgressFrame(progressFasteningMsg,progressTitle);

                List<List<String>> wholeData = new ArrayList<>();

                int testNumber = 1;

                for(int k=0; k<=7; k++){

                    FasteningVisions visionType = new FasteningVisions(selectedBeam(k));
                    FasteningType calculate;

                    for(int i=0; i<(int)iterationsSpinner.getValue(); i++){

                        List<String> data = new ArrayList<>();

                        double[] values = setRandomNumNormalCalc(visionType.vis);
                        calculate = LoadFasteningType.calculate(visionType.type, values, optionPanes);
                        calculate.calculations();

                        String[] deflectionValues = setRandomNumDeflectionCalc();

                        long timeBefore;
                        long timeAfter;

                        timeBefore = System.currentTimeMillis();
                        calculate.deflectionCalculation(deflectionValues, "Analytically");
                        timeAfter = System.currentTimeMillis();

                        long timeAnalytical = (timeAfter - timeBefore);

                        timeBefore = System.currentTimeMillis();
                        calculate.deflectionCalculation(deflectionValues, "Numerically");
                        timeAfter = System.currentTimeMillis();

                        long timeNumerical = (timeAfter - timeBefore);

                        data.add(String.valueOf(testNumber));
                        data.add(String.valueOf(calculate.mgMax));
                        data.add(String.valueOf(calculate.ei));
                        data.add(String.valueOf(timeAnalytical));
                        data.add(String.valueOf(timeNumerical));

                        wholeData.add(data);

                        testNumber++;

                    }
                }

                SavingDeveloper save = new SavingDeveloper();
                save.setSavingLanguage(optionPanes);

                save.saveToXLSXDeflectionTimeAnalysis(optionPanes, wholeData);

                if(!save.savingCheck && !save.cancelCheck){
                    optionPanes.showWarning("somethingWentWrong");
                }

                Main.view.mainFrame.setEnabled(true);
                Main.view.mainFrame.setVisible(true);

                return null;
            }
        };

        worker.execute();
    }

    public void showFrame(){
        frame.setVisible(true);
    }

    public void setLanguage(String frameTxt, String acceptTxt, String cancelTxt,
                            String beamNumber, String iterationsNumber,String progressFasteningMsg,
                            String progressTitle){

        frame.setTitle(frameTxt);
        acceptButton.setText(acceptTxt);
        cancelButton.setText(cancelTxt);
        iterationsLabel.setText(iterationsNumber);
        this.progressFasteningMsg = progressFasteningMsg;
        this.progressTitle = progressTitle;

    }

    private double[] setRandomNumNormalCalc(boolean[] visionTypeVis){
        double[] values = new double[15];
        for(int i=0; i<=4; i++){
            if(visionTypeVis[i]){values[i] = randomNumber(ranges[0],ranges[1]);}
            else {values[i] = 0;}
        }
        for(int i=5; i<=9; i++){
            if(visionTypeVis[i]){values[i] = randomNumber(ranges[2],ranges[3]);}
            else {values[i] = 0;}
        }
        for(int i=10; i<=14; i++){
            if(visionTypeVis[i]){values[i] = randomNumber(ranges[4],ranges[5]);}
            else {values[i] = 0;}
        }

        return values;
    }

    private String[] setRandomNumDeflectionCalc(){
        String[] values = new String[2];
        values[0] = String.valueOf(randomNumber(ranges[6],ranges[7]));
        values[1] = String.valueOf(randomNumber(ranges[8],ranges[9]));

        return values;
    }

    private double randomNumber(double min, double max){
        double randomNum;

        if(min==max){
            randomNum = min;
        }else{
            randomNum = ThreadLocalRandom.current().nextDouble(min, max);
        }

        return randomNum;
    }

    private boolean getValuesAndCheck(){
        String value;

        for(int i=0; i<=9; i++){
            JTextField jc = null;
            switch (i){
                case 0 -> jc = fMinTextField;
                case 1 -> jc = fMaxTextField;
                case 2 -> jc = qMinTextField;
                case 3 -> jc = qMaxTextField;
                case 4 -> jc = dimensionMinTextField;
                case 5 -> jc = dimensionMaxTextField;
                case 6 -> jc = iZMinTextField;
                case 7 -> jc = iZMaxTextField;
                case 8 -> jc = eMinTextField;
                case 9 -> jc = eMaxTextField;
            }

            value = jc.getText().trim();

            if(!value.equals("") && !value.equals(".") && !value.equals("-") &&
                    !value.equals("-.")){

                ranges[i] = Double.parseDouble(value);

                if(i==1 || i==3 || i==5 || i==7 || i==9){
                    if(ranges[i]<ranges[i-1]){return false;}
                }

            }else {return false;}

        }
        return true;
    }

    private int selectedBeam(int comboBoxInt){
        int selectedIndex = 0;
        switch (comboBoxInt){
            case 0 -> selectedIndex = 1;
            case 1 -> selectedIndex = 3;
            case 2 -> selectedIndex = 4;
            case 3 -> selectedIndex = 5;
            case 4 -> selectedIndex = 7;
            case 5 -> selectedIndex = 8;
            case 6 -> selectedIndex = 9;
            case 7 -> selectedIndex = 10;
        }
        return selectedIndex;
    }

    private void restrainInvalidInputInTextFields(){

        for(int i=0; i<=3; i++){

            JTextField jc = null;

            switch (i){
                case 0 -> jc = fMinTextField;
                case 1 -> jc = fMaxTextField;
                case 2 -> jc = qMinTextField;
                case 3 -> jc = qMaxTextField;
            }
            jc.addKeyListener(new InputTextField(jc, "WithNegativeNumbers", null));
        }

        for(int i=0; i<=5; i++){

            JTextField jc = null;

            switch (i){
                case 0 -> jc = eMinTextField;
                case 1 -> jc = eMaxTextField;
                case 2 -> jc = iZMinTextField;
                case 3 -> jc = iZMaxTextField;
                case 4 -> jc = dimensionMinTextField;
                case 5 -> jc = dimensionMaxTextField;
            }
            jc.addKeyListener(new InputTextField(jc, "WithoutNegativeNumbers", null));
        }

    }

}