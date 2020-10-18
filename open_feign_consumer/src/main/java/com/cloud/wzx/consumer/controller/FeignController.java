package com.cloud.wzx.alibaba_demo.controller;

import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.cloud.wzx.alibaba_demo.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/alibaba_demo")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value ="/mail" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MailVO>> getMails( ){
       log.debug("服务调用");
        CommonResult<List<MailVO>> mails = feignService.getMails();
        return mails;

    }
    @RequestMapping(value ="/timeOut/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MailVO> getMail(@PathVariable("id") String id){
        log.debug("服务调用");
        CommonResult<MailVO> result = feignService.timeOut(id);
        return result;

    }
}
