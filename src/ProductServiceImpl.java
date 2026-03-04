
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements Operable<Product> {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        //Connection Obtained from DBConnection Required to talk to MySQL.
        Connection con = DBConnection.getDBConnection();
        try {

            //For simple queries without parameters
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product find(int id) {
        Product product = null;
        Connection con = DBConnection.getDBConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product WHERE id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Connection con = DBConnection.getDBConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Product deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Product product) {
        Connection con = DBConnection.getDBConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.executeUpdate();
            System.out.println("Product added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Product product) {
        Connection con = DBConnection.getDBConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "UPDATE product SET name=?, price=?, quantity=? WHERE id=?");
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Product updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
