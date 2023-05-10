package com.rag.pagination_work;

import com.rag.entity.Teacher;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        for (int i = 0; i < 100; i++) {
//            Teacher teacher = new Teacher();
//            teacher.setName("rag"+i);
//            teacher.setAge(i+0);
//            session.save(teacher);


        }

        transaction.commit();
        CriteriaBuilder cb = session.getCriteriaBuilder();

        List<Teacher> list = session.createQuery("SELECT s FROM Teacher s", Teacher.class)
                .setFirstResult(10)
                .setMaxResults(10).getResultList();


        list.forEach(teacher -> System.out.println(teacher.getName()));


        ScrollableResults scroll = session.createQuery("SELECT s FROM Teacher s", Teacher.class).scroll();
        //print all using scroll method
        while (scroll.next()) {
            Object[] objects = scroll.get();
            Teacher teacher1 = (Teacher) objects[0];
            System.out.println(teacher1.getName());
        }


        session.close();

    }
}
