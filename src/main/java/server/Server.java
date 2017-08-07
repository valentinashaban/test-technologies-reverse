package server;

import com.endava.cxf.HelloPortImpl;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;

/**
 * Created by Valentina Shaban.
 */
public class Server {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        HelloPortImpl endPoint = new HelloPortImpl();
        String address = "http://localhost:8080/hello";
        Endpoint.publish(address, endPoint);
    }
}
