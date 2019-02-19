package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MyHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Product.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Manufacturer.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session=factory.getCurrentSession();
            session.beginTransaction();

            Client client = session.get(Client.class, 1L);
            System.out.println("Client " + client.getName() + " buys products: " + client.getProducts().toString());

            Product product = session.get(Product.class, 2L);
            System.out.println("Product "+product.getTitle()+" was bought by: " + product.getClients().toString());

            Product product1 = session.get(Product.class, 1L);
            session.delete(product1);

            Client client1 = session.get(Client.class, 1L);
            session.delete(client1);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}
