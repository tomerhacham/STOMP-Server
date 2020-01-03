package bgu.spl.net.api.messages.ClientFrames;

import bgu.spl.net.api.messages.AbstractFrame;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Unsbscribe extends AbstractFrame {
    public Unsbscribe(String id) {
        super("UNSUBSCRIBE");
        Pair<String,String> id_header = new Pair<>("id:",id);
        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(id_header);
        super.setHeaders(headers);;
    }
}
