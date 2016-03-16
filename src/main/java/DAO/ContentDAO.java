package DAO;

import entity.Content;

import java.util.List;


public interface ContentDAO {

    public void addContent(Content content);
    public void remuveContentById(Integer id);
    public void updateContent(Content content);
    public Content getContentById(Integer id);
    public List<Content> getAllContent();

}
