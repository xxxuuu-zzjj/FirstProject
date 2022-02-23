package com.design.strategy.sonClass;

import com.design.strategy.CashSuper;

public class CashReturn extends CashSuper {

    private double moneyCondition = 0;
    private double moneyReturn = 0;

    public CashReturn(double moneyCondition,double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {

        double result = money;

        if(money>moneyCondition){
            result = money - (int)(money/moneyCondition)*moneyReturn;
        }

        return result;
    }
}
