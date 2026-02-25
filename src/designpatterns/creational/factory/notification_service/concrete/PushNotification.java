package designpatterns.creational.factory.notification_service.concrete;

import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification : "+message);
    }
}
