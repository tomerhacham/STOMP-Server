package bgu.spl.net.impl;

public class User {

    //Fields:
    private final Integer id;
    private boolean loggin; //indicate if the user is log in

    public User(Integer id) {
        this.id = id;
        loggin=false;
    }

    public Integer getId() {
        return id;
    }
    public void login(){loggin=true;}
    public void logout(){loggin=false;}

}
