package com.rag.work_uncategorized;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DetachFromUpdate {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Teacher teacher = session.get(Teacher.class, 42);
        teacher.setName("morris");
        System.out.println("name is set");
        session.evict(teacher);
        System.out.println("teacher is evicted ");
//        session.save(teacher);
        teacher.setName("chinto");
        System.out.println("teacher name is set again at eviction state");
        session.update(teacher);
        System.out.println("update is called again");
        transaction.commit();
        session.close();



    }
}
