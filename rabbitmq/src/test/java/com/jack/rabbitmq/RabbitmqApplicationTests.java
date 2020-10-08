package com.jack.rabbitmq;

import com.jack.rabbitmq.receiver.direct.DirectReceiver1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private ApplicationContext ac;



    @Test
    void contextLoads() {
        DirectReceiver1 receiverDirect = (DirectReceiver1)ac.getBean("receiverDirect");

    }

}
