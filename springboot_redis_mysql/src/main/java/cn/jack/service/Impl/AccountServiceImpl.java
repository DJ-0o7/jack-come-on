package cn.jack.service.Impl;

import cn.jack.entity.Account;
import cn.jack.mapper.AccountMapper;
import cn.jack.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account queryAccountById(Integer id) {
        return accountMapper.queryAccountById(id);
    }
}
