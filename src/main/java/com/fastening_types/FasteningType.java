package com.fastening_types;

import com.OptionPanes;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.text.DecimalFormat;

public class FasteningType {

    public void setLanguage(String mgDiagramTitle, String tDiagramTitle,
                            String yDiagramTitle, String yDiagramTitleNumerical,
                            OptionPanes optionPanes) {

        this.mgDiagramTitle = mgDiagramTitle;
        this.tDiagramTitle = tDiagramTitle;
        this.yDiagramTitle = yDiagramTitle;
        this.yDiagramTitleNumerical = yDiagramTitleNumerical;
        this.optionPanes = optionPanes;
    }

    OptionPanes optionPanes;

    public String mgDiagramTitle;
    public String tDiagramTitle;
    public String yDiagramTitle;
    public String yDiagramTitleNumerical;

    public boolean yNumerically = false;

    public double[] values;

    public boolean canGoFurther = false;

    int nodes;
    boolean isDefault;

    public FasteningType(double[] values, OptionPanes optionPanes, boolean isDefault) {
        if(isDefault){
            nodes = 2;
        }else {
            nodes = 10000;
        }
        this.isDefault = isDefault;
        this.optionPanes = optionPanes;
        this.values = values;
    }

    public double f1;
    public double f2;
    public double f3;
    public double f4;
    public double f5;

    public double q1;
    public double q2;
    public double q3;
    public double q4;
    public double q5;

    public double ab;
    public double bc;
    public double cd;
    public double de;
    public double ef;

    double x = 0;
    double[] xAB;
    double[] xBC;
    double[] xCD;
    double[] xDE;
    double[] xEF;

    public void setValues(){

        xAB = new double[nodes];
        xBC = new double[nodes];
        xCD = new double[nodes];
        xDE = new double[nodes];
        xEF = new double[nodes];

        for(int i=0; i<=14; i++){
            switch (i){
                case 0 -> this.f1 = values[0];
                case 1 -> this.f2 = values[1];
                case 2 -> this.f3 = values[2];
                case 3 -> this.f4 = values[3];
                case 4 -> this.f5 = values[4];
                case 5 -> this.q1 = values[5];
                case 6 -> this.q2 = values[6];
                case 7 -> this.q3 = values[7];
                case 8 -> this.q4 = values[8];
                case 9 -> this.q5 = values[9];
                case 10 -> {this.ab = values[10]; setX(this.ab/(nodes-1),0); x = this.ab;}
                case 11 -> {this.bc = values[11]; setX(this.bc/(nodes-1),1); x = x + this.bc;}
                case 12 -> {this.cd = values[12]; setX(this.cd/(nodes-1),2); x = x + this.cd;}
                case 13 -> {this.de = values[13]; setX(this.de/(nodes-1),3); x = x + this.de;}
                case 14 -> {this.ef = values[14]; setX(this.ef/(nodes-1),4);x = x + this.ef;}
            }
        }

        mgAB = new double[nodes];
        mgBC = new double[nodes];
        mgCD = new double[nodes];
        mgDE = new double[nodes];
        mgEF = new double[nodes];

        tAB = new double[nodes];
        tBC = new double[nodes];
        tCD = new double[nodes];
        tDE = new double[nodes];
        tEF = new double[nodes];

        yAB = new double[nodes];
        yBC = new double[nodes];
        yCD = new double[nodes];
        yDE = new double[nodes];
        yEF = new double[nodes];

    }

    public double ray;
    public double rax;
    public double ma;

    public double rby;
    public double rbx;
    public double mb;

    public double rcy;
    public double rcx;
    public double mc;

    public double rdy;
    public double rdx;
    public double md;

    public double rey;
    public double rex;
    public double me;

    public double rfy;
    public double rfx;
    public double mf;

    double[] mgAB;
    double[] mgBC;
    double[] mgCD;
    double[] mgDE;
    double[] mgEF;

    double[] tAB;
    double[] tBC;
    double[] tCD;
    double[] tDE;
    double[] tEF;

    double calculateRay(){
        ray = 0;
        return ray;
    }

    double calculateRax(){
        rax = 0;
        return rax;
    }

    double calculateMa(){
        ma = 0;
        return ma;
    }

