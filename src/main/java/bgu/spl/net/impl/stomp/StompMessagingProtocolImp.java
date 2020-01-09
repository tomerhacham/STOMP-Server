package bgu.spl.net.impl.stomp;

import bgu.spl.net.api.StompMessagingProtocol;
import bgu.spl.net.api.messages.AbstractFrame;
import bgu.spl.net.srv.ConnectionHandler;
import bgu.spl.net.srv.Connections;

public class StompMessagingProtocolImp<T> implements StompMessagingProtocol<AbstractFrame> {
    private int connectionId;
    private Connections<AbstractFrame> connections;


    @Override
    public void start(int connectionId, Connections<AbstractFrame> connections) {
        this.connectionId=connectionId;
        this.connections=connections;
    }

    @Override
    public void process(AbstractFrame message, ConnectionHandler<AbstractFrame> connectionHandler, int connectionid) {
        message.setConnectionHandler(connectionHandler);
        message.setConnectionid(connectionid);
        AbstractFrame response = message.process(connections);
        connections.send(connectionId,response);
    }

    @Override
    public boolean shouldTerminate() {
        //TODO: implements

        return false;
    }
}
