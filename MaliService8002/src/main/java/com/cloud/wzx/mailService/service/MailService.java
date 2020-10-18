package com.cloud.wzx.mailService.service;


import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class MailService {


        // 邮件发送协议
        private final static String PROTOCOL = "smtp";

        // SMTP邮件服务器
        private final static String HOST = "smtp.163.com";

        // SMTP邮件服务器默认端口
        private final static String PORT = "25";

        // 是否要求身份认证
        private final static String IS_AUTH = "true";

        // 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息）
        private final static String IS_ENABLED_DEBUG_MOD = "true";

        // 发件人 (填写发邮件的用户名)
        private static String from = "b317467045@163.com";
        // 发件人密码(填写发邮件的用户密码)
        private static String password="NMDVAHVNPEIYFODB";

        // 收件人 (自定义填写一个邮箱)
        private static String to = "317467045@qq.com";

        // 初始化连接邮件服务器的会话信息
        private static Properties props = null;

        public static void sendMail() throws AddressException, MessagingException {
            //初始化
            props = new Properties();
            props.setProperty("mail.transport.protocol", PROTOCOL);
            props.setProperty("mail.smtp.host", HOST);
            props.setProperty("mail.smtp.port", PORT);
            props.setProperty("mail.smtp.auth", IS_AUTH);
            props.setProperty("mail.debug",IS_ENABLED_DEBUG_MOD);
            // 创建Session实例对象
            Session session = Session.getDefaultInstance(props) ;


            // 创建MimeMessage实例对象
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            message.setFrom(new InternetAddress(from));
            // 设置邮件主题
            message.setSubject("使用发送简单文本邮件");
            // 设置收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 设置发送时间
            message.setSentDate(new Date());
            // 设置纯文本内容为邮件正文
            message.setText("发送文本邮件测试!!!");
            // 保存并生成最终的邮件内容
            message.saveChanges();

            // 获得Transport实例对象
            Transport transport = session.getTransport();
            // 打开连接需要邮箱帐号密码
            transport.connect(from, password);
            // 将message对象传递给transport对象，将邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接（一定要关闭）
            transport.close();


        }




}
