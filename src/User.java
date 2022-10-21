public class User {
    static NotificationService notificationService;
    private String name;
    private Integer id;
    User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public void registerForNotificationWhenStocksAreAvailable(Item item) {
        notificationService.register(item, this);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
