package entity;


public class Commentariy {
    private Integer CommentId;
    private User userAutor;
    private String description;

    public void setCommentId(Integer id) {
        this.CommentId = id;
    }

    public void setUserAutor(User userAutor) {
        this.userAutor = userAutor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCommentId() {
        return CommentId;
    }

    public User getUserAutor() {
        return userAutor;
    }

    public String getDescription() {
        return description;
    }
}
