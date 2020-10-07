package cn.jack;

import cn.jack.entity.Account;
import cn.jack.service.AccountService;
import cn.jack.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisMysqlApplicationTests {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        System.out.println((String) redisUtils.get("welcome"));
    }
}
