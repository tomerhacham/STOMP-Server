package bgu.spl.net.impl.stomp;

import bgu.spl.net.api.StompMessagingProtocol;
import bgu.spl.net.srv.Connections;

public class StompMessagingProtocolImp<A> implements StompMessagingProtocol {
    @Override
    public void start(int connectionId, Connections<String> connections) {
        //TODO: implements
    }

    @Override
    public void process(String message) {
        //TODO: implements

    }

    @Override
    public boolean shouldTerminate() {
        //TODO: implements

        return false;
    }
}
