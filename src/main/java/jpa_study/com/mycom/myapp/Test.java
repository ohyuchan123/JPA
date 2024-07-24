package jpa_study.com.mycom.myapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa_study.com.mycom.myapp.config.MyPersistenceUnitInfo;
import jpa_study.com.mycom.myapp.entity.Product;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // xml 대신 자바 설정 객체
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManagerFactory emf =
                new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                    new MyPersistenceUnitInfo(), new HashMap<>()
                );
        EntityManager em = emf.createEntityManager();

        // persistence context
        // em.getTransaction.begin()  -- 작업 -- ....commit(), close()

        try{
            em.getTransaction().begin();

            Product p = new Product();
            p.setId(2L);
            p.setName("Book");

            // Entity 객체가 persistence context 안으로 들어 옵니다.
            em.persist(p);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
