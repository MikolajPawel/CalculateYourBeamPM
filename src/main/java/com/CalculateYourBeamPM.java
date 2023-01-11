package com;

import com.fastening_types.FasteningType;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;


public class CalculateYourBeamPM{
    public JPanel MainPanel;
    private JPanel dataPanel;
    private JPanel resultsCrossSectionPanel;
    private JPanel imagePanel;
    private JButton calculateButton;
    private JLabel dataLabel;
    private JLabel resultsLabel;
    private JLabel resultsCrossSectionLabel;
    private JTextField f1TextField;
    private JLabel f1Label;
    private JLabel f2LabelUnit;
    private JLabel f2Label;
    private JLabel f1LabelUnit;
    private JTextField f2TextField;
    private JLabel abLabel;
    private JLabel abLabelUnit;
    private JTextField abTextField;
    private JLabel bcLabel;
    private JLabel bcLabelUnit;
    private JTextField bcTextField;
    private JLabel f3Label;
    private JLabel f3LabelUnit;
    private JTextField f3TextField;
    private JLabel cdLabel;
    private JLabel cdLabelUnit;
    private JTextField cdTextField;
    private JButton calculateCrossSectionButton;
    private JTextField rayTextField;
    private JTextField raxTextField;
    private JTextField maTextField;
    private JLabel q3Label;
    private JLabel q1LabelUnit;
    private JTextField q1TextField;
    private JTextField f4TextField;
    private JTextField f5TextField;
    private JLabel f4Label;
    private JLabel f4LabelUnit;
    private JLabel f5Label;
    private JLabel f5LabelUnit;
    private JLabel q3LabelUnit;
    private JTextField q3TextField;
    private JLabel q2Label;
    private JLabel q2LabelUnit;
    private JTextField q2TextField;
    private JLabel q1Label;
    private JLabel q4Label;
    private JTextField q4TextField;
    private JLabel q4LabelUnit;
    private JLabel q5Label;
    private JTextField q5TextField;
    private JLabel q5LabelUnit;
    private JLabel deLabel;
    private JTextField deTextField;
    private JLabel deLabelUnit;
    private JLabel efLabel;
    private JTextField efTextField;
    private JLabel efLabelUnit;
    private JTextField rbyTextField;
    private JTextField rbxTextField;
    private JTextField mbTextField;
    private JTextField rcyTextField;
    private JTextField rcxTextField;
    private JTextField mcTextField;
    private JTextField rdyTextField;
    private JTextField rdxTextField;
    private JTextField mdTextField;
    private JTextField reyTextField;
    private JTextField rexTextField;
    private JTextField meTextField;
    private JTextField rfyTextField;
    private JTextField rfxTextField;
    private JTextField mfTextField;
    private JLabel requirementsCalculateLabel;
    private JCheckBox abRequiredCheckBox;
    private JCheckBox cdRequiredCheckBox;
    private JCheckBox bcRequiredCheckBox;
    private JCheckBox deRequiredCheckBox;
    private JCheckBox efRequiredCheckBox;
    private JCheckBox f1RequiredCheckBox;
    private JCheckBox q1RequiredCheckBox;
    private JCheckBox f2RequiredCheckBox;
    private JCheckBox f3RequiredCheckBox;
    private JCheckBox f4RequiredCheckBox;
    private JCheckBox f5RequiredCheckBox;
    private JCheckBox q2RequiredCheckBox;
    private JCheckBox q3RequiredCheckBox;
    private JCheckBox q4RequiredCheckBox;
    private JCheckBox q5RequiredCheckBox;
    private JButton choseFasteningTypeButton;
    private JLabel imageLabel;
    private JButton clearButton;
    private JPanel mainResultsMainPanel;
    private JScrollPane mainResultsScrollPane;
    private JPanel mainResultsPanel;
    private JLabel rayLabel;
    private JLabel raxLabel;
    private JLabel rayLabelUnit;
    private JLabel raxLabelUnit;
    private JLabel maLabel;
    private JLabel maLabelUnit;
    private JLabel rbyLabel;
    private JLabel rbyLabelUnit;
    private JLabel rbxLabel;
    private JLabel rbxLabelUnit;
    private JLabel mbLabel;
    private JLabel mbLabelUnit;
    private JLabel rcyLabel;
    private JLabel rcyLabelUnit;
    private JLabel rcxLabel;
    private JLabel mcLabel;
    private JLabel rcxLabelUnit;
    private JLabel mcLabelUnit;
    private JLabel reyLabel;
    private JLabel rexLabel;
    private JLabel meLabel;
    private JLabel reyLabelUnit;
    private JLabel rexLabelUnit;
    private JLabel meLabelUnit;
    private JLabel rdyLabel;
    private JLabel rdyLabelUnit;
    private JLabel rdxLabel;
    private JLabel rdxLabelUnit;
    private JLabel mdLabel;
    private JLabel mdLabelUnit;
    private JLabel rfyLabel;
    private JLabel rfyLabelUnit;
    private JLabel rfxLabel;
    private JLabel rfxLabelUnit;
    private JLabel mfLabel;
    private JLabel mfLabelUnit;
    private JButton showDiagramsButton;
    private JPanel crossSectionDataPanel;
    private JLabel crossSectionDataLabel;
    private JRadioButton kgRadioButton;
    private JLabel crossSectionCalculateForLabel;
    private JRadioButton wgRadioButton;
    private JLabel iLabel2;
    private JTextField iTextField;
    private JLabel iLabelUnit2;
    private JLabel kgLabel;
    private JTextField kgTextField;
    private JLabel kgLabelUnit;
    private JLabel kgResultLabel;
    private JTextField kgResultTextField;
    private JTextField wgResultTextField;
    private JLabel wgResultLabel;
    private JLabel kgResultLabelUnit;
    private JLabel wgResultLabelUnit;
    private JLabel mgMaxLabel;
    private JLabel mgMaxLabelUnit;
    private JTextField mgMaxTextField;
    private JButton calculateDeflectionButton;
    private JPanel deflectionPanel;
    private JLabel deflectionDataLabel;
    private JLabel deflectionResultsLabel;
    private JLabel iLabel;
    private JLabel iLabelUnit;
    private JLabel ymaxLAbel;
    private JLabel ymaxLabelUnit;
    private JTextField iTextField2;
    private JTextField ymaxTextField;
    private JLabel eLabel;
    private JLabel eLabelUnit;
    private JTextField youngModulusTextField;
    private JLabel emaxLabel;
    private JTextField emaxTextField;
    private JLabel emaxLabelUnit;
    private JRadioButton numericalCalculationCheck;
    private JPanel requirementsPanel;

