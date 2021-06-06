package com.oracle.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oracle.bean.PageVo;
import com.oracle.bean.SearchBooks;

@RunWith(SpringJUnit4ClassRunner.class)	
//@ContextConfiguration("classpath:applicationContext-root.xml")
public class BookServiceTest {
//	@Autowired
//	private BookService bookService;
//	@Test
//	public void name() {
//		SearchBooks serBooks=new SearchBooks();
//		PageVo list = bookService.getList(1, 3, serBooks);
//		System.out.println(list.toString());
//	}
//	@Autowired
//	private JavaMailSender mailser;
	@Test
	public void email(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext-root.xml");
		//发送邮件对象
		JavaMailSender mailSender=(JavaMailSender) ac.getBean("javaMailSender");
		String maileToAddress = "1014170605@qq.com";//目标邮箱地址
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
