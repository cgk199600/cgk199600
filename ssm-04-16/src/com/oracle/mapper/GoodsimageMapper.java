package com.oracle.mapper;

import com.oracle.pojo.Goodsimage;
import com.oracle.pojo.GoodsimageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsimageMapper {
    int countByExample(GoodsimageExample example);

    int deleteByExample(GoodsimageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goodsimage record);

    int insertSelective(Goodsimage record);

    List<Goodsimage> selectByExample(GoodsimageExample example);

    Goodsimage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodsimage record, @Param("example") GoodsimageExample example);

    int updateByExample(@Param("record") Goodsimage record, @Param("example") GoodsimageExample example);

    int updateByPrimaryKeySelective(Goodsimage record);

    int updateByPrimaryKey(Goodsimage record);
}