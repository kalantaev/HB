package DAO;

import entity.Commentariy;

import java.util.List;


public interface CommentariyDAO {
    public void saveComment(Commentariy com);
    public void deleteCommentById(Integer id);
    public Commentariy getCommentById(Integer id);
    public List<Commentariy> getCommentByUserId(Integer uaerId);
    public List<Commentariy> getCommentByContentId(Integer contId);
    public void updadeComment (Commentariy com);
    public List<Commentariy> getAllComment();
    }
