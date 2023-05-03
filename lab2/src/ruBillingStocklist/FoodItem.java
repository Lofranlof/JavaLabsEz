package ruBillingStocklist;

import java.sql.Date;

public class FoodItem extends GenericItem {
    // my constructor
    public FoodItem(int id, String name, float price, short expires) {
        super(name, price);
        dateOfIncome = new java.sql.Date(System.currentTimeMillis());
        this.expires = expires;
    }

    // constructor 1
    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.setName(name);
        this.setPrice(price);
        this.setAnalog(analog);
        this.setDate(date);
        this.setExpires(expires);
    }

    // constructor 2
    public FoodItem(String name, float price, short expires) {
        this(name, price, null, new java.sql.Date(System.currentTimeMillis()), expires);
    }

    // constructor 3
    public FoodItem(String name) {
        this(name, 10, null, new java.sql.Date(System.currentTimeMillis()), (short) 10);
    }

    Date dateOfIncome;

    public Date getDate() {
        return dateOfIncome;
    }

    public void setDate(Date date) {
        dateOfIncome = date;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public short getExpires() {
        return expires;
    }

    public FoodItem getAnalog() {
        return analog;
    }

    public void setAnalog(FoodItem analog) {
        this.analog = analog;
    }

    short expires;
    FoodItem analog;

    @Override
    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category: %-20s, Date: %tD , Expires: %d  \n", getID(), getName(),
                getPrice(), getCategory(), dateOfIncome, expires);
    }
}
