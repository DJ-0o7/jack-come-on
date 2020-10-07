package com.itcast.crud.service;

import com.itcast.crud.entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountService {

    /**
     * 查询所有用户
     * @return
     */
    public List<Account> queryAllAccounts();

    /**
     * 查询指定用户
     * @param id
     * @return
     */
    public Account queryAccountById(Integer id);

    /**
     * 添加一个用户
     * @param name
     * @param money
     * @return
     */
    public Integer addAccount(String name, Double money);

    /**
     * 修改某个用户的金钱
     * @param id
     * @param money
     * @return
     */
    public Integer updateAccountMoney(Integer id, Double money);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public Integer deleteAccountById(Integer id);
}
