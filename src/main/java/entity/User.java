package entity;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "userAutor")
    private List<Commentariy> commentariyList;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "content_id"))
    private Set<Content> contentList;
    @Column(name = "dateReg")
    private Date dateReg;
    @Column(name = "dateLastVizit")
    private Date dateLastVisit;

    public void setContentList(Set<Content> contentList) {
        this.contentList = contentList;
    }

    public Set<Content> getContentList() {

        return contentList;
    }

    public void setCommentariyList(List<Commentariy> commentariyList) {
        this.commentariyList = commentariyList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public void setDateLastVisit(Date dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Commentariy> getCommentariyList() {
        return commentariyList;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public Date getDateLastVisit() {
        return dateLastVisit;
    }
}
