package query_works;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import work_uncategorized.Teacher;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Teacher> q = session.createQuery("SELECT s from Teacher s",Teacher.class);

        List<Teacher> result = q.getResultList();
        for (Teacher teacher: result
             ) {
            System.out.println(teacher.getName());
        }

    }
}