    double calculateRby(){
        rby = 0;
        return rby;
    }

    double calculateRbx(){
        rbx = 0;
        return rbx;
    }

    double calculateMb(){
        mb = 0;
        return mb;
    }

    double calculateRcy(){
        rcy = 0;
        return rcy;
    }

    double calculateRcx(){
        rcx = 0;
        return rcx;
    }

    double calculateMc(){
        mc = 0;
        return mc;
    }

    double calculateRdy(){
        rdy = 0;
        return rdy;
    }

    double calculateRdx(){
        rdx = 0;
        return rdx;
    }

    double calculateMd(){
        md = 0;
        return md;
    }

    double calculateRey(){
        rey = 0;
        return rey;
    }

    double calculateRex(){
        rex = 0;
        return rex;
    }

    double calculateMe(){
        me = 0;
        return me;
    }

    double calculateRfy(){
        rfy = 0;
        return rfy;
    }

    double calculateRfx(){
        rfx = 0;
        return rfx;
    }

    double calculateMf(){
        mf = 0;
        return mf;
    }

    double formulaMgAB(double x){
        double mg;
        mg = 0*x;
        return mg;
    }

    double formulaMgBC(double x){
        double mg;
        mg = 0*x;
        return mg;
    }

    double formulaMgCD(double x){
        double mg;
        mg = 0*x;
        return mg;
    }

    double formulaMgDE(double x){
        double mg;
        mg = 0*x;
        return mg;
    }

    double formulaMgEF(double x){
        double mg;
        mg = 0*x;
        return mg;
    }

    double formulaTAB(double x){
        double t;
        t = 0*x;
        return t;
    }

    double formulaTBC(double x){
        double t;
        t = 0*x;
        return t;
    }

    double formulaTCD(double x){
        double t;
        t = 0*x;
        return t;
    }

    double formulaTDE(double x){
        double t;
        t = 0*x;
        return t;
    }

    double formulaTEF(double x){
        double t;
        t = 0*x;
        return t;
    }

    public void calculateTOrMgOrDeflection(String sectionAndType){
        switch(sectionAndType){
            case "TAB" ->{
                for(int i=0;i<nodes;i++){
                    tAB[i] = formulaTAB(xAB[i]);
                }
            }
            case "TBC" ->{
                for(int i=0;i<nodes;i++){
                    tBC[i] = formulaTBC(xBC[i]);
                }
            }
            case "TCD" ->{
                for(int i=0;i<nodes;i++){
                    tCD[i] = formulaTCD(xCD[i]);
                }
            }
            case "TDE" ->{
                for(int i=0;i<nodes;i++){
                    tDE[i] = formulaTDE(xDE[i]);
                }
            }
            case "TEF" ->{
                for(int i=0;i<nodes;i++){
                    tEF[i] = formulaTEF(xEF[i]);
                }
            }
            case "MgAB" ->{
                for(int i=0;i<nodes;i++){
                    mgAB[i] = formulaMgAB(xAB[i]);
                }
            }
            case "MgBC" ->{
                for(int i=0;i<nodes;i++){
                    mgBC[i] = formulaMgBC(xBC[i]);
                }
            }
            case "MgCD" ->{
                for(int i=0;i<nodes;i++){
                    mgCD[i] = formulaMgCD(xCD[i]);
                }
            }
            case "MgDE" ->{
                for(int i=0;i<nodes;i++){
                    mgDE[i] = formulaMgDE(xDE[i]);
                }
            }
            case "MgEF" ->{
                for(int i=0;i<nodes;i++){
                    mgEF[i] = formulaMgEF(xEF[i]);
                }
            }
            case "YAB" ->{
                for(int i=0; i<nodes; i++){
                    yAB[i] = -((formulaYAB(xAB[i]) + cAB*xAB[i] + dAB)/ei);
                }
            }
            case "YBC" ->{
                for(int i=0; i<nodes; i++){
                    yBC[i] = -((formulaYBC(xBC[i]) + cBC*xBC[i] + dBC)/ei);
                }
            }
            case "YCD" ->{
                for(int i=0; i<nodes; i++){
                    yCD[i] = -((formulaYCD(xCD[i]) + cCD*xCD[i] + dCD)/ei);
                }
            }
            case "YDE" ->{
                for(int i=0; i<nodes; i++){
                    yDE[i] = -((formulaYDE(xDE[i]) + cDE*xDE[i] + dDE)/ei);
                }
            }
            case "YEF" ->{
                for(int i=0; i<nodes; i++){
                    yEF[i] = -((formulaYEF(xEF[i]) + cEF*xEF[i] + dEF)/ei);
                }
            }
        }

    }

