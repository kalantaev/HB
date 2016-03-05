package entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")

public class Commentariy {

    private Integer CommentId;
    private User userAutor;
    private Content content;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    public Integer getCommentId() {
        return CommentId;
    }

    public void setCommentId(Integer id) {
        this.CommentId = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getUserAutor() {
        return userAutor;
    }

    public void setUserAutor(User userAutor) {
        this.userAutor = userAutor;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    public Content getContent() {

        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
