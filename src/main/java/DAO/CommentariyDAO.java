package DAO;

import entity.Commentariy;

import java.util.List;

/**
 * Created by Администратор on 16.12.2015.
 */
public interface CommentariyDAO {
    public void saveComment(Commentariy com);
    public void deleteCommentById(Integer id);
    public Commentariy getCommentById(Integer id);
    public List<Commentariy> getCommentByUserId(Integer uaerId);
    public void updadeComment (Commentariy com);
    public List<Commentariy> getAllComment();
    }
