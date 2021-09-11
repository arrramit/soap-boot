package com.aramit.soapboot.services;

import javax.jws.WebService;
import java.util.logging.Logger;

@WebService(
        serviceName = "HelloService",
        portName = "HelloPort",
        targetNamespace = "http://service.soap/",
        endpointInterface = "com.aramit.soapboot.services.Hello"
)

public class HelloImpl {
    private static final Logger logger = Logger.getLogger(HelloImpl.class.getName());
    public String sayHello(String myname) {
        logger.info("Executing operation sayHello" + myname);
        try {
            return "Hello, " + myname + "!!!";

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
