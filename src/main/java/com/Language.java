package com;

public class Language {
    public String file;
    public String saving;
    public String fasteningNotChosen;
    public String cantCalculate;
    public String warning;
    public String somethingWentWrong;
    public String fasteningType;
    public String data;
    public String crossSectionType;
    public String results;
    public String calculate;
    public String calculationRequirements;
    public String resultsCrossSection;
    public String calculateCrossSection;
    public String errorDidNotCalculate;
    public String success;
    public String savingSuccessMsg;
    public String savingProgressMsg;
    public String progressTitle;
    public String accept;
    public String cancel;
    public String clear;
    public String clearQuestion;
    public String yes;
    public String no;
    public String showDiagrams;
    public String crossSectionData;
    public String calculateCrossSectionFor;
    public String mgDiagramTitle;
    public String tDiagramTitle;
    public String progressFasteningMsg;
    public String progressMsgDiagram;
    public String errorNotEverythingIsCalculated;
    public String fileExistQuestion;
    public String deflectionData;
    public String deflectionResults;
    public String calculateDeflection;
    public String yDiagramTitle;
    public String yDiagramTitleNumerical;
    public String numericalRadioButton;
    public String deflectionAnalysis;
    public String deflectionAnalysisCantContinue;
    public String developerAnalysis;
    public String alignPositive;
    public String alignNegative;
    public String deflectionAnalysisManually;
    public String deflectionAnalysisAutomatically;
    public String selectRanges;
    public String beamNumber;
    public String iterationsNumber;
    public String analyseTime;

    public Language() {
        setPL();
    }

    public void setPL(){
        this.file = "Plik...";
        this.saving = "Zapisz do .pdf";
        this.fasteningNotChosen = "Nie wybrano typu zamocowania !!!";
        this.cantCalculate = "Pola danych nie zosta\u0142y wype\u0142nione prawid\u0142owo !!!";
        this.warning = "Ostrze\u017cenie";
        this.somethingWentWrong = """
                            Co\u015b posz\u0142o nie tak...
                            Pobierz program od nowa lub
                            skontaktuj si\u0119 z:
                            pawel.mikolaj2000@gmail.com""";
        this.fasteningType = "WYBIERZ SPOS\u00d3B ZAMOCOWANIA I OBCI\u0104\u017bENIA";
        this.data = "Dane:";
        this.crossSectionType = "Typ przekroju:";
        this.results = "Wyniki:";
        this.calculate = "OBLICZ";
        this.calculationRequirements = "Wymagane do oblicze\u0144:";
        this.resultsCrossSection = "Wyniki przekr\u00f3j:";
        this.calculateCrossSection = "OBLICZ PRZEKR\u00d3J";
        this.errorDidNotCalculate = "Nic nie obliczono...";
        this.success = "Uda\u0142o si\u0119";
        this.savingSuccessMsg = "Pomy\u015blnie zapisano do:\n";
        this.savingProgressMsg = "Zapisuje";
        this.progressTitle = "Pracujemy nad tym";
        this.accept = "AKCEPTUJ";
        this.cancel = "ANULUJ";
        this.clear = "WYCZY\u015a\u0106";
        this.clearQuestion = "Wyczy\u015bci\u0107 pola danych i wynik\u00f3w???";
        this.yes = "TAK";
        this.no = "NIE";
        this.showDiagrams = "POKA\u017b WYKRESY (Mg, T)";
        this.crossSectionData = "Dane przekr\u00f3j:";
        this.calculateCrossSectionFor = "Licz przekr\u00f3j pod:";
        this.mgDiagramTitle = "Wykres moment\u00f3w gn\u0105cych";
        this.tDiagramTitle = "Wykres si\u0142 tn\u0105cych";
        this.progressFasteningMsg = "Obliczam";
        this.progressMsgDiagram = "Rysuje";
        this.errorNotEverythingIsCalculated = "Co\u015b nie zosta\u0142o jeszcze obliczone..." +
                "\nOblicz \u017ceby kontynuowa\u0107...";
        this.fileExistQuestion = "Plik o podanej nazwie ju\u017c istnieje...\nCzy chcesz go nadpisa\u0107?";
        this.deflectionData = "Dane ugi\u0119cie:";
        this.deflectionResults = "Wyniki ugi\u0119cie:";
        this.calculateDeflection = "OBLICZ UGI\u0118CIE";
        this.yDiagramTitle = "Linia ugi\u0119cia belki - analitycznie";
        this.yDiagramTitleNumerical = "Linia ugi\u0119cia belki - numerycznie";
        this.numericalRadioButton = "Numerycznie?";
        this.deflectionAnalysis = "Przeanalizuj dok\u0142adno\u015b\u0107 linii ugi\u0119cia";
        this.deflectionAnalysisCantContinue = "Nie wykonano oblicze\u0144 linii ugi\u0119cia belki obiema metodami!!!";
        this.developerAnalysis = "Analiza Developera";
        this.alignPositive = "Liczba ekstrmum jest taka sama";
        this.alignNegative = "Liczba ekstremum nie jest taka sama - nie mozna" +
                " przeprowadzic analizy automatycznie";
        this.deflectionAnalysisManually = "Dane wprowadzone r\u0119cznie";
        this.deflectionAnalysisAutomatically = "Dane losowe";
        this.selectRanges = "WYBIERZ ZAKRESY ANALIZY";
        this.beamNumber = "Numer analizowanej belki:";
        this.iterationsNumber = "Ilosc iteracji:";
        this.analyseTime = "Czas oblicze\u0144 linii ugi\u0119cia belki";
    }

