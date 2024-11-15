/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.model;


public class Notification {
    private int notificationId;
    private int customerId;
    private String message;
    private String notificationType; // SMS or Email

    // Default constructor
    public Notification() {}

    // Parameterized constructor
    public Notification(int notificationId, int customerId, String message, String notificationType) {
        this.notificationId = notificationId;
        this.customerId = customerId;
        this.message = message;
        this.notificationType = notificationType;
    }

    // Getters and Setters
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}


