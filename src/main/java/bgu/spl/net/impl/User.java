package bgu.spl.net.impl;

public class User {

    //Fields:
    private final Integer id;
    private String Password;
    private String UserName;
    private boolean loggin; //indicate if the user is log in

    public User(Integer id, String password, String userName) {
        this.id = id;
        loggin=false;
        this.Password=password;
        this.UserName=userName;
    }

    public Integer getId() {
        return id;
    }
    public void login(){loggin=true;}
    public void logout(){loggin=false;}
    public boolean isLoggin(){return this.loggin;}
    public String getPassword(){ return this.Password; }
    public String getUserName() {
        return this.UserName;
    }
}
