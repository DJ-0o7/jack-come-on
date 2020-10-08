package cn.jack;

import cn.jack.entity.Account;
import cn.jack.service.AccountService;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SimplePageApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
        Map<String, Integer> map = new HashMap<>();
        map.put("start", 1);//起使页
        map.put("pages", 3);//这里是记录数量
        List<Account> accounts = accountService.queryLimitAccounts(map);
        System.out.println(accounts);
    }
}
