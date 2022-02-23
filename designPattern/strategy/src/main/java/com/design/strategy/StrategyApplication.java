package com.design.strategy;

import com.design.strategy.sonClass.CashNormal;
import com.design.strategy.sonClass.CashRebate;
import com.design.strategy.sonClass.CashReturn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrategyApplication.class, args);

        CashContext cashContext = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入优惠方式（1：正常 2：打折 3：返利）");
        int in = scanner.nextInt();
        String type ="";

        switch (in){
            case 1:
                cashContext = new CashContext(new CashNormal());
                type += "正常收费";
                break;
            case 2:
                cashContext = new CashContext(new CashRebate(0.9));
                type += "打9折";
                break;
            case 3:
                cashContext = new CashContext(new CashReturn(500,100));
                type += "满500返100";
                break;
        }

        double totalMoney = 0;
        System.out.println("输入单价：");
        double price = scanner.nextDouble();
        System.out.println("输入数量: ");
        double num = scanner.nextInt();
        totalMoney = cashContext.getResult(price*num);
        System.out.println("单价：" + price + "，数量：" + num + "，类型：" + type + "，合计：" + totalMoney);
        scanner.close();
    }

}
