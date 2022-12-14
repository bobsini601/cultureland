package com.ssafy.culture.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ssafy.culture.dao.UserDao;
import com.ssafy.culture.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	@Value("${spring.mail.username}")
	private String serverEmail;
	
	@Value("${spring.mail.password}")
	private String serverPassword;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public int addUser(User user) throws SQLException {
		return userDao.insertUser(user);
	}

	@Override
	public User login(User user) throws SQLException {
		return userDao.selectUser(user);
	}

	@Override
	public User getUser(long userId) throws SQLException {
		return userDao.userInfo(userId);
	}

	@Override
	public int removeUser(long userId) throws SQLException {
		return userDao.deleteUser(userId);
	}

	@Override
	public String findId(Map<String, String> userinfo) throws SQLException {
		return userDao.selectId(userinfo);
	}
	
	@Override
	public User findPassword(Map<String,String> request) throws SQLException {
		return userDao.selectPassword(request);
	}

	@Override
	public int modifyUser(User user) throws SQLException {
		return userDao.updateUser(user);
	}
	
	@Override
	public int modifyUserPassword(User user) throws SQLException {
		return userDao.updateUserPassword(user);
	}

	@Override
	public void saveRefreshToken(long userId, String refreshToken) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("userId", Long.toString(userId));
		map.put("token", refreshToken);
		userDao.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(long userId) {
		return null;
	}

	@Override
	public void deleRefreshToken(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		
	}

	@Override
	public User getByUserName(String username) throws SQLException {
		return userDao.selectUserName(username);
	}

	@Override
	public void sendEmail(User user) throws SQLException {
		Random random = new Random();
		String testPw = "";
		for (int i = 0; i < 6; i++) {
			testPw += random.nextInt(9)+1;
		}
		System.out.println("??????????????????? >> " + testPw);
		// Mail Server ??????
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //????????? ????????? smtp.naver.com
		String hostSMTPid = serverEmail;
		String hostSMTPpwd = serverPassword ;
		
		System.out.println(hostSMTPid);
		System.out.println(hostSMTPpwd);
		// ????????? ?????? EMail, ??????, ??????
		String fromEmail = serverEmail;
		String fromName = "culture land";
		String subject = "";
		String msg = "";

		subject = "culture land ?????? ???????????? ?????????.";
		msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
		msg += "<h3 style='color: blue;'>";
		msg += user.getNickname() + "?????? ?????? ???????????? ?????????. ??????????????? ???????????? ???????????????.</h3>";
		msg += "<p>?????? ???????????? : ";
		msg += testPw + "</p></div>";
		
		// ?????? ?????? E-Mail ??????
		String mail = user.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465);

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("???????????? ?????? : " + e);
		}
		
		user.setPassword(testPw);
		modifyUserPassword(user);
	}
	
	
}
