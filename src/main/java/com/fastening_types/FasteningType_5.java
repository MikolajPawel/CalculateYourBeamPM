package com.fastening_types;

import com.OptionPanes;

public class FasteningType_5 extends FasteningType {

    public FasteningType_5(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }


    @Override
    double calculateRby() {
        rby = (-rcy) + f1 + (q1*ab);
        return rby;
    }

    @Override
    double calculateRcy(){
        rcy = ((f2 - (ab*q1*(ab/2)))/((3*ab)/2));
        return rcy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = ((-q1*x*x)/2);
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg =  (-q1*ab*(x-(ab/2))) - (f1*x2) + (rby*x2);
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        mg = formulaMgBC(x) + (rcy*(x-((5*ab)/2)));
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = (-q1*x);
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = ((-q1*ab) - f1 + rby);
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = ((-q1*ab) - f1 + rby + rcy);
        return t;
    }

    @Override
    double calculateCAB() {
        double a = (ab/2);
        cAB = (((27*rby*a*a)/18) - ((27*f1*a*a)/18) - ((528*q1*a*a*a)/72));
        return cAB;
    }

    @Override
    double calculateDAB() {
        double a = (ab/2);
        dAB = ((-((((27*rby*a*a)/18) - ((27*f1*a*a)/18) - ((528*q1*a*a*a)/72))*2*a)) - ((16*q1*a*a*a*a)/24) );
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
        double x2 = (x - ab);
        y = (formulaYAB(x) - ((q1*x2*x2*x2*x2)/24) + ((f1*x2*x2*x2)/6) - ((rby*x2*x2*x2)/6));
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x-((5*ab)/2));
        y = (formulaYBC(x) - ((rcy*x3*x3*x3)/6));
        return y;
    }

    @Override
    public boolean calculationPossibility() {
        if(ab <= 0){return false;}
        else{return true;}
    }

    @Override
    public void beforeCalculationAssignment() {
        this.values[10] = (this.values[10]*2);
        this.values[11] = (this.values[10] + (this.values[10]/2));
        this.values[12] = this.values[10];
    }

    @Override
    public boolean[] isYZero() {
        //                     A     B     C    D     E     F
        return new boolean[]{false,true,true,false,false,false};
    }

    @Override
    public void calculator() {
        calculateRcy();
        calculateRby();
    }

}