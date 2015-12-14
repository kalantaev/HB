package entity;

import java.util.Date;
import java.util.List;


//@Entity
//@Table(name = "user2")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
    private Integer userId;
//    @Column(name = "login")
    private String login;

    private String password;

    private List<Commentariy> commentariyList;

    private Date dateReg;

    private Date dateLastVisit;

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
