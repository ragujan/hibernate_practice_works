package work_uncategorized;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionDetach {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Teacher teacher1 = session.get(Teacher.class,19);
        teacher1.setName("eminem taker bro 3339");
        session.merge(teacher1);
        session.detach(teacher1);
        transaction.commit();
    }
}
