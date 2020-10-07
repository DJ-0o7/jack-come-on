package cn.jack.controller;

import cn.jack.entity.Account;
import cn.jack.service.AccountService;
import cn.jack.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private AccountService service;

    @ResponseBody
    @GetMapping("/byId/{id}")
    public Account queryAccountById(@PathVariable Integer id){
        System.out.println(id);
        Account val = (Account)redisUtils.get(id.toString());
        if(val != null){
            return val;
        }else{
            Account account = service.queryAccountById(id);
            if(account == null){
                return null;
            }
            redisUtils.set(account.getId().toString(),account);
            return account;
        }
    }
}
