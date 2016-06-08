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

	public Card(int idCard, String name, String idImg, int power,  int maxHitPoints, 
			 boolean canAtk, boolean celerity, int healAlly, boolean healAllAllies, 
			int buffAlly, boolean buffAllAllies, int debuffEnemy, boolean debuffAllEnemies) {
		this.ID_CARD=idCard;
		this.name = name;
		this.ID_IMG="test";
		this.POWER = power;
		this.MAX_HIT_POINTS = maxHitPoints;
		this.hitPoints = maxHitPoints;
		this.name = name;
		powerBuffs = 0;
		lifeBuffs = 0;
		canAttack = true;
		celerity = false;
		healAlly = 0;
		healAllAllies = false;
		buffAlly = 0;
		buffAllAllies = false;
		debuffEnemy = 0;
		debuffAllEnemies = false;
		this.powerBuffs = 0;
		this.lifeBuffs = 0;
		this.canAttack=canAtk;
		this.celerity=celerity;
		this.healAlly=healAlly;
		this.healAllAllies=healAllAllies;
		this.buffAlly=buffAlly;
		this.buffAllAllies=buffAllAllies;
		this.debuffEnemy=debuffEnemy;
		this.debuffAllEnemies=debuffAllEnemies;
	}

	public void attack(Card targetCard) {
		if (canAttack) {
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
	public void getHealed(int heal) {
		if (this.hitPoints + heal < this.MAX_HIT_POINTS) {
			hitPoints += heal;
		} else {
			hitPoints = MAX_HIT_POINTS;
		}
	}

	// @copyright
	public void getPowerBuffed(int buff) {
		powerBuffs += buff;
		if ((powerBuffs + POWER) < 0) {
			powerBuffs = -POWER;
		}
	}

	public void invocation(Player player) {
		Player enemy;
		if (player == GameLoop.player1) {
			enemy = GameLoop.player2;
		} else {
			enemy = GameLoop.player1;
		}
		if (healAlly > 0) {
			if (healAllAllies) {
				for (Card card : player.getBoard()) {
					card.getHealed(this.healAlly);
				}
			} else {

			}
		}
		if (debuffEnemy > 0) {
			if (debuffAllEnemies) {
				for (Card card : enemy.getBoard()) {
					card.getPowerBuffed(-debuffEnemy);
				}
			}
			else{
				
			}
		}
		if (buffAlly > 0) {
			if (buffAllAllies) {
				for (Card card : player.getBoard()) {
					card.getPowerBuffed(buffAlly);
				}
			}
			else{
				
			}
		}

	}
}
