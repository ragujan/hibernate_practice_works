package com.rag.work_uncategorized;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Teacher teacher = session.find(Teacher.class,1);
        System.out.println(teacher.getName());

        try {

            Thread.sleep(1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        session.clear();
        Teacher teacher1 = session.find(Teacher.class,1);
        System.out.println(teacher1.getName());
        System.out.println(session.isOpen());
        Session session2  = sessionFactory.getCurrentSession();
        System.out.println(session2);

    }
}
