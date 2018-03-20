package wap.guessme.models;

import java.util.Date;

/**
 * **
 * @author titin: 
 * Desription: bean to model user login/logout log
 *
 */

public class GamerLog {
	private int id;
	private Gamer gamer;
	private String sessionId;
	private Date loginAt;
	private Date logouAt;
	boolean activeStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getLoginAt() {
		return loginAt;
	}
	public void setLoginAt(Date loginAt) {
		this.loginAt = loginAt;
	}
	public Date getLogouAt() {
		return logouAt;
	}
	public void setLogouAt(Date logouAt) {
		this.logouAt = logouAt;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	
	
	

}
