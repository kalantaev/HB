package DAO;

import entity.Commentariy;

import java.util.List;

/**
 * Created by Администратор on 16.12.2015.
 */
public interface CommentariyDAO {
    public void saveComment(Commentariy com);
    public void deleteCommentById(Integer id);
    public Commentariy getCommentByUserId(Integer id);
    public void updadeComment (Commentariy com);
    public List<Commentariy> getCommentListByUserId(Integer Id);
    }
