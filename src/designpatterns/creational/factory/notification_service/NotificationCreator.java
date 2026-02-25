package designpatterns.creational.factory.notification_service;

import designpatterns.creational.factory.notification_service.interfaces.Notification;

public abstract class NotificationCreator {
    // Factory Method - subclasses decide what to create
    public abstract Notification createNotification();

    // Shared logic that uses the factory method
    public void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
