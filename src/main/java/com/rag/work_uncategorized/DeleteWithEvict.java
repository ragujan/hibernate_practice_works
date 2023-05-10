package com.rag.work_uncategorized;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteWithEvict {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Teacher teacher = session.get(Teacher.class, 42);
        session.evict(teacher);
        System.out.println("bro rag");
//        session.save(teacher);

        teacher.setName("ragjn");
        System.out.println("show rag");
        session.update(teacher);
        transaction.commit();
        session.close();



    }
}
