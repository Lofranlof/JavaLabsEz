package ruBillingStocklist;


public class GenericItem {
    public GenericItem(String name, float price) {
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
        ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.analog = analog;
        ID = GenericItem.currentID++;
    }

    public GenericItem() {
        ID = GenericItem.currentID++;
    }

    private int ID;

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private GenericItem analog;

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    static int currentID = 1;

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s \n", ID, name, price, category);
    }
}
