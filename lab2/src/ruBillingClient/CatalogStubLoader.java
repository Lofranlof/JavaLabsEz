package ruBillingClient;

import ruBillingStocklist.*;

public class CatalogStubLoader implements CatalogLoader
{
    GenericItem item1 = new GenericItem("Sony TV", 23000, Category.GENERAL); 
    FoodItem item2 = new FoodItem("Bread", 12, null, new java.sql.Date(0), (short) 10);
    public void load(ItemCatalog catalog)
    {
        catalog.addItem(item1);
        catalog.addItem(item2);
    }

}
