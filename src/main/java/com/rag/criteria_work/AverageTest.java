package com.rag.criteria_work;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AverageTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Double> query = cb.createQuery((Double.class));
        Root<Teacher> root = query.from(Teacher.class);



        query.select(cb.avg(root.get("id")));

        Double average = session.createQuery(query).getSingleResult();
        System.out.println("average is "+average);


       
    }
}
