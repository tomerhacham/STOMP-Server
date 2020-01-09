package bgu.spl.net.srv;

import bgu.spl.net.impl.User;

import java.io.IOException;

public interface Connections<T> {

    boolean send(int connectionId, T msg);

    void send(String channel, T msg);

    void disconnect(int connectionId);

    //region my addition
    public User getUserbyConnectionId(Integer connectionId);

    public void register(String username, String pass, ConnectionHandler connectionHandler, int connectionid);

    public boolean login(String username, String password, ConnectionHandler connectionHandler, int connectionid);

    public boolean isRegister(String username);

    public void subscribe(int connectionid, String genre);

    public void unsubscribe(int connectionid,String genre);
    //endregion
}
