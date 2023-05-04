package com.rag.criteria_work;

import com.rag.work_uncategorized.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestIn {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);

//        CriteriaBuilder.In<Teacher> inCluase = cb.in(root.get("id"));
//        inCluase.value(9);
//        inCluase.value(10);
//        inCluase.value(11);
        query.select(root).where(root.get("id").in(9,10,11));

//        query.select(root).where(inCluase);

        List<Teacher> teachers = session.createQuery(query).getResultList();

        teachers.forEach(e -> System.out.println(e.getAge()));


    }
}
