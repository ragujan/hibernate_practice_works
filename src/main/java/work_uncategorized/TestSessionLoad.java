package work_uncategorized;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

public class TestSessionLoad {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        StatelessSession session1 = sessionFactory.openStatelessSession();

        Teacher o1  = session.load(Teacher.class,1);
        Teacher o2  = session.load(Teacher.class,1);
        Teacher o3  = session.load(Teacher.class,1);
        Teacher o4  = session.load(Teacher.class,1);
        System.out.println("just right after here");
        System.out.println(o1.getName());
        System.out.println("before");
        System.out.println(o2.getName());
        System.out.println(o3.getName());



    }
}
