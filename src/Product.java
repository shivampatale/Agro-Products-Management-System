//POJO class
public class Product {
    int id;
    String name;
    double price;
    int quantity;

    //Parameterized Constructor
    public Product(int id, String name, double price, int quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //tostring Method
    @Override
    public String toString() {
        return "Product id=" + id + ", name=" + name +
                ", price=" + price + ", quantity=" + quantity + "";
    }

    //getter and setter methods

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
