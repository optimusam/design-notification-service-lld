import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        Item.notificationService = notificationService;
        User.notificationService = notificationService;

        Item item1 = new Item("iPhone 13 Pro", 1, 20);
        Item item2 = new Item("S22+", 2, 2);
        Item item3 = new Item("Hair Dryer", 3, 0);
        User user1 = new User("Sameer", 1);
        User user2 = new User("Rahul", 2);
        User user3 = new User("Aprajita", 3);
        User user4 = new User("Mehul", 4);

        user1.registerForNotificationWhenStocksAreAvailable(item1);
        user1.registerForNotificationWhenStocksAreAvailable(item1);; // invalid registration. item already in stock.
        user2.registerForNotificationWhenStocksAreAvailable(item2); // invalid registration
        user1.registerForNotificationWhenStocksAreAvailable(item3); // valid registration
        user2.registerForNotificationWhenStocksAreAvailable(item3); // valid registration

        item3.addStock(3);

        item1.removeStock(20);
        user1.registerForNotificationWhenStocksAreAvailable(item1); // valid registration
        user3.registerForNotificationWhenStocksAreAvailable(item1); // valid registration
        item1.addStock(1);

        item2.removeStock(1);
        user4.registerForNotificationWhenStocksAreAvailable(item2); // invalid registration
        item2.removeStock(1);
        item2.addStock(1);
        item2.removeStock(1);
        user4.registerForNotificationWhenStocksAreAvailable(item2); // valid registration. stock is zero at this point
        item2.addStock(1);

        Item item4 = new Item("iPhone 14 Pro", 4, 20);
        item4.addStock(20);
        item4.removeStock(39);
        item4.removeStock(1);
        user3.registerForNotificationWhenStocksAreAvailable(item4); // valid
        item4.addStock(20);

        Item item5 = new Item("Boxing Gloves", 5, 0);
        user1.registerForNotificationWhenStocksAreAvailable(item5); // valid
        user1.registerForNotificationWhenStocksAreAvailable(item5); // invalid. user can't register for the same product more than once
        user3.registerForNotificationWhenStocksAreAvailable(item5);
        item5.addStock(1);
    }
}
