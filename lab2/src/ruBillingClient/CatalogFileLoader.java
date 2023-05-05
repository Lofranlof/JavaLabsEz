package ruBillingClient;

import ruBillingStocklist.FoodItem;
import ruBillingStocklist.ItemCatalog;
import ruItmoExceptions.CatalogLoadException;
import ruItmoExceptions.ItemAlreadyExistsException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CatalogFileLoader implements CatalogLoader {
    private String fileName;
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {

        File f = new File(fileName);
        FileInputStream fis;
        String line;
        try {
            fis = new FileInputStream(f);
            Scanner s = new Scanner(fis);

            while(s.hasNextLine()) {
                line = s.nextLine();
                if(line.length()==0) break;
                String[] item_fld = line.split(";");
                String name = item_fld[0];
                float price = Float.parseFloat(item_fld[1]);
                short expires = Short.parseShort(item_fld[2]);
                Date currentDate = new Date(System.currentTimeMillis());
                FoodItem item = new FoodItem(name,price,null,new Date(System.currentTimeMillis()) ,expires);
                catalog.addItem(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }
}
