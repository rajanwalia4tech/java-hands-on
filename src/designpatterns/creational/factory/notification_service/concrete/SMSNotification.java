package designpatterns.creational.factory.notification_service.concrete;

import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class SMSNotification implements Notification {


    @Override
    public void send(String message) {
        System.out.println("Sending SMS : "+message);
    }
}
