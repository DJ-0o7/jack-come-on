package com.jack.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //放到容器中    org.springframework.stereotype.Service;
public class UserService {

    //想拿到provider提供的票，去注册中心拿服务
    @Reference //引用     可以定义路径相同的接口名
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("买票：" + ticket);
    }
}
