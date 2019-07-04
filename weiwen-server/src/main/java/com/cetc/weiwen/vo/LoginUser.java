package com.cetc.weiwen.vo;

/**
 * 登录用户
 * @author jhl
 * @date 2018年9月6日 下午2:17:43
 * @version 1.0 
 *
 */
public class LoginUser {

	private String username;
    private String password;
    private Integer rememberMe;

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

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
