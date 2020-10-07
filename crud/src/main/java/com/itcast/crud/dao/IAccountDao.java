package com.itcast.crud.dao;

import com.itcast.crud.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAccountDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from account")
    public List<Account> queryAllAccounts();

    /**
     * 查询指定用户
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account queryAccountById(Integer id);

    /**
     * 添加一个用户
     * @param name
     * @param money
     * @return
     */
    @Insert("insert into account(name, money) values(#{name}, #{money})")
    public Integer addAccount(String name, Double money);

    /**
     * 修改某个用户的金钱
     * @param id
     * @param money
     * @return
     */
    @Update("update account set money = #{money} where id = #{id}")
    public Integer updateAccountMoney(Integer id, Double money);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("delete from account where id = #{id}")
    public Integer deleteAccountById(Integer id);
}
