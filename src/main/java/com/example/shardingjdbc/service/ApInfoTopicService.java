package com.example.shardingjdbc.service;

import com.example.shardingjdbc.entity.ApInfoTopic;
import com.example.shardingjdbc.entity.ApOpUser;

import java.util.List;
import java.util.Map;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/27 9:54
 */
public interface ApInfoTopicService {
    int deleteByPrimaryKey(Long topicId);

    int insert(ApInfoTopic record);

    int insertSelective(ApInfoTopic record);

    ApInfoTopic selectByPrimaryKey(Long topicId);

    int updateByPrimaryKeySelective(ApInfoTopic record);

    int updateByPrimaryKey(ApInfoTopic record);
    List<ApInfoTopic> selectList(Map<Object,Object> queryMap);
}
