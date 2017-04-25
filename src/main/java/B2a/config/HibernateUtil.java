package B2a.config;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory factory;
    public static Configuration

    getInitializedConfiguration() {
        Configuration config =
                new Configuration();
        return config;
    }

    public static Session getSession() {
        if (factory == null) {
            Configuration config =
                    HibernateUtil.getInitializedConfiguration();
            factory = config.buildSessionFactory();
        }
        Session hibernateSession =
                factory.getCurrentSession();
        return hibernateSession;
    }

    public static void closeSession() {
        HibernateUtil.getSession().close();
    }

    public static Session beginTransaction() {
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        HibernateUtil.getSession()
                .getTransaction().commit();
    }

    public static void rollbackTransaction() {
        HibernateUtil.getSession()
                .getTransaction().rollback();
    }


}
