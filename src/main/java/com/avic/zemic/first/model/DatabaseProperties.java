package com.avic.zemic.first.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("database")
@PropertySource("classpath:database.properties")
public class DatabaseProperties {
    private String connectURL;
    private String userName;
    private String password;

    public String getConnectURL() {
        return connectURL;
    }

    public void setConnectURL(String connectURL) {
        this.connectURL = connectURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
