package designpatterns.creational.factory.notification_service.concrete;

import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending Email : "+message);
    }
}
