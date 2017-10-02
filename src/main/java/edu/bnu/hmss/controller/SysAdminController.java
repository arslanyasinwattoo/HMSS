package edu.bnu.hmss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.bnu.hmss.entity.Employee;
import edu.bnu.hmss.entity.Hotel;
import edu.bnu.hmss.entity.Users;
import edu.bnu.hmss.service.userService;

@Controller
public class SysAdminController {
	@Autowired
	private userService userService;

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/pendingUsers")
	public String SysAdminUsers(Model model) {
		List<Users> pendingUsers = new ArrayList<>();
		// List<Users> blockedUsers = new ArrayList<>();
		try {
			byte enabled = 0;
			// byte block = 1;
			// blockedUsers = userService.getblockedUsers(block);
			pendingUsers = userService.getpendingUsers(enabled);

			// for (Users users : blockedUsers) {
			// System.out.println(users.getUsername());
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		model.addAttribute("pendingList", pendingUsers);
		// model.addAttribute("blockedList", blockedUsers);

		// logger.info("Going to Load Login Form");
		return "sysadmin-pendingUsers";
	}

	@RequestMapping(value = "/sysadmin/ListUsers")
	public String SysAdminListOfUsers(Model model) {
		List<Users> listOfUsers = new ArrayList<>();
		try {
			listOfUsers = userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfUsers", listOfUsers);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListUsers";
	}

	@RequestMapping(value = "/sysadmin/updateUsersStatus", method = RequestMethod.GET)
	public String SysAdminUpdateUsersStatus(Model model,
			@RequestParam(required = false) String username, byte enabled,
			int check) {
		String url = "";
		Users users = new Users();
		List<Users> userList = new ArrayList<>();
		// System.out.println(username);
		try {
			userList = userService.getUsersByName(username);
			for (Users users2 : userList) {
				// System.out.println(users2.getFirstName());
				// System.out.println("usersname" + users2.getUsername());
				users.setUsername(users2.getUsername());
				users.setPassword(users2.getPassword());

			}
			users.setUsername(username);
			// users.setEnabled(block);
			// System.out.println("block:" + block);

			users.setEnabled(enabled);
			// System.out.println("enabled:" + enabled);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			userService.updateUserStatus(users);
			if (check == 1) {
				url = "redirect:/sysadmin/BlockedUsers.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/pendingUsers.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListUsers.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	@RequestMapping(value = "/hadmin/registerHotel")
	public String IniAdminSaveInstitute(Model model,
			@RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("contactNumber") int Cn,
			@RequestParam("address") String address) {
		String url = "";
		// InstituteAdmin admin = new InstituteAdmin();
		// Institute institute = new Institute();
		Hotel institute = new Hotel();
		Users users = new Users();

		institute.setName(name);
		institute.setCity(city);
		institute.setAddress(address);
		institute.setContactNumber(Cn);

		// List<Hotel> instituteList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			users.setUsername(username);
			institute.setUsers(users);
			userService.addHotel(institute);

			// userService.addInstituteAdmin(admin);

			url = "redirect:/hadmin/ManageHotel.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/hadmin/registerEmployee")
	public String HAdminSaveEmp(Model model, @RequestParam("name") String name,
			@RequestParam("city") String city,
			@RequestParam("address") String address,
			@RequestParam("cnic") int cnic, @RequestParam("contactno") int Cn,
			@RequestParam("hotelId") int id,
			@RequestParam("designation") String d) {
		String url = "";
		// InstituteAdmin admin = new InstituteAdmin();
		// Institute institute = new Institute();
		Employee institute = new Employee();
		Users users = new Users();
		Hotel hotel = new Hotel();
		hotel.setHotelId(id);
		institute.setEmpName(name);
		institute.setEmpCity(city);
		institute.setEmpAddress(address);
		institute.setEmpCnic(cnic);
		institute.setEmpContactNo(Cn);
		institute.setHotel(hotel);
		institute.setEmployeeDesignationId(d);
		// List<Hotel> instituteList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			users.setUsername(username);
			institute.setUsers(users);
			userService.addEmp(institute);

			// userService.addInstituteAdmin(admin);

			url = "redirect:/hadmin/ManageHotel.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	// <-------------------------------------------------------->
	// @RequestMapping(value = "/sysadmin/Institute")
	// public String SysAdminInstitues(Model model) {
	// List<Institute> pendingInstitute = new ArrayList<>();
	// List<Institute> blockedInstitute = new ArrayList<>();
	// try {
	// byte enabled = 0;
	// byte block = 1;
	// blockedInstitute = userService.getblockedInstitute(block);
	// pendingInstitute = userService.getpendingInstitute(enabled);
	//
	// for (Institute users : blockedInstitute) {
	// System.out.println(users.getInstituteName());
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("error");
	// }
	// model.addAttribute("pendingList", pendingInstitute);
	// model.addAttribute("blockedList", blockedInstitute);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-Institute";
	// }
	//
	// @RequestMapping(value = "/sysadmin/BlockedInstitute")
	// public String SysAdminBlockedInstitute(Model model) {
	// List<Institute> blockedInstitute = new ArrayList<>();
	// try {
	// byte block = 1;
	// blockedInstitute = userService.getblockedInstitute(block);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("blockedList", blockedInstitute);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-BlockedInstitute";
	// }
	//
	@RequestMapping(value = "/sysadmin/ListHotel")
	public String SysAdminListOfInstitute(Model model) {
		List<Hotel> listOfInstitute = new ArrayList<>();
		try {
			listOfInstitute = userService.getAllInstitute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfInstitute", listOfInstitute);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListHotels";
	}

	@RequestMapping(value = "/hadmin/ListHotels")
	public String hAdminListOfInstitute(Model model) {
		List<Hotel> listOfInstitute = new ArrayList<>();
		try {
			listOfInstitute = userService.getAllInstitute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfInstitute", listOfInstitute);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListHotels";
	}

	@RequestMapping(value = "/hadmin/ManageHotel")
	public String hAdminmanageHotel(Model model) {

		return "hadmin-hotels";
	}

	@RequestMapping(value = "/hadmin/ManageEmployee")
	public String HAdminManageEmployee(Model model) {
		Hotel hotel = new Hotel();
		List<Hotel> listhotel = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			listhotel = userService.getAllInstitute(username);
			// for (Hotel hotel2 : listhotel) {
			// if (username.equalsIgnoreCase(hotel2.getUsers().getUsername())) {
			// hotel.setHotelId(hotel2.getHotelId());
			// }
			// }
			for (Hotel hotel2 : listhotel) {
				System.out.println(hotel2.getHotelId());
				System.out.println(hotel2.getUsers().getUsername());
				hotel.setHotelId(hotel2.getHotelId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hotelId", hotel.getHotelId());
		// logger.info("Going to Load Login Form");
		return "hadmin-employee";
	}

	@RequestMapping(value = "/hadmin/ListEmployee")
	public String hAdminListOfEmployee(Model model) {
		List<Employee> listOfInstitute = new ArrayList<>();
		List<Employee> listEmp = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			System.out.println(username);
			// System.out.println("list showingS");
			listOfInstitute = userService.getAllEmp(username);

			for (Employee employee : listOfInstitute) {
				if (username
						.equalsIgnoreCase(employee.getUsers().getUsername())) {
					listEmp.add(employee);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfEmp", listEmp);
		// logger.info("Going to Load Login Form");
		return "hadmin-ListEmp";
	}
	//
	// @RequestMapping(value = "/sysadmin/updateInstituteStatus", method =
	// RequestMethod.GET)
	// public String SysAdminUpdateInstituteStatus(Model model,
	// @RequestParam(required = false) Long id, String name, byte block,
	// byte enabled, int check) {
	// String url = "";
	// Institute institute = new Institute();
	// List<Institute> instituteList = new ArrayList<>();
	// // System.out.println(username);
	// // System.out.println("block:" + block);
	// institute.setInstituteId(id);
	// institute.setInstituteName(name);
	// institute.setPending(enabled);
	// institute.setBlock(block);
	//
	// try {
	// userService.updateInstituteStatus(institute);
	// if (check == 1) {
	// url = "redirect:/sysadmin/BlockedInstitute.bnu";
	// }
	// if (check == 2) {
	// url = "redirect:/sysadmin/Institute.bnu";
	// }
	// if (check == 3) {
	// url = "redirect:/sysadmin/ListOfInstitute.bnu";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // logger.info("Going to Load Login Form");
	// return url;
	// }

	// <-------------------------------------------------------->
	// @RequestMapping(value = "/sysadmin/Domains")
	// public String SysAdminDomain(Model model) {
	// List<Domain> listOfDomains = new ArrayList<>();
	//
	// try {
	// byte block = 1;
	// // blockedKeywords = userService.getblockedKeywords(block);
	// listOfDomains = userService.getAllDomains();
	// //
	// // for (Keywords users : blockedKeywords) {
	// // System.out.println(users.getKeywordName());
	// // }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("error");
	// }
	//
	// model.addAttribute("ListOfDomain", listOfDomains);
	// // model.addAttribute("blockedList", blockedKeywords);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-Domain";
	// }
	//
	// @RequestMapping(value = "/sysadmin/SaveDomains")
	// public String SysAdminSaveDomain(Model model,
	// @RequestParam("name") String name) {
	// String url = "";
	// Domain domain = new Domain();
	// try {
	// domain.setDomainName(name);
	// userService.addDomain(domain);
	// url = "redirect:/sysadmin/Domains.bnu";
	// // logger.info("Going to Load Login Form");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return url;
	// }
	//
	// @RequestMapping(value = "/sysadmin/BlockedDomains")
	// public String SysAdminBlockedDomains(Model model) {
	// List<Domain> blockedDomain = new ArrayList<>();
	// try {
	// byte block = 1;
	// blockedDomain = userService.getblockedDomain(block);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("blockedList", blockedDomain);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-BlockedDomain";
	// }
	//
	// @RequestMapping(value = "/sysadmin/ListOfDomains")
	// public String SysAdminListOfDomains(Model model) {
	// List<Domain> listOfDomain = new ArrayList<>();
	// try {
	// listOfDomain = userService.getAllDomains();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("ListOfDomain", listOfDomain);
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-ListOfDomain";
	// }
	//
	// @RequestMapping(value = "/sysadmin/updateDomainStatus", method =
	// RequestMethod.GET)
	// public String SysAdminUpdateDomainStatus(Model model,
	// @RequestParam(required = false) Integer id, String name,
	// byte block, int check) {
	// String url = "";
	// Domain domain = new Domain();
	// domain.setDomainId(id);
	// domain.setDomainName(name);
	// domain.setBlock(block);
	//
	// try {
	// userService.updateDomainStatus(domain);
	// if (check == 1) {
	// url = "redirect:/sysadmin/Domains.bnu";
	// }
	// if (check == 2) {
	// url = "redirect:/sysadmin/BlockedDomains.bnu";
	// }
	// if (check == 3) {
	// url = "redirect:/sysadmin/ListOfDomains.bnu";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // logger.info("Going to Load Login Form");
	// return url;
	// }
	//
	// // <-------------------------------------------------------->
	// @RequestMapping(value = "/sysadmin/Keywords")
	// public String SysAdminKeywords(Model model) {
	// List<Keywords> blockedKeywords = new ArrayList<>();
	// List<Keywords> listOfKeywords = new ArrayList<>();
	//
	// try {
	// byte block = 1;
	// // blockedKeywords = userService.getblockedKeywords(block);
	// listOfKeywords = userService.getAllKeywords();
	// //
	// // for (Keywords users : blockedKeywords) {
	// // System.out.println(users.getKeywordName());
	// // }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("error");
	// }
	//
	// model.addAttribute("ListOfKeywords", listOfKeywords);
	// // model.addAttribute("blockedList", blockedKeywords);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-Keywords";
	// }
	//
	// @RequestMapping(value = "/sysadmin/SaveKeywords")
	// public String SysAdminSaveKeywords(Model model,
	// @RequestParam("name") String name) {
	// String url = "";
	// Keywords keywords = new Keywords();
	// try {
	// keywords.setKeywordName(name);
	// userService.addKeywords(keywords);
	// url = "redirect:/sysadmin/Keywords.bnu";
	// // logger.info("Going to Load Login Form");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return url;
	// }
	//
	// @RequestMapping(value = "/sysadmin/BlockedKeywords")
	// public String SysAdminBlockedKeywords(Model model) {
	// List<Keywords> blockedKeywords = new ArrayList<>();
	// try {
	// byte block = 1;
	// blockedKeywords = userService.getblockedKeywords(block);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("blockedList", blockedKeywords);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-BlockedKeywords";
	// }
	//
	// @RequestMapping(value = "/sysadmin/ListOfKeywords")
	// public String SysAdminListOfKeywords(Model model) {
	// List<Keywords> listOfKeywords = new ArrayList<>();
	// try {
	// listOfKeywords = userService.getAllKeywords();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("ListOfKeywords", listOfKeywords);
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-ListOfKeywords";
	// }
	//
	// @RequestMapping(value = "/sysadmin/updateKeywordStatus", method =
	// RequestMethod.GET)
	// public String SysAdminUpdatekeywordStatus(Model model,
	// @RequestParam(required = false) Integer id, String name,
	// byte block, int check) {
	// String url = "";
	// Keywords keywords = new Keywords();
	// keywords.setKeywordsId(id);
	// keywords.setKeywordName(name);
	// keywords.setBlock(block);
	// try {
	// userService.updateKeywordStatus(keywords);
	// if (check == 1) {
	// url = "redirect:/sysadmin/Keywords.bnu";
	// }
	// if (check == 2) {
	// url = "redirect:/sysadmin/BlockedKeywords.bnu";
	// }
	// if (check == 3) {
	// url = "redirect:/sysadmin/ListOfKeywords.bnu";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // logger.info("Going to Load Login Form");
	// return url;
	// }
	//
	// // <-------------------------------------------------------->
	// @RequestMapping(value = "/sysadmin/Technology")
	// public String SysAdminTechnology(Model model) {
	// List<ToolsAndTechnology> blockedTechnology = new ArrayList<>();
	// List<ToolsAndTechnology> listOfTechnology = new ArrayList<>();
	//
	// try {
	// byte block = 1;
	// // blockedKeywords = userService.getblockedKeywords(block);
	// listOfTechnology = userService.getAllTechnology();
	// //
	// // for (Keywords users : blockedKeywords) {
	// // System.out.println(users.getKeywordName());
	// // }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("error");
	// }
	//
	// model.addAttribute("ListOfTechnology", listOfTechnology);
	// // model.addAttribute("blockedList", blockedKeywords);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-Technology";
	// }
	//
	// @RequestMapping(value = "/sysadmin/SaveTechnology")
	// public String SysAdminSaveTechnology(Model model,
	// @RequestParam("name") String name) {
	// String url = "";
	// ToolsAndTechnology technology = new ToolsAndTechnology();
	// try {
	// technology.setToolsAndTechnologyName(name);
	// userService.addTechnology(technology);
	// url = "redirect:/sysadmin/Technology.bnu";
	// // logger.info("Going to Load Login Form");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return url;
	// }
	//
	// @RequestMapping(value = "/sysadmin/BlockedTechnology")
	// public String SysAdminBlockedTechnolgy(Model model) {
	// List<ToolsAndTechnology> blockedTechnology = new ArrayList<>();
	// try {
	// byte block = 1;
	// blockedTechnology = userService.getblockedTechnology(block);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("blockedList", blockedTechnology);
	//
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-BlockedTechnology";
	// }
	//
	// @RequestMapping(value = "/sysadmin/ListOfTechnology")
	// public String SysAdminListOfTechnology(Model model) {
	// List<ToolsAndTechnology> listOfTechnology = new ArrayList<>();
	// try {
	// listOfTechnology = userService.getAllTechnology();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("ListOfTechnology", listOfTechnology);
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-ListOfTechnology";
	// }
	//
	// @RequestMapping(value = "/sysadmin/updateTechnologyStatus", method =
	// RequestMethod.GET)
	// public String SysAdminUpdateTechnologyStatus(Model model,
	// @RequestParam(required = false) Long id, String name, byte block,
	// int check) {
	// String url = "";
	// ToolsAndTechnology technology = new ToolsAndTechnology();
	// technology.setToolsAndTechnologyId(id);
	// technology.setToolsAndTechnologyName(name);
	// technology.setBlock(block);
	//
	// try {
	// userService.updateTechnologyStatus(technology);
	// if (check == 1) {
	// url = "redirect:/sysadmin/Technology.bnu";
	// }
	// if (check == 2) {
	// url = "redirect:/sysadmin/BlockedTechnology.bnu";
	// }
	// if (check == 3) {
	// url = "redirect:/sysadmin/ListOfTechnology.bnu";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // logger.info("Going to Load Login Form");
	// return url;
	// }
	// // <-------------------------------------------------------->

}
