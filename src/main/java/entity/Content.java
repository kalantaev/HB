package entity;

import java.util.List;

/**
 * Created by Администратор on 16.12.2015.
 */
public class Content {
    private Integer contentId;
    private String title;
    private String contentDescription;
    private List<User> listContentAutor;
    private List<Commentariy> commentariyList;

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }



    public void setCommentariyList(List<Commentariy> commentariyList) {
        this.commentariyList = commentariyList;
    }

    public Integer getContentId() {
        return contentId;
    }

    public String getTitle() {
        return title;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setListContentAutor(List<User> listContentAutor) {
        this.listContentAutor = listContentAutor;
    }

    public List<User> getListContentAutor() {

        return listContentAutor;
    }

    public List<Commentariy> getCommentariyList() {
        return commentariyList;
    }
}
