package chapter_06.examples;

import chapter_06.ReceiverEndPoint;
import chapter_06.Twoot;

// tag::PrintingEndPoint[]
public class PrintingEndPoint implements ReceiverEndPoint {
    @Override
    public void onTwoot(final Twoot twoot) {
        System.out.println(twoot.getSenderId() + ": " + twoot.getContent());
    }
}
// end::PrintingEndPoint[]
