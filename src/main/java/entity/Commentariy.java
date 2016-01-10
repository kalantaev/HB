package entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")

public class Commentariy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer CommentId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userAutor;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private Content content;
    @Column(name = "description")
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
