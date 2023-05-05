package ruBillingStocklist;

import ruItmoExceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog 
{
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public HashMap<Integer, GenericItem> getHashMap()
    {
        return catalog;
    }
    
    public ArrayList<GenericItem> getArrayList()
    {
        return ALCatalog;
    }

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsValue(item) || ALCatalog.contains(item))
        {
            throw new  ItemAlreadyExistsException();
        }
        catalog.put(item.getID(), item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public void printItemsContents() {
        for (GenericItem i : ALCatalog) {
            i.printAll();
        }
    }

    public GenericItem findItemByID(int id) {
        // Если нет такого ID, возвращаем пустое значение
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : ALCatalog) {
            if (i.getID() == id)
                return i;
        }
        return null;
    }

}
