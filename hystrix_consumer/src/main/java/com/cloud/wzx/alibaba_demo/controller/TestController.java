package com.cloud.wzx.alibaba_demo.controller;


import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.cloud.wzx.alibaba_demo.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private HystrixService hystrixService;


    @RequestMapping(value = "/consumer/mail/{id}", method = RequestMethod.GET)
    public CommonResult<MailVO> getMails(@PathVariable String id) {
        return hystrixService.getMail(id);
    }

    @RequestMapping(value = "/consumer/timeOut/{id}", method = RequestMethod.GET)
    @HystrixCommand
   /* @HystrixCommand(fallbackMethod ="timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    public CommonResult<MailVO> getMail(@PathVariable("id") String id) throws InterruptedException {

        return hystrixService.getMailTimeOut(id);
    }

    public CommonResult<MailVO> timeOutHandler(){
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("我是客户端的自我防护机制    线程池: "+Thread.currentThread().getName()+" 调用失败 \t ┭┮﹏┭┮");
        return result;
    }


}
