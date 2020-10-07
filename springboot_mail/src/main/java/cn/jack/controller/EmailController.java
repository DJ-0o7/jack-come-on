package cn.jack.controller;

import cn.jack.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping("/email/send")
    public String emailSend(@RequestParam("sender")String sender,
                            @RequestParam("receiver") String receiver,
                            @RequestParam("context") String context){
        emailService.simpleEmailSend(sender,receiver,context);
        return "success";
    }

    @RequestMapping("/email/send2")
    public String complexEmailSend(@RequestParam("sender")String sender,
                            @RequestParam("receiver") String receiver,
                            @RequestParam("context") String context) throws MessagingException {
        emailService.complexEmailSend(sender,receiver,context);
        return "success";
    }
}
