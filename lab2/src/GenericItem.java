class GenericItem {
    public GenericItem(String name, float price) 
    {
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, Category category)
    {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog)
    {
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.ID = GenericItem.currentID++;
    }

    public GenericItem() { this.ID = GenericItem.currentID++; }

    public int ID;
    public String name;
    public float price;
    public Category category;
    GenericItem analog;
    static int currentID = 1;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s \n", ID, name, price, category);
    }
}
