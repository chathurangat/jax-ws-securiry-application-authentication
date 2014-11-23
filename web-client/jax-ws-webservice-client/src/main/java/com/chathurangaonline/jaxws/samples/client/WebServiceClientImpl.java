package com.chathurangaonline.jaxws.samples.client;

import com.chathurangaonline.jaxws.samples.impl.*;


public class WebServiceClientImpl {

    public static void main(String [] args){

        CalculatorServiceImplService calculatorServiceImplService = new CalculatorServiceImplService();
        CalculatorServiceImpl calculatorService = calculatorServiceImplService.getCalculatorServiceImplPort();

        double answer =  calculatorService.add(45,10);

        System.out.println(" answer is ["+answer+"]");
    }
}