    public void beforeCalculationAssignment(){
        //do something if necessary
    }


    public String[] calculations(){
        String[] results = new String[19];

        beforeCalculationAssignment();
        setValues();

        if(calculationPossibility()){

            calculator();
            mgAndTCalculator();

            DecimalFormat df = new DecimalFormat("#.#");
            df.setMaximumFractionDigits(20);

            results[0] = String.valueOf(df.format(ray));
            results[1] = String.valueOf(df.format(rax));
            results[2] = String.valueOf(df.format(ma));
            results[3] = String.valueOf(df.format(rby));
            results[4] = String.valueOf(df.format(rbx));
            results[5] = String.valueOf(df.format(mb));
            results[6] = String.valueOf(df.format(rcy));
            results[7] = String.valueOf(df.format(rcx));
            results[8] = String.valueOf(df.format(mc));
            results[9] = String.valueOf(df.format(rdy));
            results[10] = String.valueOf(df.format(rdx));
            results[11] = String.valueOf(df.format(md));
            results[12] = String.valueOf(df.format(rey));
            results[13] = String.valueOf(df.format(rex));
            results[14] = String.valueOf(df.format(me));
            results[15] = String.valueOf(df.format(rfy));
            results[16] = String.valueOf(df.format(rfx));
            results[17] = String.valueOf(df.format(mf));

            doDiagrams("mgAndT");
            results[18] = String.valueOf(df.format(mgMax));

            canGoFurther = true;

        }else{
            for(int i = 0; i <= 17; i++){
                results[i] = "";
            }
            if(isDefault){optionPanes.showWarning("fasteningNotChosen");}
            else{optionPanes.showWarning("cantCalculate");}
        }
        return results;
    }

    public void calculator(){
        calculateRay();
        calculateRax();
        calculateMa();

        calculateRby();
        calculateRbx();
        calculateMb();

        calculateRcy();
        calculateRcx();
        calculateMc();

        calculateRdy();
        calculateRdx();
        calculateMd();

        calculateRey();
        calculateRex();
        calculateMe();

        calculateRfy();
        calculateRfx();
        calculateMf();

    }

    public void mgAndTCalculator(){

        calculateTOrMgOrDeflection("MgAB");
        calculateTOrMgOrDeflection("TAB");
        if(this.bc > 0){
            calculateTOrMgOrDeflection("MgBC");
            calculateTOrMgOrDeflection("TBC");
        }
        if(this.cd > 0){
            calculateTOrMgOrDeflection("MgCD");
            calculateTOrMgOrDeflection("TCD");
        }
        if(this.de > 0){
            calculateTOrMgOrDeflection("MgDE");
            calculateTOrMgOrDeflection("TDE");
        }
        if(this.ef > 0){
            calculateTOrMgOrDeflection("MgEF");
            calculateTOrMgOrDeflection("TEF");
        }

    }

    public boolean calculationPossibility(){
        return false;
    }

    public void setX(double dividedX, int cs){
            double[] db = null;
            switch (cs){
                case 0 -> db = xAB;
                case 1 -> db = xBC;
                case 2 -> db = xCD;
                case 3 -> db = xDE;
                case 4 -> db = xEF;
            }

            if(cs != 0){
                db[0] = this.x;
            }else{
                db[0] = 0;
            }

            for (int k=1; k<nodes; k++){
                db[k] = db[k-1] + dividedX;
            }

    }

    public double mgMax;
    public JFreeChart mgChart;
    public JFreeChart tChart;
    public JFreeChart yChart;
    public String kgOrWg;
    public double kgOrWgResult;
    public double kgOrWgValue;
    XYSeries mgSeries = new XYSeries("XYGraph");
    XYSeries tSeries = new XYSeries("XYGraph");
    XYSeries ySeries = new XYSeries("XYGraph");

