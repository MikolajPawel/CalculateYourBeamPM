package com;

import com.fastening_types.*;

public abstract class LoadFasteningType {

    public static FasteningType calculate(int cs, double[] values, OptionPanes optionPanes){
        FasteningType calculate = null;
        switch (cs){
            case 0 -> calculate = new FasteningType(values,optionPanes,true);
            case 1 -> calculate = new FasteningType_1(values,optionPanes,false);
            case 2 -> calculate = new FasteningType_2(values,optionPanes,false);
            case 3 -> calculate = new FasteningType_3(values,optionPanes,false);
            case 4 -> calculate = new FasteningType_4(values,optionPanes,false);
            case 5 -> calculate = new FasteningType_5(values,optionPanes,false);
            case 6 -> calculate = new FasteningType_6(values,optionPanes,false);
            case 7 -> calculate = new FasteningType_7(values,optionPanes,false);
            case 8 -> calculate = new FasteningType_8(values,optionPanes,false);
            case 9 -> calculate = new FasteningType_9(values,optionPanes,false);
        }
        return calculate;
    }

}
