package cn.jack.mapper;

import cn.jack.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

    /**
     * 查询指定id的用户信息
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account queryAccountById(@Param("id") Integer id);
}
