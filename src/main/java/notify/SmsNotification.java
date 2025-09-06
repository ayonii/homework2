package notify;

public class SmsNotification extends Notification {
    private String phoneNumber;

    public SmsNotification(String message, Priority priority, String phoneNumber) {
        super(message, priority);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("Отправка SMS на " + phoneNumber + ": " + message);
    }
}