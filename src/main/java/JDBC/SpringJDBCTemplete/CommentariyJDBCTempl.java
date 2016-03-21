package JDBC.SpringJDBCTemplete;

import DAO.CommentariyDAO;
import entity.Commentariy;

import java.util.List;

/**
 * Created by Администратор on 20.03.2016.
 */
public class CommentariyJDBCTempl implements CommentariyDAO {
    @Override
    public void saveComment(Commentariy com) {

    }

    @Override
    public void deleteCommentById(Integer id) {

    }

    @Override
    public Commentariy getCommentById(Integer id) {
        return null;
    }

    @Override
    public List<Commentariy> getCommentByUserId(Integer uaerId) {
        return null;
    }

    @Override
    public List<Commentariy> getCommentByContentId(Integer contId) {
        return null;
    }

    @Override
    public void updadeComment(Commentariy com) {

    }

    @Override
    public List<Commentariy> getAllComment() {
        return null;
    }
}
