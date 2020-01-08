package bgu.spl.net.impl;

import bgu.spl.net.srv.ConnectionHandler;
import bgu.spl.net.srv.Connections;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConnectionsImpl<T> implements Connections<T> {
    //Fields:
    ConcurrentMap<Integer, ConnectionHandler> users_connections;
    ConcurrentHashMap<String, List<Integer>> Channel_User;
    ConcurrentHashMap<Integer, User> User_Id;
    ConcurrentHashMap<String, User> User_Name;
    Integer NextId=1;

    public ConnectionsImpl(){
        users_connections = new ConcurrentHashMap<>();
        Channel_User= new ConcurrentHashMap<>();
        User_Id= new ConcurrentHashMap<>();
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
            users_connections.remove(connectionId,users_connections.get(connectionId));
            User_Id.get(connectionId).logout();
        }
    }

    public User getUserById(Integer id){
        return this.User_Id.get(id);
    }

    public void register(String username, String pass, ConnectionHandler connectionHandler){
        User user= new User(getNextId() ,pass, username);
        User_Id.put(user.getId(),user);
        User_Name.put(user.getUserName(), user);
        user.login();
        users_connections.put(user.getId(), connectionHandler);
    }
    
    public boolean logIn(String username, String password, ConnectionHandler connectionHandler){
        if(isRegister(username)){
            int userId= User_Name.get(username).getId();
            User user= User_Name.get(username);
            if(user.getPassword().equals(password)) {
                users_connections.put(userId, connectionHandler);
                return true;
            }
            else {return false;}
        }
        else {
            register(username, password, connectionHandler);
            return true;
        }
    }

    private boolean isRegister(String username){
        return User_Name.contains(username);
    }
    
    public void subscribe(int user_id, String genre){
        if(Channel_User.containsKey(genre)){
            Channel_User.get(genre).add(user_id);
        }
    }

    public void unsubscribe(int user_id,String genre){
        if(Channel_User.keySet().contains(genre)){
            if(Channel_User.get(genre).contains(user_id)){
                Channel_User.get(genre).remove(user_id);
            }
        }
    }
        
    private int getNextId(){
        int id= NextId;
        NextId++;
        return id;
    }


}
