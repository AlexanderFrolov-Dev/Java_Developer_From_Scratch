public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalPriceInAllBaskets = 0;
    private static int totalCountInAllBaskets = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        addInTotalCount(count);
        addInTotalPrice(count * price);
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight += weight;

        items += " - " + weight + " мл.";
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    private static void addInTotalPrice(int count) {
        totalPriceInAllBaskets += count;
    }

    private static void addInTotalCount(int count) {
        totalCountInAllBaskets += count;
    }

    public static int getTotalPriceInAllBaskets() {
        return totalPriceInAllBaskets;
    }

    public static int getTotalCountInAllBaskets() {
        return totalCountInAllBaskets;
    }

    public static double getAverageTotalPriceAllBaskets() {
        return (double) totalPriceInAllBaskets / totalCountInAllBaskets;
    }

    public static double getAveragePriceOfBasket() {
        return (double) totalPriceInAllBaskets / count;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
