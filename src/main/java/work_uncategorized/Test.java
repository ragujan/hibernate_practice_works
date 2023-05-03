package work_uncategorized;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(30);
        session.save(employee);
        Teacher teacher = new Teacher();
        teacher.setAge(33);
        teacher.setName("rag");
        session.save(teacher);
        transaction.commit();
        session.close();

    }
}
