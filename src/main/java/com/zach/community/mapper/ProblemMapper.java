package com.zach.community.mapper;

import com.zach.community.model.Problem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zach - 吸柒
 */
@Mapper
public interface ProblemMapper {

    @Select("select * from problem")
    List<Problem> findAll();

    @Insert("insert into problem (title,category,content,user_name,create_time) values (#{title},#{category},#{content},#{userName},#{createTime})")
    void insert(Problem problem);


}
