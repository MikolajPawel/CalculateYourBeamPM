package com.fastening_types;

import com.OptionPanes;

public class FasteningType_9 extends FasteningType {

    public FasteningType_9(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRby() {
        rby = ((q1*bc) + f1 - rey);
        return rby;
    }

    @Override
    double calculateRey(){
        rey = (((f1*(bc+cd)) + ((q1*bc*bc)/2) -f2)/(bc+cd+de));
        return rey;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = (-(f2));
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg = (formulaMgAB(x) + (rby*x2) - ((q1*x2*x2)/2));
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x3 = (x-(ab+bc));
        mg = (formulaMgBC(x) + ((q1*x3*x3)/2));
        return mg;
    }

    @Override
    double formulaMgDE(double x) {
        double mg;
        double x4 = (x-(ab+bc+cd));
        mg = (formulaMgCD(x) - (f1*x4));
        return mg;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        double x2 = (x - ab);
        t = (rby - (q1*x2));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = (rby - (q1*bc));
        return t;
    }

    @Override
    double formulaTDE(double x) {
        double t;
        t = (formulaTCD(x) - f1);
        return t;
    }

    @Override
    double calculateCAB() {
        double a = (ab+bc+cd+de);
        double b = (bc+cd+de);
        double c = (cd+de);
        cAB = ((((f2*ab*ab)/2) - ((f2*a*a)/2) + ((rby*b*b*b)/6) - ((q1*b*b*b*b)/24) + ((q1*c*c*c*c)/24) -
                ((f1*de*de*de)/6))/b);
        return cAB;
    }

    @Override
    double calculateDAB() {
        dAB = ((-(cAB*ab)) - ((f2*ab*ab)/2));
        return dAB;
    }

    @Override
    double calculateDBC() {
        dBC = dAB;
        return dBC;
    }

    @Override
    double calculateDCD() {
        dCD = dAB;
        return dCD;
    }

    @Override
    double calculateDDE() {
        dDE = dAB;
        return dDE;
    }

    @Override
    double calculateCBC() {
        cBC = cAB;
        return cBC;
    }

    @Override
    double calculateCCD() {
        cCD = cAB;
        return cCD;
    }

    @Override
    double calculateCDE() {
        cDE = cAB;
        return cDE;
    }

    @Override
    double formulaYAB(double x) {
        double y;
        y = ((f2*x*x)/2);
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x-ab);
        y = (formulaYAB(x) - ((rby*x2*x2*x2)/6) + ((q1*x2*x2*x2*x2)/24));
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x-(ab+bc));
        y = (formulaYBC(x) - ((q1*x3*x3*x3*x3)/24));
        return y;
    }

    @Override
    double formulaYDE(double x) {
        double y;
        double x4 = (x-(ab+bc+cd));
        y = (formulaYCD(x) + ((f1*x4*x4*x4)/6));
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0 || bc <= 0 || cd <= 0 || de <= 0){return false;}
        else{return true;}
    }

    @Override
    public boolean[] isYZero() {
        //                    A     B     C    D     E     F
        return new boolean[]{false,true,false,false,true,false};
    }

    @Override
    public void calculator() {
        calculateRey();
        calculateRby();
    }

}