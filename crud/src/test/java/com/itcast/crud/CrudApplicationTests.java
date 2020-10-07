package com.itcast.crud;

import com.itcast.crud.entity.Account;
import com.itcast.crud.service.AccountService;
import com.itcast.crud.service.Impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class CrudApplicationTests {

    @Autowired
    ApplicationContext ac;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        AccountService accountService = (AccountService) ac.getBean("accountService");
//        List<Account> accounts = accountService.queryAllAccounts();
//        for(Account account : accounts){
//            System.out.println(account);
//        }

        //查询id
//        Account account = accountService.queryAccountById(2);
//        System.out.println(account);

        //添加
        Integer i = accountService.addAccount("影子",50.0);
        if(i > 0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");

        //修改
//        Integer i = accountService.updateAccountMoney(4, 4.10);
//        if(i > 0)
//            System.out.println("更新成功");
//        else
//            System.out.println("更新失败");

        //删除
//        Integer i = accountService.deleteAccountById(1);
//        if(i > 0)
//            System.out.println("删除成功");
//        else
//            System.out.println("删除失败");
    }
}
