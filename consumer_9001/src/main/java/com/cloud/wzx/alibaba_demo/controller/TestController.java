package com.cloud.wzx.alibaba_demo.controller;


import com.cloud.wzx.common.CommonResult;
import com.cloud.wzx.common.vo.mail.MailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value ="/mail" ,method = RequestMethod.POST)
    public boolean sendMail( @ModelAttribute("mail") MailVO mail){
        boolean status = restTemplate.postForObject("http://MailService/mail", mail, boolean.class);
        return status;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value ="/mail" ,method = RequestMethod.GET)
    public CommonResult<Object> getMails( ){
        return restTemplate.getForObject("http://MailService/mail", CommonResult .class);
    }
    @RequestMapping(value ="/mail/{id}" ,method = RequestMethod.GET)
    public MailVO getMail( @PathVariable("id") String id){
        return restTemplate.getForObject("http://MailService/mail/"+id , MailVO.class);

    }

    @RequestMapping(value ="/test/{id}" ,method = RequestMethod.GET)
    public String getMail1( @PathVariable("id") String id){
        return restTemplate.getForEntity("http://MailService/test/"+id , String.class).getBody();

    }
/*
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/discoveryClient")
    public Object discoveryClient(){
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> mail = discoveryClient.getInstances("MAILSERVICE");
        for (ServiceInstance serviceInstance : mail) {

            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+
                    serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }*/
}
