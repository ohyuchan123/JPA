package jpa_study.com.mycom.myapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa_study.com.mycom.myapp.entity.Product;

public class Test {
    public static void main(String[] args) {
        // EntityManager
        // Entity <=> Table에 대응되는 자바 클래스, @Entity 가지는
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        // persistence context
        // em.getTransaction.begin()  -- 작업 -- ....commit(), close()

        try{
            em.getTransaction().begin();

            Product p = new Product();
            p.setId(1L);
            p.setName("Phone");

            // Entity 객체가 persistence context 안으로 들어 옵니다.
            em.persist(p);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
