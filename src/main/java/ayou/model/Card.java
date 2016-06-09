package ayou.model;

/**
 * @author aronowij
 *
 */
public class Card {

	public static final int IMG_SIZE_X = 30;
	public static final int IMG_SIZE_Y = 30;

	private int idCard;
	private String name;
	private String idImg;

	private int power;
	private int powerBuffs;
	private int maxHitPoints;
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

	public Card(int idCard, String name, String idImg, int power, int maxHitPoints, boolean canAtk, boolean celerity,
			int healAlly, boolean healAllAllies, int buffAlly, boolean buffAllAllies, int debuffEnemy,
			boolean debuffAllEnemies) {
		this.idCard = idCard;
		this.name = name;
		this.idImg = "test";
		this.power = power;
		this.maxHitPoints = maxHitPoints;
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
		this.canAttack = canAtk;
		this.celerity = celerity;
		this.healAlly = healAlly;
		this.healAllAllies = healAllAllies;
		this.buffAlly = buffAlly;
		this.buffAllAllies = buffAllAllies;
		this.debuffEnemy = debuffEnemy;
		this.debuffAllEnemies = debuffAllEnemies;
		canAttack = celerity;
	}

	public Card(){
		
	}
	
	public int getCardID() {
		return idCard;
	}

	public void attack(Card targetCard) {
		if (canAttack) {
			targetCard.setHitPoints(getpower());
			setHitPoints(targetCard.getpower());
		}
	}
	
	public boolean canAttaque(){
		return canAttack;
	}
	
	public void nowCanAttaque(boolean canAttack){
		this.canAttack=canAttack;
	}

	public int getpower() {
		return power + powerBuffs;
	}

	public int getMaxHitPoints() {
		return maxHitPoints + lifeBuffs;
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
		return name + " : " + getpower() + " - " + hitPoints;
	}

	public void getHealed(int heal) {
		if (this.hitPoints + heal < this.maxHitPoints) {
			hitPoints += heal;
		} else {
			hitPoints = maxHitPoints;
		}
	}

	// @copyright
	public void getpowerBuffed(int buff) {
		powerBuffs += buff;
		if ((powerBuffs + power) < 0) {
			powerBuffs = -power;
		}
	}

	public void invocation(Player player) {
		Player enemy;
		if (player == GameLoop.getInstance().getPlayer1()) {
			enemy = GameLoop.getInstance().getPlayer2();
		} else {
			enemy = GameLoop.getInstance().getPlayer1();
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
					card.getpowerBuffed(-debuffEnemy);
				}
			} else {

			}
		}
		if (buffAlly > 0) {
			if (buffAllAllies) {
				for (Card card : player.getBoard()) {
					card.getpowerBuffed(buffAlly);
				}
			} else {

			}
		}

	}
}
