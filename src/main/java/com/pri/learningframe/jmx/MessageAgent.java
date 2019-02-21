package com.pri.learningframe.jmx;

//import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;

public class MessageAgent {
//implements NotificationListener

//    private MBeanServer mBeanServer;
//
//    public MessageAgent(){
//        this.mBeanServer = MBeanServerFactory.createMBeanServer("MessageAgent");
//        Message message = new Message();
//        ObjectName objectName = null;
//        try {
//            objectName = new ObjectName("MessageAgent:name=Message");
//            mBeanServer.registerMBean(message,objectName);
//        } catch (MalformedObjectNameException e) {
//            e.printStackTrace();
//        } catch (NotCompliantMBeanException e) {
//            e.printStackTrace();
//        } catch (InstanceAlreadyExistsException e) {
//            e.printStackTrace();
//        } catch (MBeanRegistrationException e) {
//            e.printStackTrace();
//        }
//
//
//        startHtmlAdaptorServer();
//
//
//        JMXServiceURL url = null;
//        try {
//            url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/MessageAgent");
//            JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, this.mBeanServer);
//            jmxConnector.start();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void handleNotification(Notification notification, Object handback) {
//
//    }
//
//    public void startHtmlAdaptorServer(){
//        HtmlAdaptorServer htmlAdaptorServer = new HtmlAdaptorServer();
//        ObjectName adapterName = null;
//        try {
//            // 多个属性使用,分隔
//            adapterName = new ObjectName("MessageAgent:name=htmladapter,port=9092");
//            htmlAdaptorServer.setPort(9092);
//            mBeanServer.registerMBean(htmlAdaptorServer, adapterName);
//            htmlAdaptorServer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String args[]){
//        System.out.println(" hello agent is running");
//        MessageAgent agent = new MessageAgent();
//    }
}
