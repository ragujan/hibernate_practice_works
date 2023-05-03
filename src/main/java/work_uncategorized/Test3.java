package work_uncategorized;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        StatelessSession session1 = sessionFactory.openStatelessSession();

        Object o1  = session1.get(Teacher.class,1);
        Object o2  = session1.get(Teacher.class,1);
        Object o3  = session1.get(Teacher.class,1);
        Object o4  = session1.get(Teacher.class,1);

        session.get(Teacher.class,1);
        session.get(Teacher.class,1);
        session.get(Teacher.class,1);



    }
}
