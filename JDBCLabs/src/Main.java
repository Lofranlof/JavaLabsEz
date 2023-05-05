import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class Main
{
    public static void main(String[] args) {
        Item item = null;
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=AdventureWorks2017BackupDB;"
                        + "user=sa;"
                        + "password=EbaloNa0;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {
            ItemDAO itemDAO = new ItemDAO(connection);
            item = itemDAO.searchById(999);
            System.out.println(item.getId() + " " + item.getName());
            item = itemDAO.searchById(998);
            System.out.println(item.getId() + " " + item.getName());

            DatabaseMetaData dmbd = connection.getMetaData();

            ArrayList<Item> items1 = itemDAO.searchByColor("Red");
            ArrayList<Item> items2 = itemDAO.searchByColor("Blue");

            System.out.println("Printing all red items:\n");
            for (Item item1:items1) {
                System.out.println(item1.getId() + " " + item1.getName());
            }

            System.out.println("Printing all blue items\n");
            for(Item item2:items2){
                System.out.println(item2.getId() + " " + item2.getName());
            }

            itemDAO.create(new Item(666, "Pahlava"));
            System.out.println(dmbd.getDriverName());
        }
        catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}