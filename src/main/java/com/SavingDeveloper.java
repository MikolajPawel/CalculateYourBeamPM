package com;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class SavingDeveloper {

    OptionPanes optionPanes;

    boolean savingCheck;
    boolean cancelCheck;
    boolean canProceed = false;

    public void setSavingLanguage(OptionPanes optionPanes){
        this.optionPanes = optionPanes;
    }

    public void saveToXLSXDeflectionAccuracyAnalysis(OptionPanes optionPanes, List<List<List<String>>> results,
                                                     int beamNumber){

        this.optionPanes = optionPanes;

        try {

            uiManager();

            File savingFile = null;

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter;
            String extension;

            filter = new FileNameExtensionFilter("Excel file","xlsx");
            extension = ".xlsx";

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(filter);

            cancelCheck = false;

            while(!canProceed){
                uiManager();
                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(extension)){
                        savingFile = new File(fileChooser.getSelectedFile() + extension);
                    }
                    else {
                        savingFile = fileChooser.getSelectedFile();
                    }

                    if(savingFile.exists()){
                        if(optionPanes.askYesNoUser("overwriteQuestion") == 0){
                            canProceed = true;
                            uiManager();
                        }else{canProceed = false;}
                    }else{
                        canProceed = true;
                        uiManager();
                    }

                }else {
                    canProceed = true;
                    cancelCheck = true;
                }
            }

            if (!cancelCheck) {

                XSSFWorkbook workbook = new XSSFWorkbook();

                int sheetsNumber = 1;
                if(beamNumber == 0){sheetsNumber = 8;}

                for(int p=0; p<sheetsNumber; p++){

                    List<List<String>> resultAutomatic = results.get(p);

                    int beamNo;
                    if(beamNumber == 0){beamNo = selectedBeam(p);}
                    else{beamNo = beamNumber;}

                    XSSFSheet spreadsheet = workbook.createSheet(" Beam No." + beamNo);

                    XSSFRow row;

                    int iteration = resultAutomatic.size();

                    Map<String, Object[]> accuracyData = new TreeMap<>();

                    accuracyData.put("1", new Object[]{"Iteration", "Mg max[Nm]", "EIz[Nm^2]", "Delta [%]"});

                    int rowCount = 2;

                    for (int i = 0; i < iteration; i++) {

                        Object[] obj;
                        List<String> tempList = new ArrayList<>();

                        tempList.add(String.valueOf(i + 1));
                        tempList.add(resultAutomatic.get(i).get(0));
                        tempList.add(resultAutomatic.get(i).get(1));
                        tempList.add(resultAutomatic.get(i).get(2));

                        obj = tempList.toArray();

                        accuracyData.put(String.valueOf(rowCount), obj);
                        rowCount++;

                    }

                    for (int i = 1; i < rowCount; i++) {

                        row = spreadsheet.createRow(i);
                        Object[] obj = accuracyData.get(String.valueOf(i));

                        for (int k = 0; k < 4; k++) {
                            Cell cell = row.createCell(k);
                            cell.setCellValue((String) obj[k]);
                        }
                    }

                }

                FileOutputStream out = new FileOutputStream(savingFile.getCanonicalFile());

                workbook.write(out);
                out.close();

                savingCheck = true;
                optionPanes.showSavingSuccess(savingFile.getAbsolutePath());

            }

        }catch (Exception ex) {
            savingCheck = false;
            cancelCheck = false;
        }

    }

    public void saveToXLSXDeflectionTimeAnalysis(OptionPanes optionPanes, List<List<String>> wholeTimeData){

        this.optionPanes = optionPanes;

        try {

            uiManager();

            File savingFile = null;

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter;
            String extension;

            filter = new FileNameExtensionFilter("Excel file","xlsx");
            extension = ".xlsx";

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(filter);

            cancelCheck = false;

            while(!canProceed){
                uiManager();
                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(extension)){
                        savingFile = new File(fileChooser.getSelectedFile() + extension);
                    }
                    else {
                        savingFile = fileChooser.getSelectedFile();
                    }

                    if(savingFile.exists()){
                        if(optionPanes.askYesNoUser("overwriteQuestion") == 0){
                            canProceed = true;
                            uiManager();
                        }else{canProceed = false;}
                    }else{
                        canProceed = true;
                        uiManager();
                    }

                }else {
                    canProceed = true;
                    cancelCheck = true;
                }
            }

            if (!cancelCheck) {

                XSSFWorkbook workbook = new XSSFWorkbook();

                XSSFSheet spreadsheet = workbook.createSheet(" Deflection Time Analysis ");

                XSSFRow row;

                int iteration = wholeTimeData.size();

                Map<String, Object[]> timeData = new TreeMap<>();

                timeData.put("1", new Object[]{"Test Id","Mg max [Nm]", "EIz[Nm^2]",
                        "Time Analytical [ms]", "Time Numerical [ms]" });

                int rowCount = 2;

                for (int i = 0; i < iteration; i++) {

                    Object[] obj;
                    List<String> tempList = new ArrayList<>();

                    tempList.add(wholeTimeData.get(i).get(0));
                    tempList.add(wholeTimeData.get(i).get(1));
                    tempList.add(wholeTimeData.get(i).get(2));
                    tempList.add(wholeTimeData.get(i).get(3));
                    tempList.add(wholeTimeData.get(i).get(4));

                    obj = tempList.toArray();

                    timeData.put(String.valueOf(rowCount), obj);
                    rowCount++;

                }

                for (int i = 1; i < rowCount; i++) {

                    row = spreadsheet.createRow(i);
                    Object[] obj = timeData.get(String.valueOf(i));

                    for (int k = 0; k < 5; k++) {
                        Cell cell = row.createCell(k);
                        cell.setCellValue((String) obj[k]);
                    }
                }

                FileOutputStream out = new FileOutputStream(savingFile.getCanonicalFile());

                workbook.write(out);
                out.close();

            }
            savingCheck = true;
            optionPanes.showSavingSuccess(savingFile.getAbsolutePath());


        }catch (Exception ex) {
            savingCheck = false;
            cancelCheck = false;

        }

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

    void uiManager(){
        UIManager.put("Panel.background", new ColorUIResource(250,250,250));
        UIManager.put("OptionPane.background", new ColorUIResource(250,250,250));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(250,250,250));
    }


}
