package entity;




import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")

public class User {

    private Integer userId;
    @Size(min = 5, message = "Login должен быть не менее 5 символов")
    private String login;
    @Size(min = 5, max = 20, message = "Пароль должен быть от 5 до 20 знаков")
    private String password;
    private List<Commentariy> commentariyList;
    private List<Content> contentList;
    private Date dateReg;
    private Date dateLastVisit;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "userAutor")
    public List<Commentariy> getCommentariyList() {
        return commentariyList;
    }

    public void setCommentariyList(List<Commentariy> commentariyList) {
        this.commentariyList = commentariyList;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "content_id"))
    public List<Content> getContentList() {
        if (contentList!=null){
        return contentList;}
        else {
            return new ArrayList<Content>();
        }
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    @Column(name = "dateReg")
    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    @Column(name = "dateLastVizit")
    public Date getDateLastVisit() {
        return dateLastVisit;
    }

    public void setDateLastVisit(Date dateLastVisit) {
        this.dateLastVisit = dateLastVisit;
    }

}
