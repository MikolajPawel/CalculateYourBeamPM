package com;

import com.fastening_types.FasteningType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

public class SavingPDF {

    String data;
    String results;

    OptionPanes optionPanes;

    public void setSavingLanguage(String data, String results, OptionPanes optionPanes){
        this.data = data;
        this.results = results;
        this.optionPanes = optionPanes;
    }

    boolean savingCheck;
    boolean cancelCheck;
    FasteningType calculation;
    boolean canProceed = false;

    public void saveToPDF(boolean canSave, FasteningType calculation, boolean[] vision, String savingImagePath){

        this.calculation = calculation;

        if(canSave){

            try {

                uiManager();

                File savingFile = null;
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF File","pdf");

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(filter);
                String extension = ".pdf";

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

                    int horizontalPosition = 550;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 14);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText(this.data);
                    content.endText();

                    horizontalPosition = horizontalPosition-15;

                    DecimalFormat df = new DecimalFormat("#.#");
                    df.setMaximumFractionDigits(20);

                    for(int i = 0; i<= 14; i++) {

                        String prefix = null;
                        String unit = null;

                        switch (i) {
                            case 0 -> {prefix = "F1 = ";unit = " N";}
                            case 1 -> {prefix = "F2 = ";unit = " N";}
                            case 2 -> {prefix = "F3 = ";unit = " N";}
                            case 3 -> {prefix = "F4 = ";unit = " N";}
                            case 4 -> {prefix = "F5 = ";unit = " N";}
                            case 5 -> {prefix = "Q1 = ";unit = " Nm";}
                            case 6 -> {prefix = "Q2 = ";unit = " Nm";}
                            case 7 -> {prefix = "Q3 = ";unit = " Nm";}
                            case 8 -> {prefix = "Q4 = ";unit = " Nm";}
                            case 9 -> {prefix = "Q5 = ";unit = " Nm";}
                            case 10 -> {prefix = "L1 = ";unit = " m";}
                            case 11 -> {prefix = "L2 = ";unit = " m";}
                            case 12 -> {prefix = "L3 = ";unit = " m";}
                            case 13 -> {prefix = "L4 = ";unit = " m";}
                            case 14 -> {prefix = "L5 = ";unit = " m";}
                        }

                        if(vision[i]){
                            content.beginText();
                            content.setFont(PDType1Font.COURIER, 11);
                            content.newLineAtOffset(20, horizontalPosition);
                            content.showText(prefix + df.format(getData(i)) + unit);
                            content.endText();

                            horizontalPosition = horizontalPosition-12;
                        }
                    }

                    horizontalPosition = horizontalPosition-12;

                    if(calculation.kgOrWg.equals("kg")){
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 11);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("Wg = " + df.format(calculation.kgOrWgValue) + " m^3");
                        content.endText();
                    }
                    if(calculation.kgOrWg.equals("wg")){
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 11);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("kg = " + df.format(calculation.kgOrWgValue) + " MPa");
                        content.endText();
                    }

