package com.jack.service.impl;

import com.jack.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//zookeeper: 服务注册与发现

@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《战狼2》";
    }
}
