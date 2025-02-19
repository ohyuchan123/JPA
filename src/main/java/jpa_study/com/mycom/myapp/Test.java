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
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update");  // create (항상 새로 만든다), update(없으면 만들고, 있으면 변경되어야 하면 변경)
        // hbm2ddl <= Hibernate Mapping to(2) DDL

        // xml 대신 자바 설정 객체
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManagerFactory emf =
                new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                    new MyPersistenceUnitInfo(), props
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
//                Employee e1 = new Employee();
//                e1.setId(3);
//                e1.setAddress("충청 어디");
//                System.out.println(e1);
//
////                em.persist(e1); // insert
//                em.merge(e1); // 없으면 insert 수행
            }

            // sql_확인
			{
//				Employee e1 = new Employee();
//				e1.setId(1);
//				e1.setName("홍길동");
//				e1.setAddress("서울 어디");
//				em.persist(e1);
			}
			{
//				Employee e1 = em.find(Employee.class, 1);
//				System.out.println(e1);
			}

			{
//				Employee e1 = new Employee();
//				e1.setId(1);
//				e1.setName("홍길동");
//				e1.setAddress("서울 어디");
//				em.persist(e1);
//
//				System.out.println(e1);
//
//				// delay
//				try {
//					Thread.sleep(10000);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
			}

			{
//				Employee e1 = em.find(Employee.class, 1);
//				e1.setAddress("제주 어디");
//				System.out.println(e1);
//
//				// delay
//				try {
//					Thread.sleep(10000);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
			}

            // create, update 설정으로 현재 employee table empty
            {
//                Employee e1 = em.find(Employee.class, 1);
//                System.out.println(e1);
//
//                e1 = new Employee();
//                e1.setId(1);
//                e1.setName("홍길동");
//                e1.setAddress("서울 어디");
//                em.persist(e1);
//
//                e1 = em.find(Employee.class, 1);
//                // find()는 persistence context에 있으면 거기서 찾는다. 없으면 DB에서 가져온다.
//                System.out.println(e1);
            }

            // getReference()
            // 현재 DB 1건 employee 데이터 존재
            {

                // find()는 즉각 실행
                // getReference() 사용될 때 실행
//                Employee e1 = em.getReference(Employee.class,1);
//                e1.setName("이길동");
//
//                try {
//					Thread.sleep(10000);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//
//                System.out.println(e1);
            }

            // remove
            {
//                Employee e1 = em.find(Employee.class, 1);
//
//                em.remove(e1);
//                try {
//					Thread.sleep(10000);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//
//                System.out.println(e1);
            }

            //refresh
            {
                Employee e1 = em.find(Employee.class, 1);
                //refresh 전, 주소 변경
                e1.setAddress("아까 거기");

                System.out.println(e1);

                try {
					Thread.sleep(10000);
				}catch(Exception e) {
					e.printStackTrace();
				}
                em.refresh(e1);

                // refresh 후
                System.out.println(e1); // select 수행으로 객체 <- table
            }

            em.getTransaction().commit(); //update tngod
        }finally {
            em.close();
        }
    }
}
