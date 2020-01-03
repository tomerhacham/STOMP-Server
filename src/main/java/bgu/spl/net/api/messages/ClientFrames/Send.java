package bgu.spl.net.api.messages.ClientFrames;

import bgu.spl.net.api.messages.AbstractFrame;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Send extends AbstractFrame {
    public Send(String destination, String body) {
        super("SEND");
        Pair<String,String> destination_header = new Pair<>("destination:",destination);
        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(destination_header);
        super.setHeaders(headers);;
        super.setBody(body);
    }
}
