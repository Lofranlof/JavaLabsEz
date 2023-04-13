class GenericItem {
    public GenericItem(int id, String name, float price) 
    {
        this.ID = id;
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
    }

    public int ID;
    public String name;
    public float price;
    public Category category;

    void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s \n", ID, name, price, category);
    }
}
