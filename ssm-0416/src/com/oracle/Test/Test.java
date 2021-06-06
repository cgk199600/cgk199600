package com.oracle.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class Test {
	public static void main(String[] args) {
		
			ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext-root.xml");
			//发送邮件对象
			JavaMailSender mailSender=(JavaMailSender) ac.getBean("javaMailSender");
			String maileToAddress = "chenggukai@163.com";//目标邮箱地址
	        String subject = "开始测试";//邮件标题
	        String message = "邮件测试发送";//邮件内容正文
	        
	        System.out.println("To: " + maileToAddress);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	        
	        //邮件对象
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setFrom("chenggukai@163.com");//源发送地址
	        email.setTo(maileToAddress);//目标地址
	        email.setSubject(subject);
	        email.setText(message);
	        mailSender.send(email);//执行发送
		
	}
}
