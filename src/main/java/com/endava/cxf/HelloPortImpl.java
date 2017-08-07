package com.endava.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by Valentina Shaban.
 */
@WebService(name = "HelloPortType", targetNamespace = "helloService", serviceName = "HelloService", portName = "HelloPort")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public class HelloPortImpl implements HelloPortType {

    @WebMethod(action = "sayHello")
    @WebResult(name = "greeting", targetNamespace = "http://localhost:8080/xsd/hello", partName = "greeting")
    public String sayHello(@WebParam(name = "person", targetNamespace = "http://localhost:8080/xsd/hello", partName = "person") Person person) {
        return "Hello, " + person.getName() + "!";
    }
}
