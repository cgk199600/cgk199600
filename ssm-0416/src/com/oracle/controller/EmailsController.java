package com.oracle.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.pojo.Emails;
import com.oracle.pojo.User;
import com.oracle.service.EmailsService;
import com.oracle.service.UserService;
import com.oracle.util.EmailUtil;
import com.oracle.util.MD5Util;
import com.oracle.util.Sendmail;
@RequestMapping("/member/emails")
@Controller
public class EmailsController {
	@Autowired
	private EmailsService emailsservice;
	@Autowired
	private UserService userService;
	@RequestMapping("/regop")
	public String regOP(String email,String pwd,Integer userId,HttpServletRequest request) {
		Calendar c=Calendar.getInstance();
		long timeInMillis = c.getTimeInMillis();
		//创建激活码
		String md5Str = MD5Util.getMd5Str(email+pwd+timeInMillis);
		//过期时间
		String token_exptime=(timeInMillis+1000*60*60)+"";
		
		Emails emails=new Emails();
		emails.setUserid(userId);
		emails.setPassword(pwd);
		emails.setToken(md5Str);
		emails.setToken_exptime(token_exptime);
		emails.setUsername(email);
		if(emailsservice.insertEmails(emails)) {
			//发送邮件
			///邮件的内容
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
	        StringBuffer sb=new StringBuffer("<div></div></br>");
	        sb.append("<a href=\"http://localhost:8080/ssm-0416/member/emails/emailcheck?id=");
	        sb.append(emails.getId());
	        sb.append("&token=");
	        sb.append(md5Str);
	        sb.append("\">http://localhost:8080/ssm-0416/member/emails/emailcheck?id=");
	        sb.append(emails.getId());
	        sb.append("&token=");
	        sb.append(md5Str);
	        sb.append("</a>"+"<br/>如果以上链接无法点击，请把上面网页地址复制到浏览器地址栏中打开<br/><br/><br/>"+sdf.format(new Date())+ "</div></div>" );
	      
	        Sendmail.send(email, sb.toString());

		}
		
		return null;
		
	}
	@RequestMapping("/emailcheck")
	@ResponseBody
	public String emailcheck(Integer id,String token) {
		
		Calendar c = Calendar.getInstance();
		//现在的时间(单位：毫秒)
		long curtime = c.getTimeInMillis();
		Emails emails = emailsservice.getemails(id, token);
	
	
		
		
		String email = emails.getUsername();
		String pwd=emails.getPassword();
		if( emails.getId()!=null ){
			long token_exptime=Long.parseLong(emails.getToken_exptime());
			if( curtime>token_exptime ){
				//激活码过期，先删除该用户记录，然后重新发送邮件
				emailsservice.removeemails(emails.getId());
		
				 return "激活码已过期";
			}else{
				//验证激活码是否正确
				if(token.equals(emails.getToken())){
					emails.setState(1);
					emailsservice.updateemails(emails);
					User user=new User();
					user.setId(emails.getUserid());
					user.setStatus(1);
					userService.updatetUser(user);
					return "激活成功";
				}else {
					emailsservice.removeemails(emails.getId());
					return "激活码不正确";
			//		 throw new DataExistAlreadyException("激活码不正确");  
				}
			}
		}
		return null; 
		
	}

	}

