package cn.jack.mapper;

import cn.jack.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AccountMapper {
    /**
     * 获取总记录数
     * @return
     */
    public Integer queryTotalRecords();

    /**
     * 查询指定范围的记录数
     * @param map
     * @return
     */
    public List<Account> queryLimitAccounts(Map<String,Integer> map);
}
