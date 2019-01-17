package HibernateHomework;
import javax.management.OperationsException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "Client_id")
    private int id;

    @Column(name = "Client_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    private int phone;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client(String name, int age, int phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Client() {
    }

    public void addOrder (Order order) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
