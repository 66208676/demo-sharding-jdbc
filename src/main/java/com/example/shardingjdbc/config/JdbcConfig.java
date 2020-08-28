package com.example.shardingjdbc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/25 16:12
 */
@Component
@ConfigurationProperties(prefix = "ds")
public class JdbcConfig {
    @Value("${ds.datasource0.url}")
    private String url0;
    @Value("${ds.datasource1.url}")
    private String url1;
    @Value("${ds.datasource0.username}")
    private String user0;
    @Value("${ds.datasource1.username}")
    private String user1;
    @Value("${ds.datasource0.password}")
    private String pass0;
    @Value("${ds.datasource1.password}")
    private String pass1;
    @Value("${ds.datasource0.driver-class-name}")
    private String className0;
    @Value("${ds.datasource1.driver-class-name}")
    private String className1;
    @Value("${ds.datasource0.type}")
    private String dbType0;
    @Value("${ds.datasource1.type}")
    private String dbType1;

    public String getUrl0() {
        return url0;
    }

    public void setUrl0(String url0) {
        this.url0 = url0;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUser0() {
        return user0;
    }

    public void setUser0(String user0) {
        this.user0 = user0;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getPass0() {
        return pass0;
    }

    public void setPass0(String pass0) {
        this.pass0 = pass0;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getClassName0() {
        return className0;
    }

    public void setClassName0(String className0) {
        this.className0 = className0;
    }

    public String getClassName1() {
        return className1;
    }

    public void setClassName1(String className1) {
        this.className1 = className1;
    }

    public String getDbType0() {
        return dbType0;
    }

    public void setDbType0(String dbType0) {
        this.dbType0 = dbType0;
    }

    public String getDbType1() {
        return dbType1;
    }

    public void setDbType1(String dbType1) {
        this.dbType1 = dbType1;
    }
}
