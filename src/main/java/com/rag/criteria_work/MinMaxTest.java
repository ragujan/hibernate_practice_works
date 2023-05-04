package com.rag.criteria_work;

import com.rag.work_uncategorized.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MinMaxTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery((Integer.class));
        Root<Teacher> root = query.from(Teacher.class);



        query.select(cb.min(root.get("id")));

        Integer min = session.createQuery(query).getSingleResult();
        System.out.println("min is "+min);

        query.select(cb.max(root.get("id")));

        Integer max = session.createQuery(query).getSingleResult();
        System.out.println("max is "+max);

    }
}
