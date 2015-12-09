package entity;

/**
 * Created by Администратор on 09.12.2015.
 */
public class User {

    private Integer id;
    private String login;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
