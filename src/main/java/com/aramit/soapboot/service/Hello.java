package com.aramit.soapboot.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://service.soap/",name ="Hello")
public interface Hello {
    @WebResult(name="return",targetNamespace="")
    @RequestWrapper(
            localName = "sayHello",
            targetNamespace = "http://service.soap/",
            className = "service.soap.SayHello"
    )
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(
            localName = "sayHelloResponse",
            targetNamespace = "http://service.soap/",
            className = "service.soap.SayHelloResponse"
    )
    String sayHello(@WebParam(name="myname",targetNamespace = "") String myname);
}
