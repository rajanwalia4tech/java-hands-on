package designpatterns.creational.factory.notification_service;

import designpatterns.creational.factory.notification_service.NotificationCreator;
import designpatterns.creational.factory.notification_service.concrete.SMSNotification;
import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class SMSNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
