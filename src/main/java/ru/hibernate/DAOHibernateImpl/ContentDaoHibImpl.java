package ru.hibernate.DAOHibernateImpl;

import DAO.ContentDAO;
import entity.Content;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.hibernate.HibernateUtil;
import org.hibernate.Session;
import ru.util.ClassName;

import java.util.List;

@Service
public class ContentDaoHibImpl implements ContentDAO {
    private static final Logger log = Logger.getLogger(ClassName.getClassName());

    public void addContent(Content content) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(content);
        session.getTransaction().commit();
        session.close();
    }

    public void remuveContentById(Integer id) {
        log.info("вызван метод для удаления контента с id " + id);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Content content = (Content) session.get(Content.class,id);
        session.delete(content);
        session.getTransaction().commit();
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
