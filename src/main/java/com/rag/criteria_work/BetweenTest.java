package com.rag.criteria_work;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BetweenTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = cb.createQuery((Teacher.class));
        Root<Teacher> root = query.from(Teacher.class);

        Predicate[] predicates = new Predicate[3];
        predicates[0] = cb.between(root.get("id"),10,18);
        predicates[1] = cb.equal(root.get("name"),"bro bro");
        predicates[2] = cb.equal(root.get("age"),"3");

        query.select(root).where(
               cb.between(
                       root.get("id"),1.0,10.55
               )
        );

        List<Teacher> teacher = session.createQuery(query).getResultList();
        teacher.forEach(e-> System.out.println(e.getId()));

    }
}
