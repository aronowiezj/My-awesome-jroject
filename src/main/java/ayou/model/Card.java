package ayou.model;

import java.util.Observable;

import ayou.controller.Finger;

public class Card extends Observable {

	public static final int IMG_SIZE_X = 30;
	public static final int IMG_SIZE_Y = 30;

	private int idCard;
	private String name;
	private String idImg;

	private int power;
	private int powerBuffs;
	private int maxHitPoints;
	private int lifeBuffs;
	private int hitPoints;

	private boolean canAttack;// can attack or never attack
	private boolean celerity;
	private int healAlly;
	private boolean healAllAllies;
	private int buffAlly;
	private boolean buffAllAllies;

	public void setName(String name) {
		this.name = name;
	}

	private int debuffEnemy;
	private boolean debuffAllEnemies;
	private int cout = 0;

	public int getCout() {
		return cout;
	}

	private boolean engagment = true;

	public Card(int idCard, String name, String idImg, int power, int maxHitPoints, boolean canAtk, boolean celerity,
			int healAlly, boolean healAllAllies, int buffAlly, boolean buffAllAllies, int debuffEnemy,
			boolean debuffAllEnemies, int cout) {
		this.idCard = idCard;
		this.name = name;
		this.idImg = "test";
		this.power = power;
		this.maxHitPoints = maxHitPoints;
		this.hitPoints = maxHitPoints;
		this.name = name;
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
		this.engagment = !celerity;
		this.cout = cout;

	}

	public Card(int idCard, String name, String idImg) {
		this.idCard = idCard;
		this.name = name;
		this.idImg = "test";
		this.power = 0;
		this.maxHitPoints = 0;
		this.hitPoints = 0;
		this.name = name;
		this.powerBuffs = 0;
		this.lifeBuffs = 0;
		this.canAttack = false;
		this.celerity = false;
		this.healAlly = 0;
		this.healAllAllies = false;
		this.buffAlly = 0;
		this.buffAllAllies = false;
		this.debuffEnemy = 0;
		this.debuffAllEnemies = false;
		this.engagment = true;
	}

	public Card() {

	}

	public void lockable() {
		setChanged();
		notifyObservers(0);
	}

	public void nonlockable() {
		setChanged();
		notifyObservers(1);
	}

	public void buffable() {
		setChanged();
		notifyObservers(5);
	}

	public void nonBuffable() {
		setChanged();
		notifyObservers(6);
	}

	public int getCardID() {
		return idCard;
	}

	public void attack(Card targetCard) {
		if (canAttack) {
			targetCard.setHitPoints(getPower());
			setHitPoints(targetCard.getPower());
		}
	}

	public boolean canAttaque() {
		return canAttack;
	}

	public boolean isCelerity() {
		return celerity;
	}

	public void setCelerity(boolean celerity) {
		this.celerity = celerity;
	}

	public int getPower() {
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
		if (hitPoints <= 0) {
			if (GameLoop.getInstance().getPlayer1().getCardsOnBoard().contains(this)) {
				GameLoop.getInstance().getPlayer1().getBoard().removeCard(this);
			} else {
				GameLoop.getInstance().getPlayer2().getBoard().removeCard(this);
			}
		}

		setChanged();
		notifyObservers(2);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " : " + getPower() + " - " + hitPoints;
	}

	public void getHealed(int heal) {
		if (this.hitPoints + heal < this.maxHitPoints + this.lifeBuffs) {
			hitPoints += heal;
		} else {
			hitPoints = maxHitPoints + this.lifeBuffs;
		}
		setChanged();
		notifyObservers(2);
	}

	public void getpowerBuffed(int buff) {
		powerBuffs += buff;
		if ((powerBuffs + power) < 0) {
			powerBuffs = -power;
		}
		setChanged();
		notifyObservers(3);
	}

	public void invocation(Player player) {
		System.out.println("invocation");
		Player enemy;
		if (player == GameLoop.getInstance().getPlayer1()) {
			enemy = GameLoop.getInstance().getPlayer2();
		} else {
			enemy = GameLoop.getInstance().getPlayer1();
		}
		if (healAlly > 0) {
			if (healAllAllies) {
				for (Card card : player.getCardsOnBoard()) {
					card.getHealed(healAlly);
				}
			} else if (!player.isBoardEmpty()) {
				for (Card card : player.getCardsOnBoard()) {
					card.buffable();
				}
				Finger.selectCard(player.getCardsOnBoard()).getHealed(healAlly);
				for (Card card : player.getCardsOnBoard()) {
					card.nonBuffable();
				}
			}
		}
		if (debuffEnemy > 0) {
			if (debuffAllEnemies) {
				for (Card card : enemy.getCardsOnBoard()) {
					card.getpowerBuffed(-debuffEnemy);
				}
			} else if (!enemy.isBoardEmpty()) {
				Finger.selectCard(GameLoop.getInstance().getPlayer2().getCardsOnBoard()).getpowerBuffed(-debuffEnemy);
			}
		}
		if (buffAlly > 0) {
			if (buffAllAllies) {
				for (Card card : player.getCardsOnBoard()) {
					card.getpowerBuffed(buffAlly);
				}
			} else if (!player.isBoardEmpty()) {
				for (Card card : player.getCardsOnBoard()) {
					card.buffable();
				}
				Finger.selectCard(player.getCardsOnBoard()).getpowerBuffed(buffAlly);
				for (Card card : player.getCardsOnBoard()) {
					card.nonBuffable();
				}
			}
		}
	}

	public int getLifeBuffs() {
		return lifeBuffs;
	}

	public void setLifeBuffs(int lifeBuffs) {
		this.lifeBuffs = lifeBuffs;
	}

	public int getIdCard() {
		return idCard;
	}

	public String getIdImg() {
		return idImg;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public int getHealAlly() {
		return healAlly;
	}

	public boolean isHealAllAllies() {
		return healAllAllies;
	}

	public int getBuffAlly() {
		return buffAlly;
	}

	public boolean isBuffAllAllies() {
		return buffAllAllies;
	}

	public int getDebuffEnemy() {
		return debuffEnemy;
	}

	public boolean isDebuffAllEnemies() {
		return debuffAllEnemies;
	}

	public boolean isDead() {
		return hitPoints <= 0;
	}

	public boolean isEngaged() {
		return engagment;
	}

	public void setEngagment(boolean engagment) {
		this.engagment = engagment;
		setChanged();
		notifyObservers(4);
	}

}
