package com.oracle.mapper;

import com.oracle.pojo.Booktype;
import com.oracle.pojo.BooktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooktypeMapper {
    int countByExample(BooktypeExample example);

    int deleteByExample(BooktypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(Booktype record);

    int insertSelective(Booktype record);

    List<Booktype> selectByExample(BooktypeExample example);

    Booktype selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByExample(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByPrimaryKeySelective(Booktype record);

    int updateByPrimaryKey(Booktype record);
}