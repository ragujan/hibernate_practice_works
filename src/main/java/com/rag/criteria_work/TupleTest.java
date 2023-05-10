package com.rag.criteria_work;

import com.rag.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TupleTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createTupleQuery();
        Root<Teacher> root = query.from(Teacher.class);



        query.multiselect(
                root.get("name").alias("name"),
                root.get("age").alias("age")
        );

        List<Tuple> resultList = session.createQuery(query).getResultList();

        for (Tuple tuple:resultList
             ) {

            System.out.println("name "+ tuple.get("name")+" age "+tuple.get("age"));
        }


    }
}
