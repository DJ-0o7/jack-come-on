package cn.jack.service;

import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.File;

public interface EmailService {

    /**
     * 简单的邮件发送
     * @param sender 发送者
     * @param receiver 接收者
     * @param context 邮件内容
     */
    public void simpleEmailSend(String sender, String receiver, String context);

    /**
     * 复杂的邮件发送
     * @param sender
     * @param receiver
     * @param context
     */
    public void complexEmailSend(String sender, String receiver, String context) throws MessagingException;
}
