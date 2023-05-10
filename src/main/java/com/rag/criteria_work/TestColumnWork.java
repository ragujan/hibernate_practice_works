package com.rag.criteria_work;

import com.rag.work_uncategorized.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TestColumnWork {
//    test 7
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery((String.class));
        CriteriaQuery<Object[]> queryStringArray = cb.createQuery((Object[].class));
        Root<Teacher> root = query.from(Teacher.class);
        Root<Teacher> rootArray = queryStringArray.from(Teacher.class);


        query.select(root.get("name"));

        List<String> teachers = session.createQuery(query).getResultList();
        teachers.forEach(e -> System.out.println(e));

        queryStringArray.multiselect(
                rootArray.get("name"),
                rootArray.get("age")
        );

        List<Object[]> multiSelectResults = session.createQuery(queryStringArray).getResultList();
        multiSelectResults.forEach(e-> System.out.println("name is "+e[0]+" age is "+e[1]));


    }
}
