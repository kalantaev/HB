package ru.DAO;

import ru.entity.Commentariy;

import java.util.List;


public interface CommentariyDAO {
    void saveComment(Commentariy com);
    void deleteCommentById(Integer id);
    Commentariy getCommentById(Integer id);
    List<Commentariy> getCommentByUserId(Integer uaerId);
    List<Commentariy> getCommentByContentId(Integer contId);
    void updadeComment(Commentariy com);
    List<Commentariy> getAllComment();
    }
