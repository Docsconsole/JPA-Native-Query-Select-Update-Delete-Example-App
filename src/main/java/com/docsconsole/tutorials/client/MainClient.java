package com.docsconsole.tutorials.client;

import com.docsconsole.tutorials.entity.Player;
import com.docsconsole.tutorials.entity.Product;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("main method @MainClient");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();
            transaction.begin();

            //different NamedNativeQueries on Player
            System.out.println("Using NamedNativeQuery annotation");
            System.out.println("selectProduct Using createNamedQuery");
            Query query = entityManager.createNamedQuery("selectPlayer", Player.class);
            query.setParameter(1, 1000011);
            List list = query.getResultList();
            list.stream().forEach(System.out::println);


            System.out.println("<-----------Using NamedNativeQuery annotation for Player----------->");
            System.out.println("updatePlayer Using createNamedQuery");
            entityManager.createNamedQuery("updatePlayer", Player.class)
                    .setParameter(1, "Lionel123")
                    .setParameter(2, 1000010)
                    .executeUpdate();



            System.out.println("deletePlayer Using createNamedQuery");
            entityManager.createNamedQuery("deletePlayer", Player.class)
                    .setParameter(1, "Virat")
                    .setParameter(2, 1000012)
                    .executeUpdate();


            //different NamedNativeQueries on Player

            System.out.println("selectProduct Using createNamedQuery");
            Query query1 = entityManager.createNamedQuery("selectProduct", Product.class);
            query1.setParameter(1, 16);
            List list1 = query1.getResultList();
            list1.stream().forEach(System.out::println);


            System.out.println("<-----------Using NamedNativeQuery annotation for Product----------->");
            System.out.println("updateProduct Using createNamedQuery");
            entityManager.createNamedQuery("updateProduct", Product.class)
                    .setParameter(1, "Angular1")
                    .setParameter(2, 16)
                    .executeUpdate();



            System.out.println("deleteProduct Using createNamedQuery");
            entityManager.createNamedQuery("deleteProduct", Product.class)
                    .setParameter(1, "Angular")
                    .setParameter(2, 15)
                    .executeUpdate();


            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
