package com.example.shardingjdbc.service.impl;

import com.example.shardingjdbc.dao.ApInfoTopicMapper;
import com.example.shardingjdbc.entity.ApInfoTopic;
import com.example.shardingjdbc.entity.ApOpUser;
import com.example.shardingjdbc.service.ApInfoTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/27 9:55
 */
@Service
public class ApInfoTopicServiceImpl implements ApInfoTopicService {
    @Autowired
    private ApInfoTopicMapper apInfoTopicMapper;

    @Override
    public int deleteByPrimaryKey(Long topicId) {
        return apInfoTopicMapper.deleteByPrimaryKey(topicId);
    }

    @Override
    public int insert(ApInfoTopic record) {
        return apInfoTopicMapper.insert(record);
    }

    @Override
    public int insertSelective(ApInfoTopic record) {
        return 0;
    }

    @Override
    public ApInfoTopic selectByPrimaryKey(Long topicId) {
        return apInfoTopicMapper.selectByPrimaryKey(topicId);
    }

    @Override
    public int updateByPrimaryKeySelective(ApInfoTopic record) {
        return apInfoTopicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ApInfoTopic record) {
        return 0;
    }

    @Override
    public List<ApInfoTopic> selectList(Map<Object, Object> queryMap) {
        return apInfoTopicMapper.selectList(queryMap);
    }
}
