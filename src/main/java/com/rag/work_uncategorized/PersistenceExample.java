package com.rag.work_uncategorized;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersistenceExample {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();
        teacher3.setName("marshall");
        teacher2.setName("bro rag");
        System.out.println(teacher3.getId());
//        session.persist(teacher3);
        session.save(teacher2);
        System.out.println(teacher2.getId());
        transaction.commit();
        System.out.println(teacher3.getId());

//        transaction.rollback();
    }
}
