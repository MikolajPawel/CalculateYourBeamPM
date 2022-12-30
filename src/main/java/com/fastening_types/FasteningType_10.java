package com.fastening_types;

import com.OptionPanes;

public class FasteningType_10 extends FasteningType {

    public FasteningType_10(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRay() {
        ray = (q1*bc) + f1 - rfy;
        return ray;
    }

    @Override
    double calculateRfy(){
        rfy = (f1*(ab+bc+cd) - f2 + q1*(bc)*(ab+((bc)/2)))/(ab+bc+cd+de+ef);
        return rfy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ray*x;
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg = formulaMgAB(x) - ((q1*x2*x2)/2);
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x3 = (x-(ab+bc));
        mg = formulaMgBC(x) + ((q1*x3*x3)/2);
        return mg;
    }

    @Override
    double formulaMgDE(double x) {
        double mg;
        double x4 = (x-(ab+bc+cd));
        mg = formulaMgCD(x) - f1*x4;
        return mg;
    }

    @Override
    double formulaMgEF(double x) {
        double mg;
        mg = formulaMgDE(x) - f2;
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = ray;
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = ray - (q1*(x-ab));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = ray - (q1*bc);
        return t;
    }

    @Override
    double formulaTDE(double x) {
        double t;
        t = ray - (q1*bc) - f1;
        return t;
    }

    @Override
    double formulaTEF(double x) {
        double t;
        t = formulaTDE(x);
        return t;
    }

    @Override
    double calculateCAB() {
        double a = (ab+bc+cd+de+ef);
        double b = (bc+cd+de+ef);
        double c = (cd+de+ef);
        double d = (de+ef);
        cAB = (((ray*a*a*a)/6) - ((q1*b*b*b*b)/24) + ((q1*c*c*c*c)/24) - ((f1*d*d*d)/6) - ((f2*ef*ef)/2))/a;
        return cAB;
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
    double calculateCEF() {
        cEF = cAB;
        return cEF;
    }

    @Override
    double formulaYAB(double x) {
        double y;
        y = ((-ray*x*x*x)/6);
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x-ab);
        y = formulaYAB(x) + ((q1*x2*x2*x2*x2)/24);
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x-(ab+bc));
        y = formulaYBC(x) - ((q1*x3*x3*x3*x3)/24);
        return y;
    }

    @Override
    double formulaYDE(double x) {
        double y;
        double x4 = (x-(ab+bc+cd));
        y = formulaYCD(x) + ((f1*x4*x4*x4)/6);
        return y;
    }

    @Override
    double formulaYEF(double x) {
        double y;
        double x5 = (x-(ab+bc+cd+de));
        y = formulaYDE(x) + ((f2*x5*x5)/2);;
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0 || bc <= 0 || cd <= 0 || de <= 0 || ef <= 0){return false;}
        else{return true;}
    }

    @Override
    public boolean[] isYZero() {
        //                    A     B     C    D      E      F
        return new boolean[]{true,false,false,false,false,true};
    }

    @Override
    public void calculator() {
        calculateRfy();
        calculateRay();
    }

}