    public void setXYToDiagram(String option){
        int i = 0;
        if(this.bc > 0){i++;}
        if(this.cd > 0){i++;}
        if(this.de > 0){i++;}
        if(this.ef > 0){i++;}

        if(option.equals("mgAndT")){
            tSeries.clear();
            mgSeries.clear();
            switch (i) {
                case 0 -> {
                    series(tSeries,xAB,tAB,true);
                    series(mgSeries,xAB,mgAB,true);
                }
                case 1 -> {
                    series(tSeries,xAB,tAB,false);
                    series(mgSeries,xAB,mgAB,false);
                    series(tSeries,xBC,tBC,true);
                    series(mgSeries,xBC,mgBC,true);
                }
                case 2 -> {
                    series(tSeries,xAB,tAB,false);
                    series(mgSeries,xAB,mgAB,false);
                    series(tSeries,xBC,tBC,false);
                    series(mgSeries,xBC,mgBC,false);
                    series(tSeries,xCD,tCD,true);
                    series(mgSeries,xCD,mgCD,true);
                }
                case 3 -> {
                    series(tSeries,xAB,tAB,false);
                    series(mgSeries,xAB,mgAB,false);
                    series(tSeries,xBC,tBC,false);
                    series(mgSeries,xBC,mgBC,false);
                    series(tSeries,xCD,tCD,false);
                    series(mgSeries,xCD,mgCD,false);
                    series(tSeries,xDE,tDE,true);
                    series(mgSeries,xDE,mgDE,true);
                }
                case 4 -> {
                    series(tSeries,xAB,tAB,false);
                    series(mgSeries,xAB,mgAB,false);
                    series(tSeries,xBC,tBC,false);
                    series(mgSeries,xBC,mgBC,false);
                    series(tSeries,xCD,tCD,false);
                    series(mgSeries,xCD,mgCD,false);
                    series(tSeries,xDE,tDE,false);
                    series(mgSeries,xDE,mgDE,false);
                    series(tSeries,xEF,tEF,true);
                    series(mgSeries,xEF,mgEF,true);
                }
            }
        }
        if (option.equals("y")){
            ySeries.clear();
            switch (i) {
                case 0 -> {
                    series(ySeries,xAB,yAB,true);
                }
                case 1 -> {
                    series(ySeries,xAB,yAB,false);
                    series(ySeries,xBC,yBC,true);
                }
                case 2 -> {
                    series(ySeries,xAB,yAB,false);
                    series(ySeries,xBC,yBC,false);
                    series(ySeries,xCD,yCD,true);
                }
                case 3 -> {
                    series(ySeries,xAB,yAB,false);
                    series(ySeries,xBC,yBC,false);
                    series(ySeries,xCD,yCD,false);
                    series(ySeries,xDE,yDE,true);
                }
                case 4 -> {
                    series(ySeries,xAB,yAB,false);
                    series(ySeries,xBC,yBC,false);
                    series(ySeries,xCD,yCD,false);
                    series(ySeries,xDE,yDE,false);
                    series(ySeries,xEF,yEF,true);
                }
            }
        }

    }

    public void series(XYSeries series, double[] x, double[] TOrMgOrY, boolean isLast){
        if(!isLast){
            for (int k = 0; k <(nodes-1); k++) {
                series.add(x[k], TOrMgOrY[k]);
                if(!series.equals(ySeries) && (k%(nodes/25) == 0)){series.add(x[k], 0);}
            }
        }else{
            for (int k = 0; k < nodes; k++) {
                series.add(x[k], TOrMgOrY[k]);
                if(!series.equals(ySeries) && (k%(nodes/25) == 0 || k == (nodes-1))){series.add(x[k], 0);}
            }
        }
    }


