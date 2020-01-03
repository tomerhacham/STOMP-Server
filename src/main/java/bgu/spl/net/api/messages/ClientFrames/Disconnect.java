package bgu.spl.net.api.messages.ClientFrames;

import bgu.spl.net.api.messages.AbstractFrame;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Disconnect extends AbstractFrame {
    public Disconnect(String receipt) {
        super("DISCONNECT");
        Pair<String,String> accept_version_header = new Pair<>("receipt:",receipt);

        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(accept_version_header);
        super.setHeaders(headers);;
    }
}
