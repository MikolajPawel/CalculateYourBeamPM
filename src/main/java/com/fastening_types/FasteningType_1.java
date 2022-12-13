package com.fastening_types;

import com.OptionPanes;

public class FasteningType_1 extends FasteningType {

    public FasteningType_1(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRay() {
        ray = ((q1*ab)/2);
        return ray;
    }

    @Override
    double calculateRby() {
        rby = (q1*ab) - ray;
        return rby;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ray*x - ((q1*x*x)/2);
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = ray - q1*x;
        return t;
    }

    @Override
    double calculateCAB() {
        cAB = ((ray*ab*ab)/6) - ((q1*ab*ab*ab)/24);
        return cAB;
    }

    @Override
    double formulaYAB(double x) {
        double y;
        y = ((q1*x*x*x*x)/24) - ((ray*x*x*x)/6);
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0){return false;}
        else{return true;}
    }

    @Override
    public boolean[] isYZero() {
        //                     A     B     C     D     E     F
        return new boolean[]{true,true,false,false,false,false};
    }

    @Override
    public void calculator() {
        calculateRay();
        calculateRby();

    }
}