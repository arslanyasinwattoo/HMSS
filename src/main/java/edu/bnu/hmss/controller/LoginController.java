package edu.bnu.hmss.controller;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import edu.bnu.hmss.entity.Authorities;
import edu.bnu.hmss.entity.Users;
import edu.bnu.hmss.service.userService;

@Controller
public class LoginController {
	@Autowired
	userService userService;
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public String showLoginPage() {
		logger.info("Going to Load Login Form");
		logger.debug("Going to Load Login Form");
		logger.error("Going to Load Login Form");
		return "login";
	}

	@RequestMapping(value = "/common/home")
	public String showHome() {
		// logger.info("Going to Load Login Form");

		return "home";
	}

	@RequestMapping(value = "/sysadmin/home")
	public String showsHome() {
		// logger.info("Going to Load Login Form");

		return "home";
	}

	@RequestMapping(value = "/common/RegisterUser")
	public String registerUser(Model model) {
		// logger.info("Going to Load Login Form");
		model.addAttribute("check", 1);
		return "registerUser";
	}

	@RequestMapping(value = "/sysadmin/RegisterUser")
	public String SysAdminRegisterPage(Model model) {
		model.addAttribute("check", 2);
		// logger.info("Going to Load Login Form");
		return "registerUser";
	}

	// @RequestMapping(value = "/hadmin/RegisterUser")
	// public String IniAdminRegisterPage(Model model) {
	// model.addAttribute("check", 1);
	// // logger.info("Going to Load Login Form");
	// return "RegisterUser";
	// }
	@RequestMapping(value = "ajax")
	public String IniAdminRegisterPage(Model model) {
		model.addAttribute("status", 1);
		// logger.info("Going to Load Login Form");
		System.out.println("ajax method");
		return "status";
	}

	@RequestMapping(value = "/saveRegister")
	public String SaveRegister(Model model,
			@RequestParam("username") String userName,
			@RequestParam("password") String password,
			@RequestParam("check") int check) {
		Users users = new Users();
		System.out.println("saving method");
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			String ppp = Base64.encode(byteData);
			System.out.println(ppp);

			users.setUsername(userName);
			users.setPassword(ppp);
			byte a = 0;
			users.setEnabled(a);
			byte block = 0;
			userService.addUsers(users);
			Authorities authorities = new Authorities();
			authorities.setUsers(users);
			if (check == 1) {
				authorities.setAuthority("ROLE_HADMIN");
			} else if (check == 2) {
				authorities.setAuthority("ROLE_SYSADMIN");
			}

			userService.addauthority(authorities);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "registerUser";
	}
}
