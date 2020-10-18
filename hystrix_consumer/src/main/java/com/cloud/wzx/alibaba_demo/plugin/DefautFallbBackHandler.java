package com.cloud.wzx.alibaba_demo.plugin;

import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.cloud.wzx.alibaba_demo.service.HystrixService;
import org.springframework.stereotype.Component;

@Component
public class DefautFallbBackHandler implements HystrixService {
    @Override
    public CommonResult<MailVO> getMail(String id) {
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("我是global getMail的自我防护机制    线程池: "+Thread.currentThread().getName()+" 调用失败 \t ┭┮﹏┭┮");
        return result;
    }

    @Override
    public CommonResult<MailVO> getMailTimeOut(String id) throws InterruptedException {
        CommonResult<MailVO> result = new CommonResult<>();
        result.setSuccess(true);
        result.setMsg("我是global getMailTimeOut的自我防护机制    线程池: "+Thread.currentThread().getName()+" 调用失败 \t ┭┮﹏┭┮");
        return result;
    }
}