                    horizontalPosition = horizontalPosition-12;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 11);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("Iz = " + df.format(calculation.iZ) + " m^4");
                    content.endText();

                    horizontalPosition = horizontalPosition-12;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 11);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("E = " + df.format(calculation.youngModulus) + " GPa");
                    content.endText();

                    horizontalPosition = horizontalPosition-30;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 14);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText(this.results);
                    content.endText();

                    horizontalPosition = horizontalPosition-15;

                    for(int i = 15; i<=32; i++){

                        String prefix = null;
                        String unit = null;

                        switch (i){
                            case 15 -> {prefix = "Ray = "; unit = " N";}
                            case 16 -> {prefix = "Rax = "; unit = " N";}
                            case 17 -> {prefix = "Ma = "; unit = " Nm";}
                            case 18 -> {prefix = "Rby = "; unit = " N";}
                            case 19 -> {prefix = "Rbx = "; unit = " N";}
                            case 20 -> {prefix = "Mb = "; unit = " Nm";}
                            case 21 -> {prefix = "Rcy = "; unit = " N";}
                            case 22 -> {prefix = "Rcx = "; unit = " N";}
                            case 23 -> {prefix = "Mc = "; unit = " Nm";}
                            case 24 -> {prefix = "Rdy = "; unit = " N";}
                            case 25 -> {prefix = "Rdx = "; unit = " N";}
                            case 26 -> {prefix = "Md = "; unit = " Nm";}
                            case 27 -> {prefix = "Rey = "; unit = " N";}
                            case 28 -> {prefix = "Rex = "; unit = " N";}
                            case 29 -> {prefix = "Me = "; unit = " Nm";}
                            case 30 -> {prefix = "Rfy = "; unit = " N";}
                            case 31 -> {prefix = "Rfx = "; unit = " N";}
                            case 32 -> {prefix = "Mf = "; unit = " Nm";}
                        }

                        if(vision[i]){
                            content.beginText();
                            content.setFont(PDType1Font.COURIER, 11);
                            content.newLineAtOffset(20, horizontalPosition);
                            content.showText(prefix + df.format(getResults(i)) + unit);
                            content.endText();

                            horizontalPosition = horizontalPosition-12;
                        }

                    }

                    horizontalPosition = horizontalPosition-12;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 11);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("Mg max = " + df.format(calculation.mgMax) + " Nm");
                    content.endText();

                    horizontalPosition = horizontalPosition-12;

                    if(calculation.kgOrWg.equals("kg")){
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 11);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("kg >= " + df.format(calculation.kgOrWgResult) + " MPa");
                        content.endText();
                    }
                    if(calculation.kgOrWg.equals("wg")){
                        content.beginText();
                        content.setFont(PDType1Font.COURIER, 11);
                        content.newLineAtOffset(20, horizontalPosition);
                        content.showText("Wg >= " + df.format(calculation.kgOrWgResult) + " m^3");
                        content.endText();
                    }

                    horizontalPosition = horizontalPosition-12;

                    content.beginText();
                    content.setFont(PDType1Font.COURIER, 11);
                    content.newLineAtOffset(20, horizontalPosition);
                    content.showText("Ymax = " + df.format(calculation.yMax) + " m");
                    content.endText();

                    content.close();

                    PDPage page2 = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
                    doc.addPage(page2);

                    PDPageContentStream content2 = new PDPageContentStream(doc, page2);

                    calculation.changeDiagramLang("mgAndT");

                    BufferedImage tDiagram = calculation.tChart.createBufferedImage(500, 400);
                    PDImageXObject tChart = JPEGFactory.createFromImage(doc, tDiagram,1f);
                    content2.drawImage(tChart,30,430);

                    BufferedImage mgDiagram = calculation.mgChart.createBufferedImage(500, 400);
                    PDImageXObject mgChart = JPEGFactory.createFromImage(doc, mgDiagram,1f);
                    content2.drawImage(mgChart,30,15);

                    content2.close();

                    PDPage page3 = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
                    doc.addPage(page3);

                    PDPageContentStream content3 = new PDPageContentStream(doc, page3);

                    calculation.changeDiagramLang("y");

                    BufferedImage yDiagram;


                    yDiagram = calculation.yChart.createBufferedImage(500, 400);


                    PDImageXObject yChart = JPEGFactory.createFromImage(doc, yDiagram,1f);
                    content3.drawImage(yChart,30,430);

                    content3.close();

                    doc.save(savingFile.getCanonicalFile());
                    doc.close();

                    savingCheck = true;
                    optionPanes.showSavingSuccess(savingFile.getAbsolutePath());
                }

            }catch (Exception ex) {
                savingCheck = false;
                cancelCheck = false;
            }

        }else{
            optionPanes.showWarning("errorNotEverythingIsCalculated");
            savingCheck = true;
            cancelCheck = false;
        }


    }

    public double getData(int whichOne){
        double data = 0;
        try{
            switch (whichOne){
                case 0 -> data = calculation.f1;
                case 1 -> data = calculation.f2;
                case 2 -> data = calculation.f3;
                case 3 -> data = calculation.f4;
                case 4 -> data = calculation.f5;
                case 5 -> data = calculation.q1;
                case 6 -> data = calculation.q2;
                case 7 -> data = calculation.q3;
                case 8 -> data = calculation.q4;
                case 9 -> data = calculation.q5;
                case 10 -> data = calculation.ab;
                case 11 -> data = calculation.bc;
                case 12 -> data = calculation.cd;
                case 13 -> data = calculation.de;
                case 14 -> data = calculation.ef;
            }
        }catch(Exception ex){
            data = 0;
        }
        return data;
    }

    public double getResults(int whichOne){
        double result = 0;
        switch (whichOne){
            case 15 -> result = calculation.ray;
            case 16 -> result = calculation.rax;
            case 17 -> result = calculation.ma;
            case 18 -> result = calculation.rby;
            case 19 -> result = calculation.rbx;
            case 20 -> result = calculation.mb;
            case 21 -> result = calculation.rcy;
            case 22 -> result = calculation.rcx;
            case 23 -> result = calculation.mc;
            case 24 -> result = calculation.rdy;
            case 25 -> result = calculation.rdx;
            case 26 -> result = calculation.md;
            case 27 -> result = calculation.rey;
            case 28 -> result = calculation.rex;
            case 29 -> result = calculation.me;
            case 30 -> result = calculation.rfy;
            case 31 -> result = calculation.rfx;
            case 32 -> result = calculation.mf;
        }
        return result;
    }

    void uiManager(){
        UIManager.put("Panel.background", new ColorUIResource(250,250,250));
        UIManager.put("OptionPane.background", new ColorUIResource(250,250,250));
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(250,250,250));
    }


}
