package notify;

public class EmailNotification extends Notification {
    private String email;

    // Конструктор: принимает email и сообщение, приоритет — HIGH
    public EmailNotification(String email, String message) {
        super(message, Priority.HIGH);
        this.email = email;
    }

    // Переопределение send()
    @Override
    public void send() {
        System.out.println("Sending e-mail to " + email);
        super.send(); // вызов родительского send()
    }

    // Геттер
    public String getEmail() {
        return email;
    }
}