package com.endava.cxf;

import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Valentina Shaban.
 */
public class HelloPortImplTest {
    private static QName SERVICE_NAME = new QName("helloService", "HelloService");
    private static QName PORT_NAME = new QName("helloService", "HelloPort");

    private Service service;

    @Test
    public void whenHelloMethod_thenReceiveHelloMessage() throws MalformedURLException {
        service = Service.create(new URL("http://localhost:8080/hello?wsdl"), SERVICE_NAME);
        HelloPortType port = service.getPort(PORT_NAME, HelloPortType.class);
        Person person = new Person();
        person.setName("John");

        String response = port.sayHello(person);
        System.out.println(response);
    }
}
