package work_uncategorized;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateInsert {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Teacher teacher1 = new Teacher();
        teacher1.setName("eminem taker 22");
        Teacher existingTeacher = session.get(Teacher.class,19);
        existingTeacher.setName("shaun kingston");
        session.update(existingTeacher);
        transaction.commit();
    }
}