    public void doDiagrams(String option){
        if(option.equals("mgAndT")){

            setXYToDiagram("mgAndT");

            XYSeriesCollection tDataset = new XYSeriesCollection();
            tDataset.addSeries(tSeries);
            tChart = ChartFactory.createXYLineChart(
                    tDiagramTitle, "x[m]","T[N]",tDataset,
                    PlotOrientation.VERTICAL,false,true,false);

            XYSeriesCollection mgDataset = new XYSeriesCollection();
            mgDataset.addSeries(mgSeries);
            mgChart = ChartFactory.createXYLineChart(
                    mgDiagramTitle, "x[m]","Mg[Nm]",mgDataset,
                    PlotOrientation.VERTICAL,false,true,false);


            mgMax = mgMax();
        }
        if(option.equals("y")){

            setXYToDiagram("y");

            XYSeriesCollection yDataset = new XYSeriesCollection();
            yDataset.addSeries(ySeries);
            yChart = ChartFactory.createXYLineChart(
                    yDiagramTitle, "x[m]","y[m]",yDataset,
                    PlotOrientation.VERTICAL,false,true,false);

        }

    }

    public void changeDiagramLang(String option){
        if(option.equals("mgAndT")){
            tChart.setTitle(tDiagramTitle);
            mgChart.setTitle(mgDiagramTitle);
        }
        if(option.equals("y")){
            if(yNumerically){
                yChart.setTitle(yDiagramTitleNumerical);
            }else{
                yChart.setTitle(yDiagramTitle);
            }
        }
    }

    public void showDiagrams(String option){
        if(option.equals("mgAndT")){
            if(canGoFurther) {
                changeDiagramLang("mgAndT");
                ChartFrame tFrame = new ChartFrame("T", tChart);
                ChartFrame mgFrame = new ChartFrame("Mg", mgChart);
                mgFrame.setSize(500, 400);
                tFrame.setSize(500, 400);
                mgFrame.setVisible(true);
                tFrame.setVisible(true);
            }else {
                optionPanes.showWarning("errorDidNotCalculate");
            }
        }
        if(option.equals("y")){
            changeDiagramLang("y");
            ChartFrame yFrame = new ChartFrame("y", yChart);
            yFrame.setSize(500, 400);
            yFrame.setVisible(true);
        }
    }

    public String crossSectionCalculation(String type, String valueString){
        if(!canGoFurther){
            optionPanes.showWarning("errorDidNotCalculate");
            return "";
        }
        if(valueString.equals("")){
            optionPanes.showWarning("cantCalculate");
            return "";
        }

        double value = Double.parseDouble(valueString);
        kgOrWgValue = value;

        double result;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setMaximumFractionDigits(11);

        if(type.equals("kg")){

            result = ((mgMax/value)/(1000000));
            kgOrWg = "kg";
            kgOrWgResult = result;

            return String.valueOf(df.format(result));
        }
        else{

            value = (value*1000000);
            result = (mgMax/value);
            kgOrWg = "wg";
            kgOrWgResult = result;

            return String.valueOf(df.format(result));
        }

    }

    double mgMax(){
        double[] mg = new double[nodes*5];
        for(int i=0; i<nodes; i++){
            mg[i] = Math.abs(mgAB[i]);
            mg[i+nodes] = Math.abs(mgBC[i]);
            mg[i+(nodes*2)] = Math.abs(mgCD[i]);
            mg[i+(nodes*3)] = Math.abs(mgDE[i]);
            mg[i+(nodes*4)] = Math.abs(mgEF[i]);
        }

        double maxI = mg[0];
        for(int i=1; i<(nodes*5); i++){
            if(mg[i]>maxI){
                maxI = mg[i];
            }
        }

        return maxI;
    }

    public double iZ;
    public double youngModulus;
    double ei;
    public double yMax;

    double[] yAB;
    double[] yBC;
    double[] yCD;
    double[] yDE;
    double[] yEF;

    double cAB;
    double cBC;
    double cCD;
    double cDE;
    double cEF;

    double dAB;
    double dBC;
    double dCD;
    double dDE;
    double dEF;

    double calculateCAB(){
        cAB = 0;
        return cAB;
    }

    double calculateDAB(){
        dAB = 0;
        return dAB;
    }

    double calculateCBC(){
        cBC = 0;
        return cBC;
    }

    double calculateDBC(){
        dBC = 0;
        return dBC;
    }
    double calculateCCD(){
        cCD = 0;
        return cCD;
    }

    double calculateDCD(){
        dCD = 0;
        return dCD;
    }
    double calculateCDE(){
        cDE = 0;
        return cDE;
    }

    double calculateDDE(){
        dDE = 0;
        return dDE;
    }
    double calculateCEF(){
        cEF = 0;
        return cEF;
    }

