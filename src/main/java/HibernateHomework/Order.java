package HibernateHomework;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int id;

    @Column(nullable = false)
    private long time;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order() {
        this.time = System.currentTimeMillis();
    }

    public Order(Product product, Client client) {
        this.time = System.currentTimeMillis();
        this.product = product;
        product.addOrder(this);
        this.client = client;
        client.addOrder(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        Date date = new Date(time);
        return "Order # " + id +
                ", " + date.toString() +
                ", product=" + product +
                ", client=" + client +
                '}';
    }
}
