package com.rag.query_work;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.rag.entity.Teacher;

import java.util.List;

public class TestNamedQuery {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Teacher> q = session.createNamedQuery("Teacher.getAll",Teacher.class);

        List<Teacher> result = q.getResultList();
        for (Teacher teacher: result
             ) {
            System.out.println(teacher.getName());
        }

    }
}
