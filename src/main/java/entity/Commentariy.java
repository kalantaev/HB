package entity;


public class Commentariy {
    private Integer CommentId;
    private User userAutor;
    private Content content;
    private String description;

    public void setContent(Content content) {
        this.content = content;
    }

    public Content getContent() {

        return content;
    }

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
