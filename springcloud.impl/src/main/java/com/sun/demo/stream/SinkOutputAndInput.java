package com.sun.demo.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@Slf4j
@EnableBinding({Processor.class})
public class SinkOutputAndInput {

    // must be have Return Type
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "100000", maxMessagesPerPoll = "1"))
    public String send() {
        String random = String.valueOf(Math.random());
        log.debug("Send message: " + random);
        return random;
    }

    // StreamListener void
    @StreamListener(Processor.INPUT)
    public void listenerInput(Object obj) {
        log.debug("Received Message: " + obj);
    }

    //    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    public Object listenerInputAndSendToOutput(Object obj) {
//        log.debug("Received:[[ " + obj + " ]]");
//        return "<< Send OK >>" + obj;
//    }
}