package edu.bnu.hmss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bnu.hmss.dao.GenericDAO;
import edu.bnu.hmss.entity.Authorities;
import edu.bnu.hmss.entity.Employee;
import edu.bnu.hmss.entity.Hotel;
import edu.bnu.hmss.entity.Users;

@Service
public class userService {
	@Autowired
	private GenericDAO genericDAO;

	public void addauthority(Authorities authorities) throws Exception {
		// TODO Auto-generated method stub

		genericDAO.insertOrUpdate(authorities);
	}

	public void addUsers(Users users) throws Exception {
		// TODO Auto-generated method stub

		genericDAO.insertOrUpdate(users);
	}

	public List<Users> getpendingUsers(byte enabled) throws Exception {
		Users users = new Users();
		users.setEnabled(enabled);

		return genericDAO.findByExample(users);
	}

	// public List<Users> getblockedUsers(byte block) throws Exception {
	// Users users = new Users();
	// byte enabled = 1;
	// users.setEnabled(enabled);
	// users.setBlock(block);
	// return genericDAO.findByExample(users);
	// }

	public List<Users> getAllUsers() throws Exception {

		return genericDAO.findAll(Users.class);
	}

	@Transactional
	public List<Users> getUsersByName(String username) throws Exception {

		return genericDAO.findByNamedQuery("getUser", username);
	}

	public void updateUserStatus(Users users) throws Exception {
		genericDAO.insertOrUpdate(users);
	}

	public void addHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub

		genericDAO.insertOrUpdate(hotel);
	}

	// <-------------------------------------------------------------------------->
	// public List<Institute> getblockedInstitute(byte block) throws Exception {
	//
	// Institute institute = new Institute();
	// institute.setBlock(block);
	// institute.setPending(1);
	// return genericDAO.findByExample(institute);
	// }
	//
	// public List<Institute> getpendingInstitute(byte enabled) throws Exception
	// {
	// Institute institute = new Institute();
	// institute.setBlock(0);
	// institute.setPending(enabled);
	//
	// return genericDAO.findByExample(institute);
	// }
	//
	public List<Hotel> getAllInstitute() throws Exception {
		// TODO Auto-generated method stub
		return genericDAO.findAll(Hotel.class);
	}

	//
	// public List<Institute> getAllInstitutes() throws Exception {
	// Institute institute = new Institute();
	// institute.setPending(1);
	// institute.setBlock(0);
	// return genericDAO.findByExample(institute);
	// }
	//
	// public void updateInstituteStatus(Institute institute) throws Exception {
	// genericDAO.insertOrUpdate(institute);
	//
	// }
	//
	// //
	// <-------------------------------------------------------------------------->
	// public void updateKeywordStatus(Keywords keywords) throws Exception {
	// genericDAO.insertOrUpdate(keywords);
	//
	// }
	//
	// public List<Keywords> getAllKeywords() throws Exception {
	// // TODO Auto-generated method stub
	// Keywords keywords = new Keywords();
	// keywords.setBlock(0);
	// return genericDAO.findByExample(keywords);
	// }
	//
	// public List<Keywords> getblockedKeywords(byte block) throws Exception {
	// Keywords keywords = new Keywords();
	// keywords.setBlock(block);
	// return genericDAO.findByExample(keywords);
	// }
	//
	// public void addKeywords(Keywords keywords) throws Exception {
	// genericDAO.insertOrUpdate(keywords);
	// }
	//
	// //
	// <-------------------------------------------------------------------------->
	// public List<Domain> getAllDomains() throws Exception {
	// Domain domain = new Domain();
	// domain.setBlock(0);
	// return genericDAO.findByExample(domain);
	// }
	//
	// public void addDomain(Domain domain) throws Exception {
	// genericDAO.insertOrUpdate(domain);
	// }
	//
	// public List<Domain> getblockedDomain(byte block) throws Exception {
	// Domain domain = new Domain();
	// domain.setBlock(block);
	// return genericDAO.findByExample(domain);
	// }
	//
	// public void updateDomainStatus(Domain domain) throws Exception {
	// genericDAO.insertOrUpdate(domain);
	//
	// }
	//

	@SuppressWarnings("unchecked")
	public List<Hotel> getAllInstitute(String username) throws Exception {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUsername(username);
		return genericDAO.findByNamedQuery("getHotelId", username);
	}

	public void addEmp(Employee institute) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(institute);
	}

	public List<Employee> getAllEmp(String username) throws Exception {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setUsername(username);
		return (List<Employee>) genericDAO.findAll(Employee.class);
	}

}