    public void setEN(){
        this.file = "File...";
        this.saving = "Save to .pdf";
        this.fasteningNotChosen = "Fastening type was not chosen !!!";
        this.cantCalculate = "Data fields have not been filled correctly !!!";
        this.warning = "Warning";
        this.somethingWentWrong = """
                            Something went wrong...
                            Download program again or
                            contact with:
                            pawel.mikolaj2000@gmail.com""";
        this.fasteningType = "CHOSE FASTENING AND LOAD METHOD";
        this.data = "Data:";
        this.crossSectionType = "Cross-section type:";
        this.results = "Results:";
        this.calculate = "CALCULATE";
        this.calculationRequirements = "Required to calculate:";
        this.resultsCrossSection = "Cross-section results:";
        this.calculateCrossSection = "CALCULATE C-S";
        this.errorDidNotCalculate = "Nothing was calculated...";
        this.success = "It worked";
        this.savingSuccessMsg = "Saved successfully to:\n";
        this.savingProgressMsg = "Saving";
        this.progressTitle = "We working on it";
        this.accept = "ACCEPT";
        this.cancel = "CANCEL";
        this.clear = "CLEAR";
        this.clearQuestion = "Clear data and results field???";
        this.yes = "YES";
        this.no = "NO";
        this.showDiagrams = "SHOW DIAGRAMS  (Mg, T)";
        this.crossSectionData = "Cross-section data:";
        this.calculateCrossSectionFor = "Calculate C-S for:";
        this.mgDiagramTitle = "Bending moment diagram";
        this.tDiagramTitle = "Shear force diagram";
        this.progressFasteningMsg = "Calculating";
        this.progressMsgDiagram = "Drawing";
        this.errorNotEverythingIsCalculated = "Something was not calculated...\nCalculate to proceed...";
        this.fileExistQuestion = "File with that name already exist...\nDo you want to overwrite it?";
        this.deflectionData = "Deflection data:";
        this.deflectionResults = "Deflection results:";
        this.calculateDeflection = "CALCULATE DEFLECTION";
        this.yDiagramTitle = "Beam deflection diagram - analytically";
        this.yDiagramTitleNumerical = "Beam deflection diagram - numerically";
        this.numericalRadioButton = "Numerically?";
        this.deflectionAnalysis = "Analyze accuracy of beam deflection";
        this.deflectionAnalysisCantContinue = "Deflection was not calculated with both methods!!!";
        this.developerAnalysis = "Developer Analysis";
        this.alignPositive = "Number of extremes are the same";
        this.alignNegative = "Number of extremes are not the same - automatic analysis is not possible";
        this.deflectionAnalysisManually = "Data parsed manually";
        this.deflectionAnalysisAutomatically = "Random data";
        this.selectRanges = "SELECT ANALYSIS RANGES";
        this.beamNumber = "Analysed beam number:";
        this.iterationsNumber = "Number of iterations:";
        this.analyseTime = "Beam deflection calculation time";
    }
}
