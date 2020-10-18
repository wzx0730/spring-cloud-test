package com.cloud.wzx.alibaba_demo.service;

import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.cloud.wzx.alibaba_demo.plugin.DefautFallbBackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "MAILSERVICE",fallback = DefautFallbBackHandler.class)
public interface HystrixService {

    @GetMapping("/hystrix/mail/{id}")
    CommonResult<MailVO> getMail(@PathVariable("id") String id);

    @GetMapping("/hystrix/timeOut/{id}")
    CommonResult<MailVO> getMailTimeOut(@PathVariable("id") String id) throws InterruptedException;
}