    double calculateDEF(){
        dEF = 0;
        return dEF;
    }


    double formulaYAB(double x){
        double y;
        y = 0*x;
        return y;
    }

    double formulaYBC(double x){
        double y;
        y = 0*x;
        return y;
    }

    double formulaYCD(double x){
        double y;
        y = 0*x;
        return y;
    }

    double formulaYDE(double x){
        double y;
        y = 0*x;
        return y;
    }

    double formulaYEF(double x){
        double y;
        y = 0*x;
        return y;
    }



    public String deflectionCalculation(String[] valueString, String method){
        if(!canGoFurther){
            optionPanes.showWarning("errorDidNotCalculate");
            return "";
        }
        if(valueString[0].equals("")){
            optionPanes.showWarning("cantCalculate");
            return "";
        }

        iZ = Double.parseDouble(valueString[0]);
        youngModulus = Double.parseDouble(valueString[1]);

        ei = iZ*youngModulus*1000000000;

        double result;
        DecimalFormat df = new DecimalFormat("#.#");
        df.setMaximumFractionDigits(15);

        if(method.equals("Analytically")){yNumerically = false; deflectionCalculator();}
        else if(method.equals("Numerically")){yNumerically = true; deflectionNumericalCalculation();}
        yMax = yMax();
        result = yMax;

        doDiagrams("y");
        showDiagrams("y");

        return String.valueOf(df.format(result));
    }

    public void deflectionCalculator(){

        calculateCAB();
        calculateDAB();
        calculateTOrMgOrDeflection("YAB");
        if(this.bc > 0){
            calculateCBC();
            calculateDBC();
            calculateTOrMgOrDeflection("YBC");
        }
        if(this.cd > 0){
            calculateCCD();
            calculateDCD();
            calculateTOrMgOrDeflection("YCD");
        }
        if(this.de > 0){
            calculateCDE();
            calculateDDE();
            calculateTOrMgOrDeflection("YDE");
        }
        if(this.ef > 0){
            calculateCEF();
            calculateDEF();
            calculateTOrMgOrDeflection("YEF");
        }

    }

    public void deflectionNumericalCalculation(){
        int numberOfSections = 0;
        if(this.bc > 0){numberOfSections++;}
        if(this.cd > 0){numberOfSections++;}
        if(this.de > 0){numberOfSections++;}
        if(this.ef > 0){numberOfSections++;}

        double[] mg;
        double[] y;
        double[] deltaX;
        double errorMinusDelta;
        double error;
        double errorPlusDelta;
        double initYDerivative;
        double deltaYDerivative;

        boolean[] isYZero;

        int nodesYNumerical = 0;

        int startingPoint;

        switch(numberOfSections){
            case 0 -> nodesYNumerical = nodes;
            case 1 -> nodesYNumerical = (nodes*2);
            case 2 -> nodesYNumerical = (nodes*3);
            case 3 -> nodesYNumerical = (nodes*4);
            case 4 -> nodesYNumerical = (nodes*5);

        }

        isYZero = isYZero();
        startingPoint = assignStartingPoint(isYZero);
        mg = assignMgToNumerical(numberOfSections);
        deltaX = assignDeltaX(numberOfSections);

        initYDerivative = 1;


        y = deflectionNumericalCalculator(nodesYNumerical, initYDerivative, deltaX, mg, startingPoint);
        error = checkErrorY(y, isYZero);
        initYDerivative = (error/10000);
        deltaYDerivative = (initYDerivative/10000);


        y = deflectionNumericalCalculator(nodesYNumerical, (initYDerivative + deltaYDerivative),
                deltaX, mg, startingPoint);
        errorPlusDelta = checkErrorY(y, isYZero);

        y = deflectionNumericalCalculator(nodesYNumerical, initYDerivative,
                deltaX, mg, startingPoint);
        error = checkErrorY(y, isYZero);

        y = deflectionNumericalCalculator(nodesYNumerical, (initYDerivative - deltaYDerivative),
                deltaX, mg, startingPoint);
        errorMinusDelta = checkErrorY(y, isYZero);

        boolean isErrorPositive = false;
        boolean isErrorPlusDelta = false;
        boolean stillCalculating = true;

        if(Math.abs(error) > Math.abs(errorMinusDelta)){isErrorPlusDelta = false;}
        else if(Math.abs(error) > Math.abs(errorPlusDelta)){isErrorPlusDelta = true;}

        if(error < 0){isErrorPositive = false;}
        else if(error > 0){isErrorPositive = true;}

        while(stillCalculating){

            if(isErrorPlusDelta){initYDerivative = (initYDerivative + deltaYDerivative);}
            else {initYDerivative = (initYDerivative - deltaYDerivative);}

            y = deflectionNumericalCalculator(nodesYNumerical, initYDerivative, deltaX, mg, startingPoint);
            error = checkErrorY(y, isYZero);

            if(isErrorPositive && error < 0){stillCalculating = false;}
            else if(!isErrorPositive && error > 0){stillCalculating = false;}

        }

        if(!isYZero[0]){
            deflectionNumericalCalculatorOtherSide(y, initYDerivative, deltaX, mg, startingPoint);
        }

        switch(numberOfSections){
            case 0 -> yAB = y;
            case 1 ->{
                for (int i=0; i<nodes; i++){
                    yAB[i] = y[i];
                    yBC[i+nodes] = y[i+nodes];
                }
            }
            case 2 ->{
                for (int i=0; i<nodes; i++){
                    yAB[i] = y[i];
                    yBC[i] = y[i+nodes];
                    yCD[i] = y[i+(nodes*2)];
                }
            }
            case 3 ->{
                for (int i=0; i<nodes; i++){
                    yAB[i] = y[i];
                    yBC[i] = y[i+nodes];
                    yCD[i] = y[i+(nodes*2)];
                    yDE[i] = y[i+(nodes*3)];
                }
            }
            case 4 ->{
                for (int i=0; i<nodes; i++){
                    yAB[i] = y[i];
                    yBC[i] = y[i+nodes];
                    yCD[i] = y[i+(nodes*2)];
                    yDE[i] = y[i+(nodes*3)];
                    yEF[i] = y[i+(nodes*4)];
                }
            }
        }

    }

