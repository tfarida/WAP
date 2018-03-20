package wap.guessme.models;
/**
 * **
 * @author titin: 
 * Desription: bean to model game player;
 *
 */
public class GamePlayer {
	private int id;
	private Game game;
	private Gamer gamer;
	private int pickedNumber;
	private boolean winStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	public int getPickedNumber() {
		return pickedNumber;
	}
	public void setPickedNumber(int pickedNumber) {
		this.pickedNumber = pickedNumber;
	}
	public boolean isWinStatus() {
		return winStatus;
	}
	public void setWinStatus(boolean winStatus) {
		this.winStatus = winStatus;
	}
	
	
	
	
	
	
	
	

}
