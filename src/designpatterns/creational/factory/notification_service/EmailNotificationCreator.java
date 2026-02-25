package designpatterns.creational.factory.notification_service;

import designpatterns.creational.factory.notification_service.NotificationCreator;
import designpatterns.creational.factory.notification_service.concrete.EmailNotification;
import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class EmailNotificationCreator extends NotificationCreator {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
