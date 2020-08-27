package pl.sda.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Function;

public class EntityMenagerProvider {

    private static final EntityManagerFactory entityMenagerFactory =
            Persistence.createEntityManagerFactory("pl.sda.twitter");

    public  static EntityManager getEmntityMenager() {
        return entityMenagerFactory.createEntityManager();
    }

//    public static <T> T executeInTransaction(Function<EntityManager, T> task) {
//        try {
//            EntityManager em = getEmntityMenager();
//            em.getTransaction().begin();
//            T var = task.apply(em);
//        } catch (Exception e) {
//            throw  new RuntimeException("Błąd połącznia z bazą", e);
//        }
//
//    } magic trick to finish
}
