public class Item {
    static NotificationService notificationService;
    private Integer id, totalStock;
    private String name;
    public Item(String name, Integer id, Integer totalStock) {
        this.name = name;
        this.totalStock = totalStock;
        this.id = id;
    }
    public Boolean isAvailable() {
        return this.totalStock > 0;
    }
    public Integer addStock(int stock) {
        int lastStock = totalStock;
        totalStock += stock;
        if(lastStock == 0 && isAvailable()) notificationService.notifyUser(this);
        return totalStock;
    }
    public Integer removeStock(int stock) {
        if(stock > totalStock) return -1;
        totalStock -= stock;
        return totalStock;
    }

    // getters
    public Integer getId() {
        return id;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
