package com.lin.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: LinZhaoguan
 * Date: 2018/4/16
 * Time: 16:09
 * Description:
 */
@EnableBinding(MsgSenderTest.MsgSender.class)
public class MsgSenderTest extends RabbitmqApplicationTests {

    @Autowired
    private MsgSender msgSender;

    @Test
    public void testMsgSender() {
        boolean b = msgSender.output().send(MessageBuilder.withPayload("hi").build());
        System.out.println(b);
    }

    public interface MsgSender {
        String OUTPUT = "input";

        @Output(MsgSender.OUTPUT)
        MessageChannel output();
    }
}
