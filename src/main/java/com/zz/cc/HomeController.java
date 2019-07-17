package com.zz.cc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.zz.model.*;
import com.zz.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/fucc")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "insertUser";
	}

//	@RequestMapping("/hello")
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("message", "Hello Spring MVC");
//		return mv;
//	}

	// 页面跳转方法
	@RequestMapping("/add")
	public String jumpToInsert(Model model) {
//		System.out.println("进入了跳转的方法了");
		return "insertUser"; // 跳转到 添加用户的jsp页面
	}

	// 添加数据方法
	@RequestMapping("/addMethod")
	public ModelAndView addMethod(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("uesrName");
		String sex = request.getParameter("userSex");
		String phone = request.getParameter("userPhone");
		String groupz = request.getParameter("userGroup");
		String leader = request.getParameter("userLeader");

		userService.addUser(name, sex, phone, groupz, leader);

		System.out.println("name = " + name + " usersex = " + sex);
		ModelAndView mv = new ModelAndView("index");
		List<User> lists = userService.seleceAll();
		mv.addObject("lists", lists);
		System.out.println("插入成功!");
		return mv;
	}

	// 删除数据方法
	@RequestMapping("/delete")
	public ModelAndView deleteMethod(HttpServletRequest request, HttpServletResponse response) {
//			System.out.println(request.getParameter("userName"));  // 字段传递的进来

		String id = request.getParameter("id"); // 获取删除的信息
		userService.deleteUser(id);
		ModelAndView mv = new ModelAndView("index");
		List<User> lists = userService.seleceAll();
		mv.addObject("lists", lists);
		System.out.println("删除id为" + id + "的数据");
		return mv;
	}

	// 更新的跳转方法
	@RequestMapping("/update")
	public ModelAndView jumpToUpdate(HttpServletRequest request, HttpServletResponse response) {
		// 查询数据库获取该条id 所对应的数据
		String id = request.getParameter("id");
		User user = userService.findId(id);
		ModelAndView mv = new ModelAndView("updateUser");
		mv.addObject("user", user);
		mv.addObject("id", id); // 取出来的id继续传递下去
		return mv; // 跳转到 添加用户的jsp页面
	}

	// 更新数据方法
	@RequestMapping("/updateMethod")
	public ModelAndView updateMethod(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String sex = request.getParameter("userSex");
		String phone = request.getParameter("userPhone");
		String group = request.getParameter("userGroup");
		String leader = request.getParameter("userLeader");
		userService.updateUser(id, name, sex, phone, group, leader);

		ModelAndView mv = new ModelAndView("index");
		List<User> lists = userService.seleceAll();
		mv.addObject("lists", lists);
		System.out.println("更新成功");
		return mv;
	}

	// 这个是通过名字查找 实习生数据的 处理方法
	@RequestMapping("/search")
	public ModelAndView getParam(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(request.getParameter("userName"));  // 字段传递的进来
		ModelAndView mv = new ModelAndView("index");
		String name = request.getParameter("userName");
		List<User> lists = new ArrayList<User>();

		if (name == "") { // 为空就代表 展示全体成员
			lists = userService.seleceAll();
		} else {
			User user = userService.findName(name);
			lists.add(user);
		}

		mv.addObject("lists", lists);
		return mv;
	}

	// 这个是展示所有实习生信息的方法
	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");

		List<User> lists = userService.seleceAll();

		mv.addObject("lists", lists); // 将查询到的数据返回到jsp页面
		return mv;
	}

//	@RequestMapping("/value")
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("test1");
//		mv.addObject("message", "成功zz");
//		return mv;
//	}

//	@ModelAttribute
//	public void model(Model model) {
//		model.addAttribute("message", "注解成功");	
//	}
//	
//	@RequestMapping("/value")
//	public String handleRequest() {
//		return "test1";
//	}

	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mv = new ModelAndView("redirect:/hello");
		return mv;
	}

}
