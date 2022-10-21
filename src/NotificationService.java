import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private Map<Integer, List<User>> notificationMap;
    NotificationService() {
        this.notificationMap = new HashMap<>();
    }
    public void register(Item item, User user) {
        if(item.getTotalStock() > 0) return;
        if(notificationMap.containsKey(item.getId())) {
            if(!notificationMap.get(item.getId()).contains(user))
                notificationMap.get(item.getId()).add(user);
            return;
        }
        List<User> userList = new ArrayList<>();
        userList.add(user);
        notificationMap.put(item.getId(), userList);
    }
    public void notifyUser(Item item) {
        if(!notificationMap.containsKey(item.getId())) return;
        for(User user: notificationMap.get(item.getId())) {
            sendNotification(user, item);
        }
    }

    private void sendNotification(User user, Item item) {
        System.out.println("Hi " + user + "! The item " + item + " is back in stock! Buy it now!");
    }
}