    public boolean[] isYZero(){
        //                     A     B     C     D     E     F
        return new boolean[]{false,false,false,false,false,false};
    }

    public double[] deflectionNumericalCalculator(int nodes, double initYDerivative,
                                                  double[] deltaX, double[] mg, int startingPoint){

        double[] y = new double[nodes];
        double[] yDerivative = new double[nodes];

        y[startingPoint] = 0;
        yDerivative[startingPoint] = initYDerivative;

        for(int i=(startingPoint+1); i<nodes; i++){
            yDerivative[i] = yDerivative[i-1] + ((deltaX[i-1]/2)*((mg[i]/ei) + (mg[i-1]/ei)));
        }

        for(int i=(startingPoint+1); i<nodes; i++){
            y[i] = y[i-1] + ((deltaX[i-1]/2)*(yDerivative[i] + yDerivative[i-1]));
        }

        return y;
    }

    public void deflectionNumericalCalculatorOtherSide(double[] y, double initYDerivative,
                                                  double[] deltaX, double[] mg, int startingPoint){

        double[] yDerivative = new double[startingPoint+1];

        yDerivative[startingPoint] = (-initYDerivative);

        for(int i=(startingPoint-1); i>=0; i--){
            yDerivative[i] = yDerivative[i+1] + ((deltaX[i+1]/2)*((mg[i]/ei) + (mg[i+1]/ei)));
        }

        for(int i=(startingPoint-1); i>=0; i--){
            y[i] = y[i+1] + ((deltaX[i+1]/2)*(yDerivative[i] + yDerivative[i+1]));
        }

    }

    public int assignStartingPoint(boolean[] isYZero){
        int startingPoint = 0;

        if(isYZero[0]){startingPoint = 0;}
        else if(isYZero[1]){startingPoint = (nodes-1);}
        else if(isYZero[2]){startingPoint = ((nodes*2)-1);}
        else if(isYZero[3]){startingPoint = ((nodes*3)-1);}
        else if(isYZero[4]){startingPoint = ((nodes*4)-1);}

        return startingPoint;
    }




