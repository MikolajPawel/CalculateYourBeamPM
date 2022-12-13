package com.fastening_types;

import com.OptionPanes;

public class FasteningType_7 extends FasteningType {

    public FasteningType_7(double[] values, OptionPanes optionPanes, boolean isDefault) {
        super(values, optionPanes, isDefault);
    }

    @Override
    double calculateRbx() {
        rbx = (f1*0.866025);
        return rbx;
    }

    @Override
    double calculateRby() {
        rby = ((f1/2) + (q1*ab) - rcy);
        return rby;
    }

    @Override
    double calculateRcy(){
        rcy = ((f2 - ((f1*ab)/2) + ((q1*bc*bc)/2))/bc);
        return rcy;
    }

    @Override
    double formulaMgAB(double x) {
        double mg;
        mg = -((f1*x)/2);
        return mg;
    }

    @Override
    double formulaMgBC(double x) {
        double mg;
        double x2 = (x-ab);
        mg =  (formulaMgAB(x) + (rby*x2) - ((q1*x2*x2)/2));
        return mg;
    }

    @Override
    double formulaMgCD(double x) {
        double mg;
        double x3 = (x-(ab+bc));
        mg = (formulaMgBC(x) + ((q1*x3*x3)/2) + (rcy*x3));
        return mg;
    }

    @Override
    double formulaTAB(double x) {
        double t;
        t = (-(f1/2));
        return t;
    }

    @Override
    double formulaTBC(double x) {
        double t;
        t = (formulaTAB(x) + rby - (q1*(x-ab)));
        return t;
    }

    @Override
    double formulaTCD(double x) {
        double t;
        t = (formulaTAB(x) + rby - (q1*bc) + rcy);
        return t;
    }

    @Override
    double calculateCAB() {
        double a = (ab+bc);
        cAB = ((((f1*ab*ab*ab)/12) - ((f1*a*a*a)/12) + ((rby*bc*bc*bc)/6) - ((q1*bc*bc*bc*bc)/24))/bc);
        return cAB;
    }

    @Override
    double calculateDAB() {
        dAB = ((-((cAB)*ab)) - ((f1*ab*ab*ab)/12));
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
        y = ((f1*x*x*x)/12);
        return y;
    }

    @Override
    double formulaYBC(double x) {
        double y;
        double x2 = (x - ab);
        y = (formulaYAB(x) - ((rby*x2*x2*x2)/6) + ((q1*x2*x2*x2*x2)/24));
        return y;
    }

    @Override
    double formulaYCD(double x) {
        double y;
        double x3 = (x-(ab+bc));
        y = (formulaYBC(x) - ((q1*x3*x3*x3*x3)/24) - ((rcy*x3*x3*x3)/6));
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
        return new boolean[]{false,true,true,false,false,false};
    }

    @Override
    public void calculator() {
        calculateRbx();
        calculateRcy();
        calculateRby();
    }

}