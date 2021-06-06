package com.oracle.mapper;

import com.oracle.pojo.Phones;
import com.oracle.pojo.PhonesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhonesMapper {
    int countByExample(PhonesExample example);

    int deleteByExample(PhonesExample example);

    int deleteByPrimaryKey(Integer phId);

    int insert(Phones record);

    int insertSelective(Phones record);

    List<Phones> selectByExample(PhonesExample example);

    Phones selectByPrimaryKey(Integer phId);

    int updateByExampleSelective(@Param("record") Phones record, @Param("example") PhonesExample example);

    int updateByExample(@Param("record") Phones record, @Param("example") PhonesExample example);

    int updateByPrimaryKeySelective(Phones record);

    int updateByPrimaryKey(Phones record);
}