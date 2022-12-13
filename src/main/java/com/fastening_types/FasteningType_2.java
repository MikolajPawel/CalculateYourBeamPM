package com.fastening_types;

import com.OptionPanes;

public class FasteningType_2 extends FasteningType {

    public FasteningType_2(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRay() {
        ray = ((15*q1*ab)/36);
        return ray;
    }

    @Override
    double calculateRby() {
        rby = ((q1*ab)/2) - ray;
        return rby;
    }

    @Override
    double calculateMa() {
        ma = ((ray*ab)/3) - ((q1*ab*ab)/18);
        return ma;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ray*x - ma - ((q1*x*x)/3);
        return mg;
    }


    @Override
    double formulaTAB(double x) {
        double t;
        t = ray - ((q1*x)/2);
        return t;
    }

    @Override
    double formulaYAB(double x){
        double y;
        y = (((ma*x*x)/2) - ((ray*x*x*x)/6) + ((q1*x*x*x*x)/36));
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
        calculateMa();
        calculateRby();

    }
}