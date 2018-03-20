package wap.guessme.models;

import java.util.*; 

/**
 * **
 * @author titin: 
 * Desription: bean to model game data
 *
 */
public class Game {
	private int id;
	private Date startTime;
	private Date endTime;
	private List<GamePlayer> players;
	private List<GameHistory> gameHist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<GamePlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<GamePlayer> players) {
		this.players = players;
	}

	public List<GameHistory> getGameHist() {
		return gameHist;
	}

	public void setGameHist(List<GameHistory> gameHist) {
		this.gameHist = gameHist;
	}
	
	
	
	
	
	
	

}
