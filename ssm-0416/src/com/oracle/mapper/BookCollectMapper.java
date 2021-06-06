package com.oracle.mapper;

import com.oracle.pojo.BookCollect;
import com.oracle.pojo.BookCollectExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookCollectMapper {
    int countByExample(BookCollectExample example);

    int deleteByExample(BookCollectExample example);

    int deleteByPrimaryKey(@Param("bookId") Integer bookId, @Param("userId") Integer userId);

    int insert(BookCollect record);

    int insertSelective(BookCollect record);

    List<BookCollect> selectByExample(BookCollectExample example);

    int updateByExampleSelective(@Param("record") BookCollect record, @Param("example") BookCollectExample example);

    int updateByExample(@Param("record") BookCollect record, @Param("example") BookCollectExample example);
    @Select(" SELECT bookName,name as username,price FROM `bookcollect` INNER JOIN book on book.bookId=bookcollect.bookId INNER JOIN user on user.id=bookcollect.userId WHERE user.id=#{userId} ")
    List<BookCollect> getCollect(Integer userId);
    @Select(" SELECT bookName as bookname, COUNT(*) as count FROM bookcollect as bc INNER JOIN book as b on b.bookId=bc.bookId INNER JOIN\r\n" + 
    		"user as u on u.id=bc.userId GROUP BY bc.bookId ORDER BY COUNT(bc.bookId) DESC LIMIT 0,5 ")
    List<Map<String, Object>> getBookNameByMaxBookId();
}