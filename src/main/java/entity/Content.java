package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "content")
public class Content {

    private Integer contentId;
    private String title;
    private String contentDescription;
    private List<User> listContentAutor;
    private List<Commentariy> commentariyList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "content_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getListContentAutor() {

        return listContentAutor;
    }

    public void setListContentAutor(List<User> listContentAutor) {
        this.listContentAutor = listContentAutor;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "content")
    public List<Commentariy> getCommentariyList() {
        return commentariyList;
    }

    public void setCommentariyList(List<Commentariy> commentariyList) {
        this.commentariyList = commentariyList;
    }
}
