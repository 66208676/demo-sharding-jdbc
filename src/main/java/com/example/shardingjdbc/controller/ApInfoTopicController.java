package com.example.shardingjdbc.controller;

import com.alibaba.fastjson.JSON;
import com.example.shardingjdbc.entity.ApInfoTopic;
import com.example.shardingjdbc.service.ApInfoTopicService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/27 9:56
 */
@Controller
@RequestMapping("/apInfoTopic")
public class ApInfoTopicController {
    private static Logger LOGGER = LoggerFactory.getLogger(ApInfoTopicController.class);
    @Autowired
    private ApInfoTopicService apInfoTopicService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        ApInfoTopic apInfoTopic = new ApInfoTopic();
        apInfoTopic.setTopicNum(LocalDateTime.now().getHour());
        apInfoTopic.setType(LocalDateTime.now().getHour()+1);
        apInfoTopic.setContent("测试内容");
        int insert = apInfoTopicService.insert(apInfoTopic);
        LOGGER.info("==========={}",insert);
        LOGGER.info("==========={}", JSON.toJSONString(apInfoTopic));
        ApInfoTopic apInfoTopic1 = apInfoTopicService.selectByPrimaryKey(apInfoTopic.getTopicId());
        LOGGER.info("=====1======{}", JSON.toJSONString(apInfoTopic1));
        int i = apInfoTopicService.deleteByPrimaryKey(apInfoTopic.getTopicId());
        LOGGER.info("=====2======{}", i);

        return "success";
    }
}
