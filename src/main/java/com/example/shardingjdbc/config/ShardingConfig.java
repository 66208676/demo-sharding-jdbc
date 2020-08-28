package com.example.shardingjdbc.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/21 14:55
 */
@Configuration
public class ShardingConfig {
    @Autowired
    private JdbcConfig jdbcConfig;

    @Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("ap_info_topic");
//        shardingRuleConfig.getBroadcastTables().add("t_config");
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("type", "ds${type % 2}"));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("topic_id", "ap_info_topic${topic_id % 2}"));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new Properties());

//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        //分片表规则配置
//        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
//        //绑定分片表，主要用来路由
//        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");
//        //设置默认数据源分片策略
//        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new PreciseModuloShardingDatabaseAlgorithm()));
//        //设置默认表分片策略
//        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", new PreciseModuloShardingTableAlgorithm()));
//        //主从配置，支持多主多从
//        shardingRuleConfig.setMasterSlaveRuleConfigs(getMasterSlaveRuleConfigurations());
//        //创建ShardingDataSource数据源
//        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new Properties());
    }

    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        Properties properties = new Properties();
        properties.setProperty("worker.id","3");
        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE", "topic_id",properties);
        result.getProperties().put("worker.id", "4");
        return result;
    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("ap_info_topic", "ds${0..1}.ap_info_topic${0..1}");
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }


    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", createDb0());
        result.put("ds1", createDb1());
        return result;
    }
    private DruidDataSource createDb0() {
        // 配置数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getClassName0());
        dataSource.setDbType(jdbcConfig.getDbType0());
        dataSource.setUrl(jdbcConfig.getUrl0());
        dataSource.setUsername(jdbcConfig.getUser0());
        dataSource.setPassword(jdbcConfig.getPass0());
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        // 每个分区最大的连接数
        dataSource.setMaxActive(20);
        // 每个分区最小的连接数
        dataSource.setMinIdle(5);
        return dataSource;
    }
    private DruidDataSource createDb1() {
        // 配置第一个数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getClassName1());
        dataSource.setDbType(jdbcConfig.getDbType1());
        dataSource.setUrl(jdbcConfig.getUrl1());
        dataSource.setUsername(jdbcConfig.getUser1());
        dataSource.setPassword(jdbcConfig.getPass1());
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        // 每个分区最大的连接数
        dataSource.setMaxActive(20);
        // 每个分区最小的连接数
        dataSource.setMinIdle(5);
        return dataSource;
    }
    @Bean
    public Filter statFilter(){
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }
}
