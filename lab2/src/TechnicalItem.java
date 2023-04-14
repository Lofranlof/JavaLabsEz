public class TechnicalItem extends GenericItem{
    public TechnicalItem(int id, String name, float price, short warrantyTime) {
        super(name, price);
        this.warrantyTime = warrantyTime;
    }

    short warrantyTime;

    @Override
    public void printAll()
    {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s, Warranty time: %d  \n", ID, name,
                price, category, warrantyTime);
    }

    
}
