package DAO;

import entity.Content;

import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 18.12.2015.
 */
public interface ContentDAO {

    public void addContent(Content content);
    public void remuveContentById(Integer id);
    public void updateContent(Content content);
    public Content getContentById(Integer id);
    public List<Content> getAllContent();

}
