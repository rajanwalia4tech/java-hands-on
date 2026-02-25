package designpatterns.creational.factory.notification_service;

import designpatterns.creational.factory.notification_service.concrete.PushNotification;
import designpatterns.creational.factory.notification_service.interfaces.Notification;

public class PushNotificationCreator extends NotificationCreator{
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
