package com.cloud.wzx.mailService.Controller;


import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
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
    public CommonResult<Object> getMails() {
        System.out.println("获取所有邮件8002");
        MailVO mailVO = new MailVO();
        mailVO.setAddress("测试地址22222222");
        mailVO.setTitle("测试1");
        mailVO.setContext("内容11");
        ArrayList<MailVO> list = new ArrayList<>();
        list.add(mailVO);
        CommonResult<Object> build = CommonResult.builder().Success(true).msg("8002查询成功").date(list).build();
        return build;
    }

    @RequestMapping(value = "/mail/{id}", method = RequestMethod.GET)
    public MailVO getMail(@PathVariable("id") String id) {
        System.out.println("获取所有邮件");
        MailVO mailVO = new MailVO();
        mailVO.setAddress("测试1");
        mailVO.setTitle("测试1");
        mailVO.setContext("内容1");
        int i=1/0;
        return mailVO;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String sendMail(@PathVariable("id") String id) {
        System.out.println(id);
        return id + "======";
    }

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/discoveryClient")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);

        for (String service : services) {
            List<ServiceInstance> list = discoveryClient.getInstances(service);
            if (list.size() > 0) {
                ServiceInstance serviceInstance = list.get(0);
                System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" +
                        serviceInstance.getPort() + "\t" + serviceInstance.getUri());
            }

        }
        return this.discoveryClient;
    }

}
