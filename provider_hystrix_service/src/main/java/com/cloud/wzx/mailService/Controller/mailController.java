package com.cloud.wzx.mailService.Controller;


import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import com.cloud.wzx.mailService.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class mailController {

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public boolean sendMail(@RequestBody MailVO mail) {
        return true;
    }

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public CommonResult<List<MailVO>> getMails() {
        System.out.println("获取所有邮件8001");
        MailVO mailVO = new MailVO();
        mailVO.setAddress("测试地址1111111");
        mailVO.setTitle("测试1");
        mailVO.setContext("内容11");
        ArrayList<MailVO> list = new ArrayList<>();
        list.add(mailVO);
        CommonResult<List<MailVO>> result = new CommonResult<>();
        result.setDate(list);
        result.setMsg("8001，查询成功");
        result.setSuccess(true);
        return result;
    }

    @Autowired
    private FakeService fakeService;

    @RequestMapping(value = "/hystrix/mail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MailVO> getMail(@PathVariable("id") String id) {
        CommonResult<MailVO> mail = fakeService.getMail(id);
        return mail;
    }

    @RequestMapping(value = "/hystrix/timeOut/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<MailVO> getMailTimeOut(@PathVariable("id") String id) throws InterruptedException {
        CommonResult<MailVO> mailTimeOut = fakeService.getMailTimeOut(id);
        return mailTimeOut;
    }


}
