package com.cloud.wzx.mailService.service;

import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.TimeUnit;

@Service
public class FakeService {

    public CommonResult<MailVO> getMail(String id) {
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("线程池: "+Thread.currentThread().getName()+" service:ok, id :"+id+"\t+O(∩_∩)O哈哈~");
        return result;
    }

    @HystrixCommand(fallbackMethod ="timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommonResult<MailVO> getMailTimeOut(String id) throws InterruptedException {
        int time=5;
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("线程池: "+Thread.currentThread().getName()+" service:ok, id :"+id
                +"\t O(∩_∩)O哈哈~"+time+"秒");
        TimeUnit.SECONDS.sleep(time);
        return result;
    }

    public CommonResult<MailVO> timeOutHandler(String id){
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("线程池: "+Thread.currentThread().getName()+" 服务器忙 id :"+id+"\t ┭┮﹏┭┮");
        return result;
    }
}
