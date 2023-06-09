package com.rag.criteria_work;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestInChain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//test 6
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery(Teacher.class);
        Root<Teacher> root = query.from(Teacher.class);


        query.select(root).where(cb.between(root.get("id"), 1, 10)).where(cb.equal(root.get("name"), "rag3"));


        List<Teacher> teachers = session.createQuery(query).getResultList();

        teachers.forEach(e -> System.out.println(e.getAge()));


    }
}
