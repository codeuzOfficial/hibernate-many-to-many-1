package dasturlash.uz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        // courses
        CourseEntity math = new CourseEntity();
        math.setTitle("Math");
        math.setDuration(6);
        session.save(math);

        CourseEntity java = new CourseEntity();
        java.setTitle("Java");
        java.setDuration(10);
        session.save(java);

        CourseEntity english = new CourseEntity();
        english.setTitle("English");
        english.setDuration(6);
        session.save(english);
        // students
        StudentEntity student1 = new StudentEntity();
        student1.setName("Alish");
        student1.setSurname("Aliyev");
        student1.setCourseSet(Set.of(math, java, english));
        session.save(student1);

        StudentEntity student2 = new StudentEntity();
        student2.setName("Valish");
        student2.setSurname("Valiyev");
        student2.setCourseSet(Set.of(math, english));
        session.save(student2);

        StudentEntity student3 = new StudentEntity();
        student3.setName("Toshmat");
        student3.setSurname("Toshmatov");
        student3.setCourseSet(Set.of(math, java));
        session.save(student3);

        t.commit();

        factory.close();
        session.close();
    }
}