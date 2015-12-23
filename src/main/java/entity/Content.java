package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer contentId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String contentDescription;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "content_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> listContentAutor;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "content")
    private List<Commentariy> commentariyList;

    public Content(){}

    public void setListContentAutor(List<User> listContentAutor) {
        this.listContentAutor = listContentAutor;
    }

    public List<User> getListContentAutor() {

        return listContentAutor;
    }

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



    public List<Commentariy> getCommentariyList() {
        return commentariyList;
    }
}
