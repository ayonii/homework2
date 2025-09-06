package notify;

public class EmailNotification extends Notification {
    private String email;

    public EmailNotification(String message, Priority priority, String email) {
        super(message, priority);
        this.email = email;
    }

    @Override
    public void send() {
        System.out.println("Отправка письма на " + email + ": " + message);
    }
}