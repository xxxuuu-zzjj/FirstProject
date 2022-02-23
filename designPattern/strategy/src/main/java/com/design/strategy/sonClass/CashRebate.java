package com.design.strategy.sonClass;

import com.design.strategy.CashSuper;

/**
 * 折扣子类
 */
public class CashRebate extends CashSuper {

    private double rebate = 1;

    public CashRebate(double rebate){
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {
        return money*rebate;
    }
}
