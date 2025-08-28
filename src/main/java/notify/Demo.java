package notify;

public class Demo {
    public static void main(String[] args) {
        // Создание массива уведомлений
        Notification[] notifications = new Notification[4];
        notifications[0] = new EmailNotification("user@example.com", "Your order is confirmed");
        notifications[1] = new SmsNotification("+123456789", "Your OTP is 1234");
        notifications[2] = new EmailNotification("admin@site.com", "System alert: High CPU usage");
        notifications[3] = new SmsNotification("+987654321", "Payment reminder");

        // Полиморфный вызов send()
        for (Notification notification : notifications) {
            notification.send();
            System.out.println("---");
        }

        // Вывод количества уведомлений
        System.out.println("Total notifications created: " + notifications.length);
    }
}