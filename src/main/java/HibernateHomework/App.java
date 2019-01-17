package HibernateHomework;

//import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.w3c.dom.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App
{
    public static void main( String[] args ){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();

        System.out.println("----------------------Task 1. Flats database --------------------------");
        System.out.println("fill flats table...");

        em.getTransaction().begin();
        for (int i = 0; i <= Randomizer.newIntParam(10); i ++ ) {
            em.persist(Randomizer.newFlat());
        }
        em.getTransaction().commit();

        System.out.println("view table");
        Query query = em.createQuery("SELECT c FROM Flat c", Flat.class);
        List<Flat> flats = query.getResultList();

        for (Flat flat:flats) {
            System.out.println(flat);
        }

        System.out.println("searching flats by parametr district = Borshchaga");
        Query queryByParam = em.createQuery("SELECT c FROM Flat c WHERE c.district = :dis", Flat.class);
        queryByParam.setParameter("dis", "Borshchaga");
        List<Flat> flatsByDistrict = queryByParam.getResultList();

        for (Flat flat:flatsByDistrict) {
            System.out.println(flat);
        }

        System.out.println("------------------------------Task 2. Clients, goods and orders ---------------------------");
        System.out.println("Fill clients and goods tables");

        em.getTransaction().begin();
        for (int i = 0; i <= Randomizer.newIntParam(10); i ++ ) {
            Client c = new Client(Randomizer.newName(), Randomizer.newIntParam(60) + 17, Randomizer.newPhoneNumber());
            em.persist(c);
            Product p = new Product(Randomizer.newString(Randomizer.newIntParam(8)+3), Randomizer.newIntParam(100), Randomizer.newIntParam(1000));
            em.persist(p);
        }
        em.getTransaction().commit();

        System.out.println("View clients table");
        Query queryAllClients = em.createQuery("SELECT c FROM Client c", Client.class);
        List<Client> clients = queryAllClients.getResultList();

        for (Client c:clients) {
            System.out.println(c);
        }

        System.out.println("View products table");
        Query queryAllProducts = em.createQuery("SELECT c FROM Product c", Product.class);
        List<Product> products = queryAllProducts.getResultList();

        for (Product p:products) {
            System.out.println(p);
        }

        System.out.println("Making orders");
        //every client make from 1 to 4 orders
        em.getTransaction().begin();
        for (int i = 0; i < clients.size(); i ++ ) {
            for (int j = 0; j <= Randomizer.newIntParam(3); j++) {
                Order o = new Order(products.get(Randomizer.newIntParam(products.size() - 1)), clients.get(i));
                em.persist(o);
            }
        }
        em.getTransaction().commit();

        System.out.println("View orders table");
        Query queryAllOrders = em.createQuery("SELECT c FROM Order c", Order.class);
        List<Order> orders = queryAllOrders.getResultList();

        for (Order o:orders) {
            System.out.println(o);
        }

        System.out.println("Client 0 orders");
        for (Order o:clients.get(0).getOrders()) {
            System.out.println(o);
        }

        //finalysing
        em.close();
        emf.close();

    }
}
