package bgu.spl.net.impl;

import bgu.spl.net.srv.ConnectionHandler;
import bgu.spl.net.srv.Connections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConnectionsImpl<T> implements Connections<T> {
    //Fields:
    ConcurrentMap<Integer, ConnectionHandler> users_connections;

    public ConnectionsImpl(){
        users_connections = new ConcurrentHashMap<>();
    }

    @Override
    public boolean send(int connectionId, T msg) {
        return false;
    }

    @Override
    public void send(String channel, T msg) {

    }

    @Override
    public void disconnect(int connectionId) {
        if(users_connections.keySet().contains(connectionId)){
            users_connections.remove(connectionId,users_connections.get(connectionId));
        }
    }
}
