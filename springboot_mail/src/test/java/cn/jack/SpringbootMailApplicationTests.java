package cn.jack;

import cn.jack.service.EmailService;
import cn.jack.service.Impl.EmailServiceImpl;
import cn.jack.service.ScheduledService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class SpringbootMailApplicationTests {

    @Autowired
    private JavaMailSenderImpl sender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Where");
        message.setText("I'm Jack , I from China! I Love China!");
        message.setTo("2100699906@qq.com");
        message.setFrom("1280900632@qq.com");
        sender.send(message);
    }

    @Autowired
    private ScheduledService scheduledService;

    @Test
    public void test(){
        scheduledService.ScheduledTask();
    }
}
