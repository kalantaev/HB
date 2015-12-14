package entity;


public class Commentariy {
    private Integer id;
    private User userAutor;
    private String description;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserAutor(User userAutor) {
        this.userAutor = userAutor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public User getUserAutor() {
        return userAutor;
    }

    public String getDescription() {
        return description;
    }
}
