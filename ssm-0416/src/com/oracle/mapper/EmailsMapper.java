package com.oracle.mapper;

import com.oracle.pojo.Emails;
import com.oracle.pojo.EmailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailsMapper {
    int countByExample(EmailsExample example);

    int deleteByExample(EmailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Emails record);

    int insertSelective(Emails record);

    List<Emails> selectByExample(EmailsExample example);

    Emails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Emails record, @Param("example") EmailsExample example);

    int updateByExample(@Param("record") Emails record, @Param("example") EmailsExample example);

    int updateByPrimaryKeySelective(Emails record);

    int updateByPrimaryKey(Emails record);
}