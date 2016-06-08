package ayou.model;
/**
 * @author aronowij
 *
 */
public class Card {

	private final int ID_CARD;
	private String name;
	private final String ID_IMG;
	
	private final int POWER;
	private int powerBuffs;
	private final int MAX_HIT_POINTS;
	private int hitPoints;
	private int lifeBuffs;
	
	private boolean canAttack;
	private boolean celerity;
	private int healAlly;
	private boolean healAllAllies;
	private int buffAlly;
	private boolean buffAllAllies;
	private int debuffEnemy;
	private boolean debuffAllEnemies;
	

	public Card(int power, int hitPoints, String name) {
		this.POWER = power;
		this.MAX_HIT_POINTS = hitPoints;
		this.hitPoints = hitPoints;
		this.name = name;
		ID_CARD=0;
		ID_IMG="test";
		powerBuffs = 0;
		lifeBuffs = 0;
		canAttack=true;
		celerity=false;
		healAlly=0;
		healAllAllies=false;
		buffAlly=0;
		buffAllAllies=false;
		debuffEnemy=0;
		debuffAllEnemies=false;
	}

	public void attack(Card targetCard) {
		if(canAttack){
			targetCard.setHitPoints(getPower());
			setHitPoints(targetCard.getPower());	
		}
	}

	public int getPower() {
		return POWER + powerBuffs;
	}

	public int getMaxHitPoints() {
		return MAX_HIT_POINTS + lifeBuffs;
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
	
	public void getHealed(int heal){
		if(this.hitPoints+heal<this.MAX_HIT_POINTS){
			hitPoints+=heal;
		}
		else{
			hitPoints=MAX_HIT_POINTS;
		}
	}

	public void invocation(Board boardAlly) {
		// TODO Auto-generated method stub
		if(healAlly>0){
			if (healAllAllies) {
				for(Card card: boardAlly.getCards()){
					card.getHealed(this.healAlly);
				}
			}
			else {
				
			}
		}if (debuffEnemy>0) {
			if (debuffAllEnemies) {
				
			}
		}
		
	}

}