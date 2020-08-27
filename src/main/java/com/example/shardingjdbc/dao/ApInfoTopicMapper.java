package com.example.shardingjdbc.dao;

import com.example.shardingjdbc.entity.ApInfoTopic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApInfoTopicMapper {
    int deleteByPrimaryKey(Long topicId);

    int insert(ApInfoTopic record);

    int insertSelective(ApInfoTopic record);

    ApInfoTopic selectByPrimaryKey(Long topicId);

    int updateByPrimaryKeySelective(ApInfoTopic record);

    int updateByPrimaryKey(ApInfoTopic record);
    List<ApInfoTopic> selectList(Map<Object,Object> queryMap);
}