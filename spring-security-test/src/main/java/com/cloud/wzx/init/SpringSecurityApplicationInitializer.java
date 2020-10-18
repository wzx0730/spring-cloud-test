package com.cloud.wzx.init;

import com.cloud.wzx.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer(){
        //super(WebSecurityConfig.class);
    }
}
