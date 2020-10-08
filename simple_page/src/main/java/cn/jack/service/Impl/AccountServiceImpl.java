package cn.jack.service.Impl;

import cn.jack.entity.Account;
import cn.jack.mapper.AccountMapper;
import cn.jack.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Integer queryTotalRecords() {
        return accountMapper.queryTotalRecords();
    }

    @Override
    public List<Account> queryLimitAccounts(Map<String, Integer> map) {
        return accountMapper.queryLimitAccounts(map);
    }
}
