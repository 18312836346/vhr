package com.niit.vhr.mapper;

import com.niit.vhr.model.JobLevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    @Select("select * from joblevel")
    List<JobLevel> selectAllJobLevel();

    Integer deleteByIds(Integer[] ids);
}