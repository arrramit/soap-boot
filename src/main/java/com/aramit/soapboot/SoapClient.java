package com.aramit.soapboot;

import org.apache.cxf.staxutils.StaxUtils;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SoapClient {
    public static void main(String[] args) throws MalformedURLException {
        String address = "http://localhost:8080/service/hello";
        String request =
                "<q:sayHello xmlns:q=\"http://service.soap/\">" +
                    "<myname>Almir</myname>" +
                "</q:sayHello>";
        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://service.soap/" , "HelloService"));
        Dispatch<Source> disp = service.createDispatch(new QName("http://service.soap/" , "HelloPort"),
                Source.class, Service.Mode.PAYLOAD);

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        System.out.println(resultAsString);
    }
}
