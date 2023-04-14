public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem("agua", 1);
        GenericItem item2 = new GenericItem("camiseta", 100);
        GenericItem item3 = new GenericItem("libro", 50);
        FoodItem item4 = new FoodItem(4, "manzana", 12, (short) 5);
        TechnicalItem item5 = new TechnicalItem(5, "computadora", 10000, (short) 720);

        item1.category = Category.FOOD;
        item3.category = Category.PRINT;

        item1.printAll();
        item2.printAll();
        item3.printAll();
        item4.printAll();
        item5.printAll();
        System.out.println(GenericItem.currentID);

        String line = "Candies 'Mask'; 45; 120";
        String[] item_fld = line.split(";");
        FoodItem item6 = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), (short)Float.parseFloat(item_fld[2]));
        item6.printAll();

    }
}
