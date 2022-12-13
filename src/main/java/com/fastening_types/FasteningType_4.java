package com.fastening_types;

import com.OptionPanes;

public class FasteningType_4 extends FasteningType {

    public FasteningType_4(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }


    @Override
    double calculateRay() {
        ray = ((q1*ab)/2);
        return ray;
    }

    @Override
    double calculateRdy(){
        rdy = ((3*q1*ab)/2);
        return rdy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = (-((q1*x*x)/2)) + (ray*x);
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg =  formulaMgAB(x) + ((q1*x2*x2)/2);
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x2 = (x-(2*ab));
        mg = formulaMgBC(x) + ((3*q1*ab*ab)/2) - ((q1*x2*x2)/2);
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = ray - (q1*x);
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = ray - (q1*ab);
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        double x2 = (x-(2*ab));
        t = formulaTBC(x) - (q1*x2);
        return t;
    }

    @Override
    double calculateCAB() {
        cAB = (((q1*ab*ab*ab))/12);
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
    double formulaYAB(double x) {
        double y;
        y = (-((ray*x*x*x)/6)) + ((q1*x*x*x*x)/24);
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x - ab);
        y = formulaYAB(x) - ((q1*x2*x2*x2*x2)/24);
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x2 = (x - (2*ab));
        y = formulaYBC(x) - ((((3*q1*ab*ab)/2)*x2*x2)/2) + ((q1*x2*x2*x2*x2)/24);
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0){return false;}
        else{return true;}
    }

    @Override
    public void beforeCalculationAssignment() {
        this.values[11] = this.values[10];
        this.values[12] = this.values[10];
    }

    @Override
    public boolean[] isYZero() {
        //                     A     B     C     D     E     F
        return new boolean[]{true,false,false,true,false,false};
    }

    @Override
    public void calculator() {
        calculateRay();
        calculateRdy();


    }
}