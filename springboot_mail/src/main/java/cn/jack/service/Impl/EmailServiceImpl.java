package cn.jack.service.Impl;

import cn.jack.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@Service("emailService")
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSenderImpl sender; //邮件发送对象

    @Override
    @Async //告诉spring这是一个异步方法
    public void simpleEmailSend(String sender, String receiver, String context) {
        SimpleMailMessage message = new SimpleMailMessage();
        //设置主题
        message.setSubject("一个简单的邮件");
        //设置发送的内容
        message.setText(context);
        //设置接收者, 发给谁？
        message.setTo(receiver);
        //设置发送者, 谁发的？
        message.setFrom(sender);
        this.sender.send(message); //开始发送
        System.out.println("发送成功");
    }

    @Override
    @Async
    public void complexEmailSend(String sender, String receiver,
                                 String context) throws MessagingException {
        //一个复杂的邮件
        MimeMessage message = this.sender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //正文
        //主题
        helper.setSubject("小可爱，你好呀！");
        helper.setText(context,true); //开启html模式
        //附件
        helper.addAttachment("1.jpg",new File("E:\\1.jpg"));
        helper.setTo(receiver);
        helper.setFrom(sender);
        this.sender.send(message);
    }
}
