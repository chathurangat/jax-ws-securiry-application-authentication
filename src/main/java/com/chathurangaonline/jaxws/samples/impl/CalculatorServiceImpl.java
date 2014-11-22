package com.chathurangaonline.jaxws.samples.impl;

import com.chathurangaonline.jaxws.samples.CalculatorService;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;


@WebService
public class CalculatorServiceImpl implements CalculatorService{

    @Resource
    private WebServiceContext webServiceContext;

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }


    /**
     * <p>
     *     method for checking the application level authentication using the username and password provided.
     * </p>
     * @param username - username provided as {@link java.lang.String}
     * @param password - password provided as {@link java.lang.String}
     * @return {@link java.lang.Boolean} (true if user authenticated, otherwise false)
     */
    private boolean isAuthenticated(String username, String password){
        if(username!=null && password!=null){
            MessageContext messageContext = webServiceContext.getMessageContext();
            Map httpHeaders  = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);

            List usernameList  = (List) httpHeaders.get("username");
            List passwordList = (List) httpHeaders.get("password");

            if(usernameList.contains(username) && passwordList.contains(password)){
                return true;
            }
        }
        return false;
    }
}
