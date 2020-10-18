package com.cloud.wzx.alibaba_demo.service;

import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Component
@FeignClient(value = "HYSTRIX_MAIL_SERVICE")
public interface FeignService {

    @GetMapping("/mail")
    CommonResult<List<MailVO>>  getMails( );
    @GetMapping("/mail/{id}")
     CommonResult<MailVO> timeOut(@PathVariable("id") String id);
}
