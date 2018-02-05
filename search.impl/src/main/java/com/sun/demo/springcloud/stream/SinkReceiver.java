package com.sun.demo.springcloud.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@Slf4j
@EnableBinding({Processor.class})
public class SinkReceiver {

    @StreamListener(Processor.INPUT)
    public void listenerInput(Object obj) {
        log.debug("Received Message: " + obj);
    }
}
