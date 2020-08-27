# demo-sharding-jdbc
sharding-jdbc + spring boot 测试demo


CREATE TABLE `ap_info_topic0` (
  `topic_id` bigint(20) NOT NULL COMMENT '主键id',
  `topic_num` int(8) DEFAULT NULL COMMENT '题号',
  `type` int(2) DEFAULT NULL COMMENT '题目类型',
  `content` varchar(1024) DEFAULT NULL COMMENT '题目内容',
  `active` int(2) DEFAULT NULL COMMENT '状态 1:生效 8:禁用',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `create_by_name` varchar(32) DEFAULT NULL COMMENT '创建人名称',
  `create_by_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by_name` varchar(32) DEFAULT NULL COMMENT '修改人名称',
  `update_by_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目表';

CREATE TABLE `ap_info_topic1` (
  `topic_id` bigint(20) NOT NULL COMMENT '主键id',
  `topic_num` int(8) DEFAULT NULL COMMENT '题号',
  `type` int(2) DEFAULT NULL COMMENT '题目类型',
  `content` varchar(1024) DEFAULT NULL COMMENT '题目内容',
  `active` int(2) DEFAULT NULL COMMENT '状态 1:生效 8:禁用',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  `create_by_name` varchar(32) DEFAULT NULL COMMENT '创建人名称',
  `create_by_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by_name` varchar(32) DEFAULT NULL COMMENT '修改人名称',
  `update_by_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题目表';
