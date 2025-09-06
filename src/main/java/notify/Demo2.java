package notify;

import java.util.List;
import java.util.Optional;

public class Demo2 {
    public static void main(String[] args) {
        // 1. Инициализация менеджера уведомлений
        NotificationManager<Notification> manager = new NotificationManager<>();

        // 2. Создание разных уведомлений
        EmailNotification email1 = new EmailNotification("Привет!", Priority.HIGH, "user@example.com");
        SmsNotification sms1 = new SmsNotification("Проверьте почту", Priority.NORMAL, "+79991234567");
        EmailNotification email2 = new EmailNotification("Важно!", Priority.HIGH, "admin@site.ru");

        // 3. Добавление уведомлений в менеджер
        manager.add(email1);
        manager.add(sms1);
        manager.add(email2);

        // 4. Проверка дубликата
        try {
            manager.add(email1); // попытка добавить дубликат
        } catch (DuplicateIdException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // 5. Вывод HIGH-уведомлений
        System.out.println("\nВысокий приоритет:");
        List<Notification> highNotifications = manager.get(Priority.HIGH);
        highNotifications.forEach(System.out::println);

        // 6. Поиск одного уведомления по id
        Optional<Notification> found = manager.find(email1.getId());
        if (found.isPresent()) {
            System.out.println("\nНайдено уведомление: " + found.get().getMessage());
            found.get().sendWithLogging(); // демонстрация логирования
        }

        // 7. Массовая отправка всех уведомлений
        System.out.println("\nМассовая отправка:");
        manager.sendAll();
    }
}