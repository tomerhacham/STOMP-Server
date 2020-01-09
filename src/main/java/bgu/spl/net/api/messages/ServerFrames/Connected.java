package bgu.spl.net.api.messages.ServerFrames;

import bgu.spl.net.api.messages.AbstractFrame;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Connected extends AbstractFrame {
    public Connected(String version,String user_id) {
        super("CONNECTED");
        Pair<String,String> version_header = new Pair<>("version:",version);
        Pair<String,String> userid_header = new Pair<>("id:",user_id);
        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(version_header);
        super.setHeaders(headers);;

    }
}
