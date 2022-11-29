package com.ssafy.culture.dto;

//사용자의 정보입니다.
public class User {
	private long user_id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String token;

	public User() {
		super();
	}

	public User(long user_id, String username, String password, String nickname, String email, String token) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.token = token;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", nickname="
				+ nickname + ", email=" + email + ", token=" + token + "]";
	}

}
