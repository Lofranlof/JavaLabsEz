import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ItemDAO {
    private final Connection connection;

    public ItemDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public Item searchById(int id) throws SQLException {
        String query = "SELECT * FROM Production.Product WHERE ProductID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Item(
                            resultSet.getInt("ProductID"),
                            resultSet.getString("Name")
                    );
                } else {
                    return null;
                }
            } finally {
                if (statement != null) {
                    statement.close();
                }
            }
        }
    }

    public ArrayList<Item> searchByColor(String color) {
        ArrayList<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM Production.Product WHERE Color=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, color);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("Name");
                Item item = new Item(id, name);
                items.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public void create(Item item) throws SQLException {
        String sql = "SET IDENTITY_INSERT Production.ProductCategory ON; INSERT INTO Production.ProductCategory (ProductCategoryID, Name, rowguid, ModifiedDate) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, item.getId());
        stmt.setString(2, item.getName());
        stmt.setString(3, "3F2504E0-4F89-11D3-9A0C-0305E82C3301");
        stmt.setString(4, "2023-05-05 10:00:00");
        int rowsInserted = stmt.executeUpdate();
        System.out.println(rowsInserted + " row(s) inserted.");
        connection.commit();
        stmt.close();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

