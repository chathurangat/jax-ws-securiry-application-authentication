package com.chathurangaonline.jaxws.samples;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculatorService {

    @WebMethod
    double add(double num1,double num2);

    @WebMethod
    double multiply(double num1,double num2);

}
