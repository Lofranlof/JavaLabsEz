import java.sql.Date;

public class FoodItem extends GenericItem {
    public FoodItem(int id, String name, float price, short expires) {
        super(id, name, price);
        dateOfIncome = new java.sql.Date(System.currentTimeMillis());
        this.expires = expires;
    }
    Date dateOfIncome;
    short expires;
    @Override
    public void printAll()
    {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s, Date: %tD , Expires: %d  \n", ID, name,price, category, dateOfIncome, expires);
    }
}
