package com.woowle.eggwithtomato.common.VO;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhang
 */
@Configuration
public class EggWithTomatoAdminConfig implements InitializingBean {
    private static EggWithTomatoAdminConfig adminConfig = null;
    public static EggWithTomatoAdminConfig getAdminConfig() {
        return adminConfig;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        adminConfig = this;
    }

    // conf

    @Value("${egg-with-tomato.login.username}")
    private String loginUsername;

    @Value("${egg-with-tomato.login.password}")
    private String loginPassword;

    @Value("${egg-with-tomato.i18n}")
    private String i18n;

    @Value("${egg-with-tomato.accessToken}")
    private String accessToken;


    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getI18n() {
        return i18n;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
