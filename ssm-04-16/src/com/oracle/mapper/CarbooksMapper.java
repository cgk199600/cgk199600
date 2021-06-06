package com.oracle.mapper;

import com.oracle.pojo.Carbooks;
import com.oracle.pojo.CarbooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarbooksMapper {
    int countByExample(CarbooksExample example);

    int deleteByExample(CarbooksExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Carbooks record);

    int insertSelective(Carbooks record);

    List<Carbooks> selectByExample(CarbooksExample example);

    Carbooks selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Carbooks record, @Param("example") CarbooksExample example);

    int updateByExample(@Param("record") Carbooks record, @Param("example") CarbooksExample example);

    int updateByPrimaryKeySelective(Carbooks record);

    int updateByPrimaryKey(Carbooks record);
}