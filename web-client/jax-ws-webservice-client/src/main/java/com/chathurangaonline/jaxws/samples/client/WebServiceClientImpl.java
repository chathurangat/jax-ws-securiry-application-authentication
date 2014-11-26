package com.chathurangaonline.jaxws.samples.client;

import com.chathurangaonline.jaxws.samples.impl.*;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WebServiceClientImpl {

    public static void main(String [] args){

        CalculatorServiceImplService calculatorServiceImplService = new CalculatorServiceImplService();
        CalculatorServiceImpl calculatorService = calculatorServiceImplService.getCalculatorServiceImplPort();

        Map<String, Object> req_ctx = ((BindingProvider)calculatorService).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();

        headers.put("Username", Collections.singletonList("chathuranga"));
        headers.put("Password", Collections.singletonList("chathu@123"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        //in order to invoke the add method, you need to have valid login credentials 
        double answer =  calculatorService.add(45,10);
        System.out.println(" answer is ["+answer+"]");
    }
}
