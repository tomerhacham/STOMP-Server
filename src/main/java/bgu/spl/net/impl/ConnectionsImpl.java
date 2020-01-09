package bgu.spl.net.impl;

import bgu.spl.net.srv.ConnectionHandler;
import bgu.spl.net.srv.Connections;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConnectionsImpl<T> implements Connections<T> {
    //Fields:
    ConcurrentMap<Integer, ConnectionHandler> users_connections; //connection_id to connectionHandler
    ConcurrentHashMap<String, List<Integer>> Channel_User;
    ConcurrentHashMap<String, User> name_user;// username to user object
    ConcurrentHashMap<Integer, User> connectionid_user; //conenctionId to user object


    public ConnectionsImpl(){
        users_connections = new ConcurrentHashMap<>();
        Channel_User= new ConcurrentHashMap<>();
        name_user= new ConcurrentHashMap<>();
    }

    @Override
    public boolean send(int connectionId, T msg) {//TODO: to check which param we send back
        if(users_connections.containsKey(connectionId)) {
            users_connections.get(connectionId).send(msg);
            return true;
        }
        return false;
    }

    @Override
    public void send(String channel, T msg) {
        if (Channel_User.contains(channel)) {
            List<Integer> userChannel = Channel_User.get(channel);
            for (Integer id : userChannel) {
                users_connections.get(id).send(msg);
            }
        }
    }

    @Override
    public void disconnect(int connectionId) {
        if(users_connections.keySet().contains(connectionId)){
            users_connections.remove(connectionId);
            connectionid_user.get(connectionId).logout();
        }
    }

    public User getUserbyConnectionId(Integer connectionId){
        return this.connectionid_user.get(connectionId);
    }

    public void register(String username, String pass, ConnectionHandler connectionHandler, int connectionid){
        User user= new User(pass, username);
        name_user.put(username,user);
        users_connections.put(connectionid,connectionHandler);
        connectionid_user.put(connectionid,user);

    }
    
    public boolean login(String username, String password, ConnectionHandler connectionHandler, int connectionid){
        if(isRegister(username)){
            User user= name_user.get(username);
            if(user.getPassword().equals(password)) {
                users_connections.put(connectionid, connectionHandler);
                connectionid_user.put(connectionid,user);
                user.setConnectionId(connectionid);
                return true;
            }
            else {return false;}
        }
        else {
            register(username, password, connectionHandler, connectionid);
            return true;
        }
    }

    public boolean isRegister(String username){
        return name_user.contains(username);
    }
    
    public void subscribe(int connectionid, String genre){
        if(Channel_User.containsKey(genre)){
            Channel_User.get(genre).add(connectionid);
        }
    }

    public void unsubscribe(int connectionid,String genre){
        if(Channel_User.keySet().contains(genre)){
            if(Channel_User.get(genre).contains(connectionid)){
                Channel_User.get(genre).remove(connectionid);
            }
        }
    }

}
