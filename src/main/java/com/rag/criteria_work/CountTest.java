package com.rag.criteria_work;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CountTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery((Long.class));
        Root<Teacher> root = query.from(Teacher.class);



        query.select(cb.count(root.get("id")));

        List<Long> lng  = session.createQuery(query).getResultList();
        Long count  = session.createQuery(query).getSingleResult();
        System.out.println("count is "+count);
        System.out.println(lng.get(0));

    }
}
