package cn.jack.service.Impl;

import cn.jack.service.ScheduledService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduledServiceImpl implements ScheduledService {

    /**
     * cron 表达式
     *      秒   分   时   天   月   周几 年
     *      https://cron.qqe2.com/
     */
    @Override
    @Scheduled(cron = "10/10 * * * * ?")
    public void ScheduledTask() {
        System.out.println(new Date().toString());
    }
}
