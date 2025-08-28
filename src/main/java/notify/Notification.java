package notify;

public class Notification {
    private final int id;
    private String message;
    private Priority priority;
    private static int nextId = 1;

    // Конструктор без аргументов — делегирует конструктору с параметрами
    public Notification() {
        this("empty", Priority.NORMAL);
    }

    // Конструктор с аргументами
    public Notification(String message, Priority priority) {
        this.id = nextId++;
        this.message = message;
        this.priority = priority;
    }

    // Метод send() без аргументов
    public void send() {
        System.out.println(toString());
    }

    // Перегруженный метод send с дополнительной строкой
    public void send(String extra) {
        System.out.println(this + " | Extra: " + extra);
    }

    // Переопределение toString()
    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", priority=" + priority +
                '}';
    }

    // Геттеры (если потребуется)
    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }
}