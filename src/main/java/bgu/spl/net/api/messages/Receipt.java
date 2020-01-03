package bgu.spl.net.api.messages;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class Receipt  extends AbstractFrame{

    public Receipt(String receipt) {
        super("RECEIPT");
        Pair<String,String> receipt_header = new Pair<>("receipt-id:",receipt);
        List<Pair<String,String>> headers = new LinkedList<>();
        headers.add(receipt_header);
        super.setHeaders(headers);;
    }
}
