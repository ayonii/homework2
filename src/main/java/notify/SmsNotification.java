package notify;

public class SmsNotification extends Notification {
    private String phoneNumber;

    // Конструктор: телефон и сообщение, приоритет — LOW
    public SmsNotification(String phoneNumber, String message) {
        super(message, Priority.LOW);
        this.phoneNumber = phoneNumber;
    }

    // Переопределение send()
    @Override
    public void send() {
        System.out.println("Sending SMS to " + phoneNumber);
        super.send(); // вызов родительского send()
    }

    // Геттер
    public String getPhoneNumber() {
        return phoneNumber;
    }
}