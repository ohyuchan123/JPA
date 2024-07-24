package jpa_study.com.mycom.myapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa_study.com.mycom.myapp.config.MyPersistenceUnitInfo;
import jpa_study.com.mycom.myapp.entity.Employee;
import jpa_study.com.mycom.myapp.entity.Product;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show.sql","true")

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

//            Product p = new Product();
//            p.setId(2L);
//            p.setName("Book");
            // Entity 객체가 persistence context 안으로 들어 옵니다.
//            em.persist(p);

            // persist() => Entity 객체가 Persistence context 안으로 들어 온다.
            // DB의 특정 row를 persistence context 안으로 들어 오게 한다. Entity 객체로 표햔
            {
//                Employee e1 = em.find(Employee.class, 1);
//                System.out.println(e1);
            }

            {
//                Employee e1 = em.find(Employee.class, 1);
//                e1.setId(1);
//                e1.setAddress("광주 어디");
//                System.out.println(e1);
            }

            {
//                Employee e1 = em.find(Employee.class, 1);
//                e1.setAddress("부산 어디");
//                e1.setAddress("광주 어디");
//                System.out.println(e1);
            }

            {
//                Employee e1 = em.find(Employee.class, 2);
//                e1.setId(2);
//                e1.setAddress("강원 어디");
//                System.out.println(e1);
//
//                em.persist(e1); // Duplicate entry '2' for key ...
//                em.merge(e1); // 있으면 update 수행
            }

            {
                Employee e1 = new Employee();
                e1.setId(3);
                e1.setAddress("충청 어디");
                System.out.println(e1);

//                em.persist(e1); // insert
                em.merge(e1); // 없으면 insert 수행
            }

            em.getTransaction().commit(); //update tngod
        }finally {
            em.close();
        }
    }
}
