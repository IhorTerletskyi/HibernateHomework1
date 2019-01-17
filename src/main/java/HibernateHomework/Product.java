package HibernateHomework;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Goods")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "Product_id")
    private int id;

    @Column(name = "Product_name", nullable = false)
    private String name;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = false)
    private int price;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

    public Product(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Product() {
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
