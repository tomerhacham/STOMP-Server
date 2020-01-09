package bgu.spl.net.impl;

public class User {



    //Fields:
    private  Integer connectionId;
    private String Password;
    private String UserName;
    private boolean loggin; //indicate if the user is log in

    public User(String password, String userName) {
        loggin=false;
        this.Password=password;
        this.UserName=userName;
    }

    public Integer getConnectionId() {
        return connectionId;
    }
    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }
    public void login(){loggin=true;}
    public void logout(){loggin=false;}
    public boolean isLoggin(){return this.loggin;}
    public String getPassword(){ return this.Password; }
    public String getUserName() {
        return this.UserName;
    }
}
