package bgu.spl.net.impl.stomp;

import bgu.spl.net.api.MessageEncoderDecoder;
import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.api.messages.AbstractFrame;
import bgu.spl.net.impl.MessageEncoderDecoderImpl;
import bgu.spl.net.impl.stomp.suppliers.EncoderDecoderFactory;
import bgu.spl.net.impl.stomp.suppliers.StompMessageProtocolFactory;

import java.util.function.Supplier;

public class StompServer {

    public static void main(String[] args) {
        //Supplier init
        Supplier <MessagingProtocol<AbstractFrame>>  protocolFactory = new StompMessageProtocolFactory();
        Supplier<MessageEncoderDecoder<AbstractFrame>> encdecFactory = new EncoderDecoderFactory();

        Server<AbstractFrame> stomp_server = new Server<>(8080, protocolFactory , encdecFactory);
        stomp_server.serve();


    }


}
