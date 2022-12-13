package com.fastening_types;

import com.OptionPanes;

public class FasteningType_8 extends FasteningType {

    public FasteningType_8(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRby() {
        rby = ((q1*ab) + f1 - rdy);
        return rby;
    }

    @Override
    double calculateRdy(){
        rdy = (((f1*bc) - f2 - ((q1*ab*ab)/2))/(bc+cd));
        return rdy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = (-((q1*x*x)/2));
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg = (formulaMgAB(x) - f2  + (rby*x2) + ((q1*x2*x2)/2));
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x3 = (x-(ab+bc));
        mg = (formulaMgBC(x) - (f1*x3));
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = (-(q1*x));
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = (rby - (q1*ab));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = (rby - f1 - (q1*ab));
        return t;
    }

    @Override
    double calculateCAB() {
        double a = (ab+bc+cd);
        double b = (bc+cd);
        cAB = ((((q1*ab*ab*ab*ab)/24) - ((q1*a*a*a*a)/24) - ((f2*a*a)/2) + ((rby*b*b*b)/6) + ((q1*b*b*b*b)/24)
                - ((f1*cd*cd*cd)/6))/b);
        return cAB;
    }

    @Override
    double calculateDAB() {
        dAB = ((-((q1*ab*ab*ab*ab)/24)) - (cAB*ab));
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
    double formulaYAB(double x) {
        double y;
        y = ((q1*x*x*x*x)/24);
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x-ab);
        y = (formulaYAB(x) + ((f2*x*x)/2) - ((rby*x2*x2*x2)/6) - ((q1*x2*x2*x2*x2)/24));
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x-(ab+bc));
        y = (formulaYBC(x) + ((f1*x3*x3*x3)/6));
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0 || bc <= 0 || cd <= 0){return false;}
        else{return true;}
    }

    @Override
    public boolean[] isYZero() {
        //                    A     B     C    D     E     F
        return new boolean[]{false,true,false,true,false,false};
    }

    @Override
    public void calculator() {
        calculateRdy();
        calculateRby();
    }

}