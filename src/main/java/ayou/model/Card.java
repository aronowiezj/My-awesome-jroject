package ayou.model;
/**
 * @author aronowij
 *
 */
public class Card {

	private final int POWER;
	private int buffs;
	private final int MAX_HIT_POINTS;
	private int hitPoints;
	private String name;

	public Card(int power, int hitPoints, String name) {
		this.POWER = power;
		this.MAX_HIT_POINTS = hitPoints;
		this.hitPoints = hitPoints;
		this.name = name;
		this.buffs = 0;
	}

	public void attack(Card targetCard) {
		targetCard.setHitPoints(getPower());
		setHitPoints(targetCard.getPower());
	}

	public int getPower() {
		return POWER + buffs;
	}

	public int getMaxHitPoints() {
		return MAX_HIT_POINTS;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int damages) {
		hitPoints -= damages;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " : " + getPower() + " - " + hitPoints;
	}

}