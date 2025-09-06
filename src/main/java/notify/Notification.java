package notify;

public abstract class Notification implements Sendable {
    protected final int id;
    protected String message;
    protected Priority priority;

    private static int nextId = 1;

    public Notification(String message, Priority priority) {
        this.id = nextId++;
        this.message = message;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    // Новый геттер для message
    public String getMessage() {
        return message;
    }

    @Override
    public abstract void send();
}