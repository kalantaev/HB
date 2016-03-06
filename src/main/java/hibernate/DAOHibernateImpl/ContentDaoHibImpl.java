package hibernate.DAOHibernateImpl;

import DAO.ContentDAO;
import entity.Content;
import hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class ContentDaoHibImpl implements ContentDAO {
    public void addContent(Content content) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(content);
        session.getTransaction().commit();
        session.close();
    }

    public void remuveContentById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Content content = (Content) session.get(Content.class,id);
        session.delete(content);
        session.close();
    }

    public void updateContent(Content content) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(content);
        session.close();
    }

    public Content getContentById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Content content = (Content) session.get(Content.class,id);
        session.close();
        return content;
    }

    public List<Content> getAllContent() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Content> contents = null;
        contents = (List<Content>) session.createQuery("from Content").list();

        session.close();
        return contents;
    }
}
