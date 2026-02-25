package designpatterns.creational.factory.notification_service;

import designpatterns.creational.factory.notification_service.concrete.SMSNotification;

public class FactorDemo {
    public static void main(String[] args) {
        NotificationCreator creator;

        creator = new EmailNotificationCreator();
        creator.send("Hi, How are you?");

        creator = new PushNotificationCreator();
        creator.send("Welcome, you have earned 500 Rs.");

        creator = new SMSNotificationCreator();
        creator.send("Learning Factory Design Pattern");
    }
}

