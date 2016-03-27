package ru.hibernate.DAOHibernateImpl;

import DAO.CommentariyDAO;
import entity.Commentariy;
import org.springframework.stereotype.Service;
import ru.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentariyDaoHibImpl implements CommentariyDAO {
    public void saveComment(Commentariy com) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(com);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCommentById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Commentariy coment = (Commentariy) session.get(Commentariy.class,id);
        session.delete(coment);
        session.getTransaction().commit();
        session.close();
    }

    public Commentariy getCommentById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Commentariy commentariy = (Commentariy) session.get(Commentariy.class,id);
        session.close();
        return commentariy;
    }

    public void updadeComment(Commentariy com) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(com);
        session.close();
    }

    public List<Commentariy> getCommentByUserId(Integer uaerId) {
        List<Commentariy> commentariys = new ArrayList<Commentariy>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        commentariys = (List<Commentariy>)session.createQuery("from Commentariy  where userAutor ="+uaerId).list();
        session.close();
        return commentariys;
    }

    @Override
    public List<Commentariy> getCommentByContentId(Integer contId) {
        List<Commentariy> commentariys = new ArrayList<Commentariy>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        commentariys = (List<Commentariy>)session.createQuery("from Commentariy  where content ="+contId).list();
        session.close();
        return commentariys;
    }

    public List<Commentariy> getAllComment() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Commentariy> commentariys = new ArrayList<Commentariy>();
        commentariys = (List<Commentariy>) session.createQuery("from Commentariy ").list();
        session.close();

        int i=5;
        i+=i;
        i++;

        return commentariys;
    }
}

