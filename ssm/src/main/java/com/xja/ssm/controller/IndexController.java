package com.xja.ssm.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysUser;
import com.xja.ssm.service.SysMenuService;
import com.xja.ssm.service.SysUserService;

@Controller
public class IndexController {
	
	@Autowired
	private SysUserService sysuserservice;
	@Autowired
	private SysMenuService sysmenuservice;
	@ResponseBody
	@RequestMapping("getmenu")//查询菜单
	public JsonBean getmenu(HttpServletRequest request) {
		JsonBean jsonBean=new JsonBean(-1,"未登录",null);
		HttpSession session=request.getSession();
		SysUser sessionuser = (SysUser) session.getAttribute("SysUser");//取到成功登陆的用户
		if(sessionuser!=null) {
			jsonBean=new JsonBean(0,"ok",sessionuser.getMenu());//直接从user实体中get到menu集合取到put的页面数据
		}
		//jsonBean=sysmenuservice.getmenuByroleId(2);
		
		return jsonBean;
	}
	
	
	@ResponseBody
	@RequestMapping("login")
	public JsonBean login(HttpServletRequest request,String username,String password,String code){
		HttpSession session = request.getSession();
		String co=(String)session.getAttribute("code");
		JsonBean jsonBean = sysuserservice.selectByUsername(username, password);
		System.out.println(jsonBean.toString());
		if(username==null||username.equals("")||password==null||password.equals("")||code==null||code.equals("")) {//判断是否有密码用户名和验证码
	return new JsonBean(-1,"请正确填写",null);
		}
		if(code.equalsIgnoreCase(co)) {//判断验证码
			if(jsonBean.getCode()==0) {//查询密码用户方法后返回json判断json中的code是否为0为0
				session.setAttribute("SysUser", jsonBean.getData());//set给session中json中的data取出为sysuser，再付个null给json中的data以防他人查询到
				jsonBean.setData(null);
			}	
		}	
		return  jsonBean;
	}
	
	@ResponseBody
	@RequestMapping("code")
public void code(HttpServletRequest request,HttpServletResponse response) {
	ByteArrayOutputStream out=new ByteArrayOutputStream();//输出流缓冲区
	//生成验证码
	String code = drawImg(out);
	HttpSession session=request.getSession();
	session.setAttribute("code", code);//setcode验证码
	try {
		ServletOutputStream stream = response.getOutputStream();//去get到输出流
		out.writeTo(stream);//写到外面
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	private String drawImg(ByteArrayOutputStream output){
		String code = "";
		for(int i=0; i<4; i++){
			code += randomChar();
		}
		int width = 70;
		int height = 25;
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		Font font = new Font("Times New Roman",Font.PLAIN,15);
		Graphics2D g = bi.createGraphics();
		g.setFont(font);
		Color color = new Color(66,2,82);
		g.setColor(color);
		g.setBackground(new Color(226,226,240));
		g.clearRect(0, 0, width, height);
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(code, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = bounds.getY();
		double baseY = y - ascent;
		g.drawString(code, (int)x, (int)baseY);
		g.dispose();
		try {
			ImageIO.write(bi, "jpg", output);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return code;
	}
	
	private char randomChar(){
		Random r = new Random();
		String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		return s.charAt(r.nextInt(s.length()));
	}
}

