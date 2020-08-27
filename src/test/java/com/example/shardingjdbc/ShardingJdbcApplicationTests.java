package com.example.shardingjdbc;

import com.alibaba.fastjson.JSON;
import com.example.shardingjdbc.dao.ApInfoTopicMapper;
import com.example.shardingjdbc.entity.ApInfoTopic;
import com.google.common.collect.Maps;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class ShardingJdbcApplicationTests {
    private static Logger LOGGER = LoggerFactory.getLogger(ShardingJdbcApplicationTests.class);
    @Autowired
    private ApInfoTopicMapper apInfoTopicMapper;
    @Test
    public void contextLoads() {
        ApInfoTopic apinfo = new ApInfoTopic();
        apinfo.setTopicNum(1);
        apinfo.setContent("测试");
        apinfo.setTopicNum(LocalDateTime.now().getMinute());
        apinfo.setType(LocalDateTime.now().getHour());
        apinfo.setCreateTime(new Date());
        apinfo.setUpdateTime(new Date());
        int insert = apInfoTopicMapper.insert(apinfo);
        LOGGER.info("insert========={}",insert);
//        ApInfoTopic apInfoTopic = apInfoTopicMapper.selectByPrimaryKey(insert);
        LOGGER.info("obj=={}", JSON.toJSONString(insert));
//        apInfoTopicMapper.se
        Map<Object, Object> map = Maps.newHashMap();
        List<ApInfoTopic> apInfoTopics = apInfoTopicMapper.selectList(map);
        LOGGER.info("=====3======{}", JSON.toJSONString(apInfoTopics));
        LOGGER.info("=====3======{}", apInfoTopics.size());
    }

}
