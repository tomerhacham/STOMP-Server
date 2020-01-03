package bgu.spl.net.api.messages;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Message extends AbstractFrame{
    public Message(String subscription, String messageId, String destination, String body) {
        super("MESSAGE");
        Pair<String,String> subscription_header = new Pair<>("subscription:",subscription);
        Pair<String,String> messageID_header = new Pair<>("Message-id:",messageId);
        Pair<String,String> destination_header = new Pair<>("destination:",body);
        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(subscription_header);
        headers.add(messageID_header);
        headers.add(destination_header);
        super.setHeaders(headers);;
        super.setBody(body);
    }
}