    public MenuBarWithCustomBgColor menuBar = new MenuBarWithCustomBgColor();
    private JMenu fileMenu = new JMenu();
    private JMenuItem savingToPDFMenu = new JMenuItem();
    private JMenu developerAnalysisMenu = new JMenu();
    private JMenuItem deflectionAccuracyAnalysisAutomatically = new JMenuItem();
    private JMenuItem deflectionTimeAnalysisOption = new JMenuItem();

    FasteningType calculate;
    FasteningVisions visionType = new FasteningVisions(0);
    ChoseFasteningType fasteningChose;
    DeflectionAnalysisAuto deflectionAnalysisAuto;
    DeflectionTimeAnalysis deflectionTimeAnalysis;
    Language lang = new Language();
    OptionPanes optionPanes = new OptionPanes();
    SavingPDF savingPDF = new SavingPDF();
    SavingDeveloper savingDeveloper = new SavingDeveloper();
    JFrame mainFrame = new JFrame("Calculate Your Beam PM");

    public CalculateYourBeamPM() {

        optionPanes.setLanguage(lang);

        fasteningChose = new ChoseFasteningType(loadImages());

        deflectionAnalysisAuto = new DeflectionAnalysisAuto(optionPanes);
        deflectionTimeAnalysis = new DeflectionTimeAnalysis(optionPanes);

        mainResultsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainResultsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        restrainInvalidInputInTextFields();

        setMenuBar();
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setContentPane(MainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setResizable(false);

        calculate = LoadFasteningType.calculate(visionType.type, getValues(), optionPanes);

        createVisionForTypeOfFastening();

        setLanguage();

        calculateButton.addActionListener(e -> swingWorker("NormalCalculation"));

        savingToPDFMenu.addActionListener(e-> swingWorker("Saving"));

        choseFasteningTypeButton.addActionListener(e -> {
            fasteningChose.showFrame();
            mainFrame.setEnabled(false);
        });

        clearButton.addActionListener(e -> {
            if(optionPanes.askYesNoUser(optionPanes.CLEAR_QUESTION) == 0){
                createVisionForTypeOfFastening();
                resetCrossSectionPanel("clear");
            }
        });

        kgRadioButton.addActionListener(e -> resetCrossSectionPanel("kg"));

        wgRadioButton.addActionListener(e -> resetCrossSectionPanel("wg"));

        showDiagramsButton.addActionListener(e -> swingWorker("ShowDiagrams"));

        calculateCrossSectionButton.addActionListener(e -> swingWorker("CrossSection"));

        calculateDeflectionButton.addActionListener(e -> swingWorker("Deflection"));

    }

    public void start(){
        mainFrame.setVisible(true);
    }

    public void swingWorker(String method){
        SwingWorker<Void, String> worker = new SwingWorker<>() {
            ProgressFrame progressFrame = null;
            @Override
            protected void done() {
                progressFrame.stopIt();
            }

            @Override
            protected Void doInBackground(){
                mainFrame.setEnabled(false);
                switch (method){
                    case "Deflection" -> {
                        progressFrame = new ProgressFrame(lang.progressFasteningMsg,lang.progressTitle);

                        mainFrame.setVisible(false);

                        String result;
                        if(!numericalCalculationCheck.isSelected()){
                            result = calculate.deflectionCalculation(getDeflectionValues(), calculate.ANALYTICALLY);
                        }else{
                            result = calculate.deflectionCalculation(getDeflectionValues(), calculate.NUMERICALLY);
                        }
                        mainFrame.setVisible(true);
                        if(!result.equals("")){calculate.showDiagrams("y");}
                        ymaxTextField.setText(result);

                    }

                    case "CrossSection" -> {
                        progressFrame = new ProgressFrame(lang.progressFasteningMsg,lang.progressTitle);

                        String result;
                        if(kgRadioButton.isSelected()){
                            result = calculate.crossSectionCalculation("kg", getCSValues());
                            kgResultTextField.setText(result);
                        }else{
                            result = calculate.crossSectionCalculation("wg", getCSValues());
                            wgResultTextField.setText(result);
                        }
                    }

                    case "ShowDiagrams" -> {
                        progressFrame = new ProgressFrame(lang.progressMsgDiagram,lang.progressTitle);

                        calculate.showDiagrams("mgAndT");
                    }

                    case "Saving" -> {
                        progressFrame = new ProgressFrame(lang.savingProgressMsg,lang.progressTitle);

                        savingPDF.saveToPDF(checkIfCanSave(),calculate,visionType.vis,visionType.savingImagePath);
                        if(!savingPDF.savingCheck && !savingPDF.cancelCheck){
                            optionPanes.showWarning(optionPanes.SOMETHING_WENT_WRONG);
                        }else if(savingPDF.savingCheck && !savingPDF.cancelCheck){
                            savingPDF.savingCheck = false;
                        }
                        savingPDF.canProceed = false;
                    }

                    case "NormalCalculation" -> {
                        progressFrame = new ProgressFrame(lang.progressFasteningMsg,lang.progressTitle);

                        calculate = LoadFasteningType.calculate(visionType.type, getValues(), optionPanes);
                        if (visionType.type != 0) {
                            calculate.setLanguage(lang.mgDiagramTitle, lang.tDiagramTitle,
                                    lang.yDiagramTitle, lang.yDiagramTitleNumerical, optionPanes);
                        }
                        showResults(calculate.calculations());
                        resetCrossSectionPanel("clear");
                        iTextField2.setText("");
                        youngModulusTextField.setText("");
                        ymaxTextField.setText("");
                    }

                }

                mainFrame.setEnabled(true);
                return null;
            }
        };

        worker.execute();

    }

    public void refresh(){
        if(fasteningChose.getSelectedChoice() != visionType.type){
            visionType = new FasteningVisions(fasteningChose.getSelectedChoice());
            createVisionForTypeOfFastening();
            resetCrossSectionPanel("clear");
        }
    }

    private DefaultComboBoxModel<Icon> loadImages(){
        DefaultComboBoxModel<Icon> comboBoxModel = new DefaultComboBoxModel<>();
        try{
            comboBoxModel = LoadCBModel.comboBoxModel();
        }catch(Exception ex){
            optionPanes.showWarning(optionPanes.SOMETHING_WENT_WRONG);
            System.exit(1);
        }
        return comboBoxModel;
    }

    private void createVisionForTypeOfFastening(){

        for(int i=0; i<= 14; i++){

            JTextField jc = null;

            switch (i){
                case 0 -> jc = f1TextField;
                case 1 -> jc = f2TextField;
                case 2 -> jc = f3TextField;
                case 3 -> jc = f4TextField;
                case 4 -> jc = f5TextField;
                case 5 -> jc = q1TextField;
                case 6 -> jc = q2TextField;
                case 7 -> jc = q3TextField;
                case 8 -> jc = q4TextField;
                case 9 -> jc = q5TextField;
                case 10 -> jc = abTextField;
                case 11 -> jc = bcTextField;
                case 12 -> jc = cdTextField;
                case 13 -> jc = deTextField;
                case 14 -> jc = efTextField;
            }

            if(visionType.vis[i]){
                jc.setEnabled(true);
                jc.setBackground(new ColorUIResource(250,250,250));
            }
            else{
                jc.setEnabled(false);
                jc.setBackground(new ColorUIResource(33,33,33));
            }
            jc.setText("");

        }

        for(int i=15; i<=32; i++){

            JTextField jc = null;

            switch (i){
                case 15 -> jc = rayTextField;
                case 16 -> jc = raxTextField;
                case 17 -> jc = maTextField;
                case 18 -> jc = rbyTextField;
                case 19 -> jc = rbxTextField;
                case 20 -> jc = mbTextField;
                case 21 -> jc = rcyTextField;
                case 22 -> jc = rcxTextField;
                case 23 -> jc = mcTextField;
                case 24 -> jc = rdyTextField;
                case 25 -> jc = rdxTextField;
                case 26 -> jc = mdTextField;
                case 27 -> jc = reyTextField;
                case 28 -> jc = rexTextField;
                case 29 -> jc = meTextField;
                case 30 -> jc = rfyTextField;
                case 31 -> jc = rfxTextField;
                case 32 -> jc = mfTextField;
            }

            if(visionType.vis[i]){
                jc.setBackground(new ColorUIResource(250,250,250));
            }
            else{
                jc.setBackground(new ColorUIResource(33,33,33));
            }
            jc.setText("");
        }

        mgMaxTextField.setText("");

        for(int i=33; i<=47; i++){

            JCheckBox jc = null;

            switch (i){
                case 33 -> jc = f1RequiredCheckBox;
                case 34 -> jc = f2RequiredCheckBox;
                case 35 -> jc = f3RequiredCheckBox;
                case 36 -> jc = f4RequiredCheckBox;
                case 37 -> jc = f5RequiredCheckBox;
                case 38 -> jc = q1RequiredCheckBox;
                case 39 -> jc = q2RequiredCheckBox;
                case 40 -> jc = q3RequiredCheckBox;
                case 41 -> jc = q4RequiredCheckBox;
                case 42 -> jc = q5RequiredCheckBox;
                case 43 -> jc = abRequiredCheckBox;
                case 44 -> jc = bcRequiredCheckBox;
                case 45 -> jc = cdRequiredCheckBox;
                case 46 -> jc = deRequiredCheckBox;
                case 47 -> jc = efRequiredCheckBox;
            }

            jc.setSelected(visionType.vis[i]);
        }

        iTextField2.setText("");
        youngModulusTextField.setText("");
        ymaxTextField.setText("");

        numericalCalculationCheck.setSelected(false);
        numericalCalculationCheck.setEnabled(visionType.vis[48]);

        calculate.canGoFurther = false;

        try {
            imageLabel.setIcon(new ImageIcon(this.getClass().getResource(visionType.imagePath)));
        } catch (Exception ex) {
            optionPanes.showWarning(optionPanes.SOMETHING_WENT_WRONG);
            System.exit(1);
        }
    }

    private void resetCrossSectionPanel(String typeChosen){
        switch (typeChosen) {
            case "kg" -> {
                kgTextField.setText("");
                emaxTextField.setText("");
                kgResultTextField.setText("");
                wgResultTextField.setText("");
                iTextField.setEnabled(true);
                iTextField.setBackground(new ColorUIResource(255, 255, 255));
                emaxTextField.setEnabled(true);
                emaxTextField.setBackground(new ColorUIResource(255, 255, 255));
                kgTextField.setEnabled(false);
                kgTextField.setBackground(new ColorUIResource(33, 33, 33));
                kgResultTextField.setBackground(new ColorUIResource(255, 255, 255));
                wgResultTextField.setBackground(new ColorUIResource(33, 33, 33));
                kgRadioButton.setSelected(true);
                wgRadioButton.setSelected(false);
            }
            case "wg" -> {
                kgTextField.setText("");
                emaxTextField.setText("");
                kgResultTextField.setText("");
                wgResultTextField.setText("");
                kgTextField.setEnabled(true);
                kgTextField.setBackground(new ColorUIResource(255, 255, 255));
                iTextField.setEnabled(false);
                iTextField.setBackground(new ColorUIResource(33, 33, 33));
                emaxTextField.setEnabled(false);
                emaxTextField.setBackground(new ColorUIResource(33, 33, 33));
                wgResultTextField.setBackground(new ColorUIResource(255, 255, 255));
                kgResultTextField.setBackground(new ColorUIResource(33, 33, 33));
                wgRadioButton.setSelected(true);
                kgRadioButton.setSelected(false);
            }
            case "clear" -> {
                kgTextField.setText("");
                emaxTextField.setText("");
                kgResultTextField.setText("");
                wgResultTextField.setText("");
            }
        }
    }

    private double[] getValues(){
        double[] values = new double[15];

        for(int i=0; i<= 14; i++){

            JTextField jc = null;
            String value;

            switch (i){
                case 0 -> jc = f1TextField;
                case 1 -> jc = f2TextField;
                case 2 -> jc = f3TextField;
                case 3 -> jc = f4TextField;
                case 4 -> jc = f5TextField;
                case 5 -> jc = q1TextField;
                case 6 -> jc = q2TextField;
                case 7 -> jc = q3TextField;
                case 8 -> jc = q4TextField;
                case 9 -> jc = q5TextField;
                case 10 -> jc = abTextField;
                case 11 -> jc = bcTextField;
                case 12 -> jc = cdTextField;
                case 13 -> jc = deTextField;
                case 14 -> jc = efTextField;
            }

            if(visionType.vis[i]){

                value = jc.getText().trim();

                if(!value.equals("") && !value.equals(".") && !value.equals("-") &&
                        !value.equals("-.")){

                    values[i] = Double.parseDouble(value);

                }else {values[i] = 0;}
            }else {values[i] = 0;}

        }
        return values;

    }

    private String getCSValues(){
        double[] db = new double[2];
        String[] values = new String[2];
        if(kgRadioButton.isSelected()){
            values[0] = emaxTextField.getText().trim();
            values[1] = iTextField.getText().trim();
            if(!values[0].equals("") && !values[0].equals(".") &&
                    (!values[1].equals("") && !values[1].equals("."))){
                db[0] = Double.parseDouble(values[0]);
                db[1] = Double.parseDouble(values[1]);
                if(db[0] > 0 && db[1] > 0){
                    return String.valueOf(db[1]/db[0]);
                }else{
                    return "";
                }
            }else{
                return "";
            }

        }else{
            values[0] = kgTextField.getText().trim();
            if(!values[0].equals("") && !values[0].equals(".")){
                db[0] = Double.parseDouble(values[0]);
                if(db[0] > 0){
                    return values[0];
                }else{
                    return "";
                }
            }else{
                return "";
            }
        }

    }

    private String[] getDeflectionValues(){
        double[] db = new double[2];
        String[] value = new String[2];

        value[0] = iTextField2.getText().trim();
        value[1] = youngModulusTextField.getText().trim();

        if((!value[0].equals("") && !value[0].equals(".")) && (!value[1].equals("") && !value[1].equals("."))){
            db[0] = Double.parseDouble(value[0]);
            db[1] = Double.parseDouble(value[1]);
            if (!(db[0] > 0) || !(db[1] > 0)) {
                value[0] = "";
            }
        }else{
            value[0] = "";
        }
        return value;
    }
    private void showResults(String[] results){
        int k = 0;
        for(int i=15; i<=32; i++){

            JTextField jc = null;

            switch (i){
                case 15 -> jc = rayTextField;
                case 16 -> jc = raxTextField;
                case 17 -> jc = maTextField;
                case 18 -> jc = rbyTextField;
                case 19 -> jc = rbxTextField;
                case 20 -> jc = mbTextField;
                case 21 -> jc = rcyTextField;
                case 22 -> jc = rcxTextField;
                case 23 -> jc = mcTextField;
                case 24 -> jc = rdyTextField;
                case 25 -> jc = rdxTextField;
                case 26 -> jc = mdTextField;
                case 27 -> jc = reyTextField;
                case 28 -> jc = rexTextField;
                case 29 -> jc = meTextField;
                case 30 -> jc = rfyTextField;
                case 31 -> jc = rfxTextField;
                case 32 -> jc = mfTextField;
            }

            if(visionType.vis[i]){
                jc.setText(results[k]);
            }
            k++;
        }
        mgMaxTextField.setText(results[18]);
    }

    private void restrainInvalidInputInTextFields(){

        for(int i=0; i<= 9; i++){

            JTextField jc = null;

            switch (i){
                case 0 -> jc = f1TextField;
                case 1 -> jc = f2TextField;
                case 2 -> jc = f3TextField;
                case 3 -> jc = f4TextField;
                case 4 -> jc = f5TextField;
                case 5 -> jc = q1TextField;
                case 6 -> jc = q2TextField;
                case 7 -> jc = q3TextField;
                case 8 -> jc = q4TextField;
                case 9 -> jc = q5TextField;

            }
            jc.addKeyListener(new InputTextField(jc, InputTextField.WITH_NEGATIVE_NUMBERS, null));
        }

        for(int i=0; i<= 7; i++){

            JTextField jc = null;

            switch (i){
                case 0 -> jc = abTextField;
                case 1 -> jc = bcTextField;
                case 2 -> jc = cdTextField;
                case 3 -> jc = deTextField;
                case 4 -> jc = efTextField;
                case 5 -> jc = kgTextField;
                case 6 -> jc = emaxTextField;
                case 7 -> jc = youngModulusTextField;
            }
            jc.addKeyListener(new InputTextField(jc, InputTextField.WITHOUT_NEGATIVE_NUMBERS, null));
        }

        iTextField.addKeyListener(new InputTextField(iTextField, InputTextField.INERTIA, iTextField2));
        iTextField2.addKeyListener(new InputTextField(iTextField2, InputTextField.INERTIA, iTextField));

    }

    private void setLanguage(){
        optionPanes.setLanguage(lang);
        fileMenu.setText(lang.file);
        savingToPDFMenu.setText(lang.saving);
        developerAnalysisMenu.setText(lang.developerAnalysis);
        choseFasteningTypeButton.setText(lang.fasteningType);
        dataLabel.setText(lang.data);
        resultsLabel.setText(lang.results);
        calculateButton.setText(lang.calculate);
        requirementsCalculateLabel.setText(lang.calculationRequirements);
        resultsCrossSectionLabel.setText(lang.resultsCrossSection);
        calculateCrossSectionButton.setText(lang.calculateCrossSection);
        savingPDF.setSavingLanguage(lang.data, lang.results, optionPanes);
        savingDeveloper.setSavingLanguage(optionPanes);
        fasteningChose.setLanguage(lang.fasteningType, lang.accept, lang.cancel);
        deflectionAnalysisAuto.setLanguage(lang.selectRanges,lang.accept, lang.cancel,
                lang.beamNumber, lang.iterationsNumber, lang.progressFasteningMsg, lang.progressTitle);
        deflectionTimeAnalysis.setLanguage(lang.selectRanges,lang.accept, lang.cancel,
                lang.beamNumber, lang.iterationsNumber, lang.progressFasteningMsg, lang.progressTitle);
        clearButton.setText(lang.clear);
        showDiagramsButton.setText(lang.showDiagrams);
        crossSectionDataLabel.setText(lang.crossSectionData);
        crossSectionCalculateForLabel.setText(lang.calculateCrossSectionFor);
        deflectionDataLabel.setText(lang.deflectionData);
        deflectionResultsLabel.setText(lang.deflectionResults);
        calculateDeflectionButton.setText(lang.calculateDeflection);
        numericalCalculationCheck.setText(lang.numericalRadioButton);
        calculate.setLanguage(lang.mgDiagramTitle, lang.tDiagramTitle, lang.yDiagramTitle,
                lang.yDiagramTitleNumerical, optionPanes);
        deflectionAccuracyAnalysisAutomatically.setText(lang.deflectionAnalysis);
        deflectionTimeAnalysisOption.setText(lang.analyseTime);
    }

    private void setMenuBar(){
        fileMenu.setText(lang.file);
        savingToPDFMenu.setText(lang.saving);
        fileMenu.add(savingToPDFMenu);
        menuBar.add(fileMenu);
        JMenu languageMenu = new JMenu("Language");
        JMenu languageMenu2 = new JMenu("Change language to...");
        JMenuItem languagePL = new JMenuItem("Polski");
        JMenuItem languageEN = new JMenuItem("English");
        languageMenu.add(languageMenu2);
        languageMenu2.add(languagePL);
        languageMenu2.add(languageEN);
        menuBar.add(languageMenu);
        developerAnalysisMenu.setText(lang.developerAnalysis);
        developerAnalysisMenu.add(deflectionAccuracyAnalysisAutomatically);
        deflectionAccuracyAnalysisAutomatically.setText(lang.deflectionAnalysis);
        deflectionTimeAnalysisOption.setText(lang.analyseTime);
        developerAnalysisMenu.add(deflectionTimeAnalysisOption);
        menuBar.add(developerAnalysisMenu);
        menuBar.setBackgroundColor(new ColorUIResource(200,200,200));

        languagePL.addActionListener(e -> {
            lang.setPL();
            setLanguage();
        });

        languageEN.addActionListener(e -> {
            lang.setEN();
            setLanguage();
        });

        deflectionAccuracyAnalysisAutomatically.addActionListener(e ->{
            deflectionAnalysisAuto.showFrame();
            mainFrame.setEnabled(false);
            mainFrame.setVisible(false);
        });

        deflectionTimeAnalysisOption.addActionListener(e ->{
            deflectionTimeAnalysis.showFrame();
            mainFrame.setEnabled(false);
            mainFrame.setVisible(false);
        });

    }

    private boolean checkIfCanSave() {
        for (int i=15; i <= 32; i++) {

            JTextField jc = null;

            switch (i) {
                case 15 -> jc = rayTextField;
                case 16 -> jc = raxTextField;
                case 17 -> jc = maTextField;
                case 18 -> jc = rbyTextField;
                case 19 -> jc = rbxTextField;
                case 20 -> jc = mbTextField;
                case 21 -> jc = rcyTextField;
                case 22 -> jc = rcxTextField;
                case 23 -> jc = mcTextField;
                case 24 -> jc = rdyTextField;
                case 25 -> jc = rdxTextField;
                case 26 -> jc = mdTextField;
                case 27 -> jc = reyTextField;
                case 28 -> jc = rexTextField;
                case 29 -> jc = meTextField;
                case 30 -> jc = rfyTextField;
                case 31 -> jc = rfxTextField;
                case 32 -> jc = mfTextField;
            }

            if (visionType.vis[i] && jc.getText().equals("")) {
                return false;
            }
        }
        if(kgRadioButton.isSelected() && kgResultTextField.getText().trim().equals("")){
            return false;
        }
        if(wgRadioButton.isSelected() && wgResultTextField.getText().trim().equals("")){
            return false;
        }
        if(ymaxTextField.getText().trim().equals("")){
            return false;
        }

        return true;
    }


}