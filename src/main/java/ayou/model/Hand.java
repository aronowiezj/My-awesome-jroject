/**
 * 
 */
package ayou.model;

/**
 * @author aronowij
 *
 */
public class Hand extends CardCollection {
	private boolean played;

	public Hand(Player player) {
		super(player);
	}
	
	public boolean havePlayed(){
		return played;
	}
	
	public void setPlayed(boolean played){
		this.played=played;
	}

}
