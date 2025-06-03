package dbataev.model;

public class Users {
    private int id;
    private String login;
    private String pwd;

    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPwd() {
        return pwd;
    }
}
