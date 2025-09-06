package notify;

public class Demo {
    public static void main(String[] args) {
        Notification[] notifications = new Notification[4];

        notifications[0] = new EmailNotification(
                "Your order is confirmed",
                Priority.HIGH,
                "user@example.com"
        );

        notifications[1] = new SmsNotification(
                "Your OTP is 1234",
                Priority.NORMAL,
                "+123456789"
        );

        notifications[2] = new EmailNotification(
                "System alert: High CPU usage",
                Priority.HIGH,
                "admin@site.com"
        );

        notifications[3] = new SmsNotification(
                "Payment reminder",
                Priority.LOW,
                "+987654321"
        );

        for (Notification notification : notifications) {
            notification.send();
            System.out.println("---");
        }

        System.out.println("Total notifications created: " + notifications.length);
    }
}