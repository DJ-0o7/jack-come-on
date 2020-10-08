package cn.jack.service;

import cn.jack.entity.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {

    public Integer queryTotalRecords();

    public List<Account> queryLimitAccounts(Map<String,Integer> map);
}
