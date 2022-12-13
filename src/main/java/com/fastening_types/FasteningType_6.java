package com.fastening_types;

import com.OptionPanes;

public class FasteningType_6 extends FasteningType {

    public FasteningType_6(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }


    @Override
    double calculateRay() {
        ray = ((q1*ab) + f1);
        return ray;
    }

    @Override
    double calculateMa(){
        ma = (((q1*ab*ab)/2) + (f1*(ab+bc)) - f2);
        return ma;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ((-ma) + (ray*x) - ((q1*x*x)/2));
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x - ab);
        mg = (formulaMgAB(x) + ((q1*x2*x2)/2));
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x3 = (x - (ab+bc));
        mg = (formulaMgBC(x) - (f1*x3));
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = (ray - (q1*x));
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = (ray - (q1*ab));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = (ray - (q1*ab) - f1);
        return t;
    }

    @Override
    double formulaYAB(double x) {
        double y;
        y = (((ma*x*x)/2) - ((ray*x*x*x)/6) + ((q1*x*x*x*x)/24));
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x - ab);
        y = (formulaYAB(x) - ((q1*x2*x2*x2*x2)/24));
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x - (ab+bc));
        y = (formulaYBC(x) + ((f1*x3*x3*x3)/6));
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0 || bc <= 0 || cd <= 0){return false;}
        else{return true;}
    }

    @Override
    public void calculator() {
        calculateRay();
        calculateMa();
    }

}