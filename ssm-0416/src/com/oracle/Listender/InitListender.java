package com.oracle.Listender;

import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.oracle.pojo.Types;
import com.oracle.service.TypeService;
@Component
public class InitListender implements ServletContextAware,ApplicationListener<ContextRefreshedEvent> {
	private ServletContext servletcontext;
	@Autowired
	private TypeService typeservice;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent cre) {
		// TODO Auto-generated method stub
		List<Types> list = typeservice.getType();
		System.out.println(list);
		if(servletcontext!=null&&cre.getApplicationContext().getParent()==null) {
			servletcontext.setAttribute("type", list);
			servletcontext.setAttribute("root", servletcontext.getContextPath());
		}
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.servletcontext=arg0;
	}
	

	

}
