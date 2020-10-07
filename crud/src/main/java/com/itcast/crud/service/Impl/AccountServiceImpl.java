package com.itcast.crud.service.Impl;

import com.itcast.crud.dao.IAccountDao;
import com.itcast.crud.entity.Account;
import com.itcast.crud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private IAccountDao accountDao;

    @Override
    public List<Account> queryAllAccounts() {
        return accountDao.queryAllAccounts();
    }

    @Override
    public Account queryAccountById(Integer id) {
        return accountDao.queryAccountById(id);
    }

    @Override
    public Integer addAccount(String name, Double money) {
        return accountDao.addAccount(name,money);
    }

    @Override
    public Integer updateAccountMoney(Integer id, Double money) {
        return accountDao.updateAccountMoney(id,money);
    }

    @Override
    public Integer deleteAccountById(Integer id) {
        return accountDao.deleteAccountById(id);
    }
}
