package ruBillingClient;

import ruBillingStocklist.*;
import ruItmoExceptions.CatalogLoadException;

public interface CatalogLoader {
    public void load(ItemCatalog catalog) throws CatalogLoadException;
}