    public double checkErrorY(double[] y, boolean[] isYZero){
        boolean[] isYZero2 = new boolean[6];
        System.arraycopy(isYZero, 0, isYZero2, 0, 6);
        double yAtSupport = 0;
        for (int i=0; i<2; i++){
            if(isYZero2[0]){yAtSupport = y[0]; isYZero2[0] = false;}
            else if (isYZero2[1]){yAtSupport = y[nodes-1]; isYZero2[1] = false;}
            else if(isYZero2[2]){yAtSupport = y[(nodes*2)-1]; isYZero2[2] = false;}
            else if(isYZero2[3]){yAtSupport = y[(nodes*3)-1]; isYZero2[3] = false;}
            else if(isYZero2[4]){yAtSupport = y[(nodes*4)-1]; isYZero2[4] = false;}
            else if(isYZero2[5]){yAtSupport = y[(nodes*5)-1];}
        }

        return yAtSupport;
    }

    public double[] assignDeltaX(int numberOfSections){

        double[] deltaX = new double[nodes*(numberOfSections+1)];

        switch(numberOfSections){
            case 0 -> {
                for (int i=0; i<nodes; i++){
                    deltaX[i] = (this.ab/nodes);
                }
            }
            case 1 ->{
                for (int i=0; i<nodes; i++){
                    deltaX[i] = (this.ab/nodes);
                    deltaX[i+nodes] = (this.bc/nodes);
                }
            }
            case 2 ->{
                for (int i=0; i<nodes; i++){
                    deltaX[i] = (this.ab/nodes);
                    deltaX[i+nodes] = (this.bc/nodes);
                    deltaX[i+(nodes*2)] = (this.cd/nodes);
                }
            }
            case 3 ->{
                for (int i=0; i<nodes; i++){
                    deltaX[i] = (this.ab/nodes);
                    deltaX[i+nodes] = (this.bc/nodes);
                    deltaX[i+(nodes*2)] = (this.cd/nodes);
                    deltaX[i+(nodes*3)] = (this.de/nodes);
                }
            }
            case 4 ->{
                for (int i=0; i<nodes; i++){
                    deltaX[i] = (this.ab/nodes);
                    deltaX[i+nodes] = (this.bc/nodes);
                    deltaX[i+(nodes*2)] = (this.cd/nodes);
                    deltaX[i+(nodes*3)] = (this.de/nodes);
                    deltaX[i+(nodes*4)] = (this.ef/nodes);
                }
            }
        }

        return deltaX;
    }

    public double[] assignMgToNumerical(int numberOfSections){
        double[] mg = new double[nodes*(numberOfSections+1)];
        switch(numberOfSections){
            case 0 -> mg = mgAB;
            case 1 ->{
                for (int i=0; i<nodes; i++){
                    mg[i] = mgAB[i];
                    mg[i+nodes] = mgBC[i];
                }
            }
            case 2 ->{
                for (int i=0; i<nodes; i++){
                    mg[i] = mgAB[i];
                    mg[i+nodes] = mgBC[i];
                    mg[i+(nodes*2)] = mgCD[i];
                }
            }
            case 3 ->{
                for (int i=0; i<nodes; i++){
                    mg[i] = mgAB[i];
                    mg[i+nodes] = mgBC[i];
                    mg[i+(nodes*2)] = mgCD[i];
                    mg[i+(nodes*3)] = mgDE[i];
                }
            }
            case 4 ->{
                for (int i=0; i<nodes; i++){
                    mg[i] = mgAB[i];
                    mg[i+nodes] = mgBC[i];
                    mg[i+(nodes*2)] = mgCD[i];
                    mg[i+(nodes*3)] = mgDE[i];
                    mg[i+(nodes*4)] = mgEF[i];
                }
            }
        }

        return mg;

    }

    double yMax(){
        double[] y = new double[nodes*5];
        for(int i=0; i<nodes; i++){
            y[i] = Math.abs(yAB[i]);
            y[i+nodes] = Math.abs(yBC[i]);
            y[i+(nodes*2)] = Math.abs(yCD[i]);
            y[i+(nodes*3)] = Math.abs(yDE[i]);
            y[i+(nodes*4)] = Math.abs(yEF[i]);
        }

        double maxI = y[0];
        for(int i=1; i<(nodes*5); i++){
            if(y[i]>maxI){
                maxI = y[i];
            }
        }

        return maxI;
    }

}
