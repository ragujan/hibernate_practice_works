package com.rag.delete_work;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.rag.work_uncategorized.Teacher;

public class WithEvict {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        work_uncategorized.Teacher teacher = new work_uncategorized.Teacher();
        Teacher teacher = session.get(Teacher.class, 42);
//        teacher.setId(38);
        session.delete(teacher);
        teacher.setName("babar");
        session.save(teacher);

        transaction.commit();
        session.close();

    }
}
