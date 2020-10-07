package cn.jack.service;

import cn.jack.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountService {
    public Account queryAccountById(Integer id);
}
