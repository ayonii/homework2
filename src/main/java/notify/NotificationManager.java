package notify;

import java.util.*;
import java.util.stream.Collectors;

public class NotificationManager<T extends Notification> {
    private final List<T> list = new ArrayList<>();
    private final Map<Priority, List<T>> map = new HashMap<>();

    public void add(T notification) {
        if (list.stream().anyMatch(n -> n.getId() == notification.getId())) {
            throw new DuplicateIdException("Уведомление с id=" + notification.getId() + " уже существует");
        }

        list.add(notification);

        Priority priority = notification.getPriority();
        map.computeIfAbsent(priority, k -> new ArrayList<>()).add(notification);
    }

    public Optional<T> find(int id) {
        return list.stream()
                .filter(n -> n.getId() == id)
                .findFirst();
    }

    public List<T> get(Priority priority) {
        List<T> result = map.get(priority);
        if (result == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(result);
    }

    public void sendAll() {
        Sendable.sendAll(list);
    }
}