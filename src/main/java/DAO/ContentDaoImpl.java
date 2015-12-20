package DAO;

import entity.Content;
import entity.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 18.12.2015.
 */
public class ContentDaoImpl implements ContentDAO {
    public void addContent(Content content) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(content);
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
