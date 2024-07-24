package jpa_study.com.mycom.myapp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        // EntityManager
        // Entity <=> Table에 대응되는 자바 클래스, @Entity 가지는
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    }
}
