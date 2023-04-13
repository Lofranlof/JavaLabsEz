public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem(1, "agua", 1);
        GenericItem item2 = new GenericItem(2, "camiseta", 100);
        GenericItem item3 = new GenericItem(3, "libro", 50);
        FoodItem item4 = new FoodItem(4, "manzana", 12, (short) 5);
        TechnicalItem item5 = new TechnicalItem(5, "computadora", 10000, (short) 720);

        item1.category = Category.FOOD;
        item3.category = Category.PRINT;

        item1.printAll();
        item2.printAll();
        item3.printAll();
        item4.printAll();
        item5.printAll();
    }
}
