package HibernateHomework;

import javax.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or @GeneratedValue
    @Column(name = "flat_id")
    private int id;

    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int square;
    @Column(nullable = false)
    private int rooms;
    @Column(nullable = false)
    private int price;

    public Flat(String district, String address, int square, int rooms, int price) {
        this.district = district;
        this.address = address;
        this.square = square;
        this.rooms = rooms;
        this.price = price;
    }

    public Flat() {
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", rooms=" + rooms +
                ", price=" + price +
                '}';
    }
}
