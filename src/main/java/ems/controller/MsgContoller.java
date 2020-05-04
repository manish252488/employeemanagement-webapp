package ems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ems.services.MsgService;

@Controller
public class MsgContoller {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Dependencies.xml");
	MsgService msc=(MsgService)ctx.getBean("msgdao");
	@RequestMapping("/send")
	public boolean message(HttpSession ses,@RequestParam String msg,@RequestParam int toid) {
		int empid=(Integer)ses.getAttribute("empid");
		msc.sendMessage(empid, toid, msg);
		return true;
	}
	@RequestMapping("/viewmsg")
	public ModelAndView viewMessages(HttpSession ses) {
		int empid=(Integer)ses.getAttribute("empid");
		ModelAndView mav=new ModelAndView("message");
		mav.addObject("msglist", msc.getChat(empid));
		return mav;
	}
}
