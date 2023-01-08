package com;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class SavingDeveloper {

    OptionPanes optionPanes;

    boolean savingCheck;
    boolean cancelCheck;
    boolean canProceed = false;

    String alignMessagePositive;
    String alignMessageNegative;

    public void setSavingLanguage(OptionPanes optionPanes, String alignPositive, String alignNegative){
        this.optionPanes = optionPanes;
        this.alignMessagePositive = alignPositive;
        this.alignMessageNegative = alignNegative;
    }

    public void saveToPDFManualAnalysis(List<List<String>> results, String savingImagePath, OptionPanes optionPanes,
                                        BufferedImage yChartAna, BufferedImage yChartNum){

        this.optionPanes = optionPanes;

        try {

            uiManager();

            File savingFile = null;

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter;
            String extension;

            filter = new FileNameExtensionFilter("PDF File","pdf");
            extension = ".pdf";

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

                PDDocument doc = new PDDocument();
                PDPage page1 = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
                doc.addPage(page1);

                PDPageContentStream content = new PDPageContentStream(doc, page1);

                InputStream input = getClass().getResourceAsStream(savingImagePath);
                File file = File.createTempFile("tempfile", ".tmp");
                OutputStream out = new FileOutputStream(file);
                int read;
                byte[] bytes = new byte[1024];
                while ((read = input.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.close();

                PDImageXObject img = PDImageXObject.createFromFileByContent(file, doc);
                content.drawImage(img, 0, 550, 550, 225);

                file.deleteOnExit();

                content.beginText();
                content.setFont(PDType1Font.COURIER, 20);
                content.newLineAtOffset(20, 800);
                content.showText("CALCULATE YOUR BEAM");
                content.endText();

                content.beginText();
                content.setFont(PDType1Font.COURIER, 20);
                content.newLineAtOffset(20, 779);
                content.showText("by: pawel.mikolaj2000@gmail.com");
                content.endText();

                int horizontalPosition = 535;

                if (results.get(0).get(1).equals("1")) {

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 14);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText(this.alignMessagePositive);
                    content.endText();

                    horizontalPosition = horizontalPosition - 30;

                    for (int i = 0; i < Integer.parseInt(results.get(0).get(2)); i++) {

                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 14);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText(i + 1 + ". Xa: " + results.get(i + 1).get(0)
                                + " Ya: " + results.get(i + 1).get(1));
                        content.endText();

                        horizontalPosition = horizontalPosition - 15;

                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 14);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("   Xn: " + results.get(i + 1).get(2)
                                + " Yn: " + results.get(i + 1).get(3));
                        content.endText();

                        horizontalPosition = horizontalPosition - 15;

                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 14);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("   Delta[%]: " + results.get(i + 1).get(4));
                        content.endText();

                        horizontalPosition = horizontalPosition - 30;

                    }

                } else {

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 12);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText(alignMessageNegative);
                    content.endText();

                    horizontalPosition = horizontalPosition - 15;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 14);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("A:");
                    content.endText();

                    horizontalPosition = horizontalPosition - 15;

                    for (int i = 0; i < Integer.parseInt(results.get(0).get(2)); i++) {
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 14);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText(i + 1 + ". X: " + results.get(i + 1).get(0) + " Y: "
                                + results.get(i + 1).get(1));
                        content.endText();

                        horizontalPosition = horizontalPosition - 15;

                    }

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 14);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("N:");
                    content.endText();

                    horizontalPosition = horizontalPosition - 15;

                    int secondIteration = Integer.parseInt(results.get(0).get(2));

                    for (int i = 0; i < Integer.parseInt(results.get(0).get(3)); i++) {
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 14);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText(i + 1 + ". X: " + results.get(i + secondIteration + 1).get(0) + " Y: "
                                + results.get(i + secondIteration + 1).get(1));
                        content.endText();

                        horizontalPosition = horizontalPosition - 15;

                    }


                }

                content.close();

                PDPage page2 = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
                doc.addPage(page2);

                PDPageContentStream content2 = new PDPageContentStream(doc, page2);

                PDImageXObject yAna = JPEGFactory.createFromImage(doc, yChartAna, 1f);
                content2.drawImage(yAna, 30, 430);

                PDImageXObject yNum = JPEGFactory.createFromImage(doc, yChartNum, 1f);
                content2.drawImage(yNum, 30, 15);

                content2.close();

                doc.save(savingFile.getCanonicalFile());
                doc.close();

                savingCheck = true;
                optionPanes.showSavingSuccess(savingFile.getAbsolutePath());

            }

        }catch (Exception ex) {
            ex.printStackTrace();
            savingCheck = false;
            cancelCheck = false;
        }

    }

    public void saveToXLSXDeflectionAccuracyAnalysis(OptionPanes optionPanes, List<List<List<List<String>>>> results,
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

                    List<List<List<String>>> resultAutomatic = results.get(p);

                    int beamNo;
                    if(beamNumber == 0){beamNo = selectedBeam(p);}
                    else{beamNo = beamNumber;}

                    XSSFSheet spreadsheet = workbook.createSheet(" Beam No." + beamNo);

                    XSSFRow row;

                    int iteration = resultAutomatic.size();

                    Map<String, Object[]> peaksData = new TreeMap<>();

                    peaksData.put("1", new Object[]{"Iteration", "Xa[m]", "Ya[m]", "Xn[m]", "Yn[m]"});

                    int rowCount = 2;

                    for (int i = 0; i < iteration; i++) {

                        Object[] obj;

                        if (resultAutomatic.get(i).get(0).get(1).equals("1")) {

                            for (int k = 0; k < Integer.parseInt(resultAutomatic.get(i).get(0).get(2)); k++) {

                                List<String> tempList = new ArrayList<>();
                                if (k == 0) {
                                    tempList.add(String.valueOf(i + 1));
                                } else {
                                    tempList.add("");
                                }
                                tempList.add(resultAutomatic.get(i).get(k + 1).get(0));
                                tempList.add(resultAutomatic.get(i).get(k + 1).get(1));
                                tempList.add(resultAutomatic.get(i).get(k + 1).get(2));
                                tempList.add(resultAutomatic.get(i).get(k + 1).get(3));

                                obj = tempList.toArray();

                                peaksData.put(String.valueOf(rowCount), obj);
                                rowCount++;

                            }

                        } else {

                            int secondIteration;
                            if (Integer.parseInt(resultAutomatic.get(i).get(0).get(2))
                                    > Integer.parseInt(resultAutomatic.get(i).get(0).get(3))) {

                                secondIteration = Integer.parseInt(resultAutomatic.get(i).get(0).get(2));

                            } else {
                                secondIteration = Integer.parseInt(resultAutomatic.get(i).get(0).get(3));
                            }

                            for (int k = 0; k < secondIteration; k++) {

                                List<String> tempList = new ArrayList<>();
                                if (k == 0) {
                                    tempList.add(String.valueOf(i + 1));
                                } else {
                                    tempList.add("");
                                }

                                if (Integer.parseInt(resultAutomatic.get(i).get(0).get(2)) >= k + 1) {
                                    tempList.add(resultAutomatic.get(i).get(k + 1).get(0));
                                    tempList.add(resultAutomatic.get(i).get(k + 1).get(1));
                                } else {
                                    tempList.add("");
                                    tempList.add("");
                                }

                                if (Integer.parseInt(resultAutomatic.get(i).get(0).get(3)) >= k + 1) {
                                    tempList.add(resultAutomatic.get(i).
                                            get(k + 1 + Integer.parseInt(resultAutomatic.get(i).get(0).get(2))).get(0));
                                    tempList.add(resultAutomatic.get(i).
                                            get(k + 1 + Integer.parseInt(resultAutomatic.get(i).get(0).get(2))).get(1));
                                } else {
                                    tempList.add("");
                                    tempList.add("");
                                }

                                obj = tempList.toArray();

                                peaksData.put(String.valueOf(rowCount), obj);
                                rowCount++;

                            }
                        }

                    }

                    for (int i = 1; i < rowCount; i++) {

                        row = spreadsheet.createRow(i);
                        Object[] obj = peaksData.get(String.valueOf(i));

                        for (int k = 0; k < 5; k++) {
                            Cell cell = row.createCell(k);
                            cell.setCellValue((String) obj[k]);
                        }
                    }

                }

                FileOutputStream out = new FileOutputStream(savingFile.getCanonicalFile());

                workbook.write(out);
                out.close();

            }
                savingCheck = true;
                optionPanes.showSavingSuccess(savingFile.getAbsolutePath());


        }catch (Exception ex) {
            ex.printStackTrace();
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
