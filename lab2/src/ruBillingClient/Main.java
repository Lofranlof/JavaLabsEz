package ruBillingClient;
import java.util.Date;
import ruBillingStocklist.GenericItem;
import ruBillingStocklist.FoodItem;
import ruBillingStocklist.TechnicalItem;
import ruBillingStocklist.Category;
import ruBillingStocklist.ItemCatalog;

public class Main {
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem("agua", 1);
        GenericItem item2 = new GenericItem("camiseta", 100);
        GenericItem item3 = new GenericItem("libro", 50);
        FoodItem item4 = new FoodItem(4, "manzana", 12, (short) 5);
        TechnicalItem item5 = new TechnicalItem(5, "computadora", 10000, (short) 720);

        item1.setCategory(Category.FOOD);
        item3.setCategory(Category.PRINT);

        item1.printAll();
        item2.printAll();
        item3.printAll();
        item4.printAll();
        item5.printAll();
        System.out.println(item5.getID());

        String line = "Candies 'Mask'; 45; 120";
        String[] item_fld = line.split(";");
        FoodItem item6 = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]),
                (short) Float.parseFloat(item_fld[2]));
        item6.printAll();

        ItemCatalog catalog = new ItemCatalog();
        catalog.addItem(item1);
        catalog.addItem(item2);
        catalog.addItem(item3);
        catalog.addItem(item4);
        catalog.addItem(item5);
        catalog.addItem(item6);

        long begin = new Date().getTime();

        for (int i = 0; i < 100000000; i++)
            catalog.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));

        begin = new Date().getTime();
        for (int i = 0; i < 100000000; i++)
            catalog.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        catalog.printItemsContents();
    }
}
