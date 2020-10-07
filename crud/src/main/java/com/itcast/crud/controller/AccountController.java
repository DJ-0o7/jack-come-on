package com.itcast.crud.controller;

import com.itcast.crud.entity.Account;
import com.itcast.crud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public List<Account> getAll(){
        return accountService.queryAllAccounts();
    }
}
