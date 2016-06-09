package ayou.model;

public class CardEntity {

	private int idCard;
	private String name;
	private String idImg;

	private int power;
	private int maxHitPoints;
	private int lifeBuffs;
	private int hitPoints;

	private boolean canAtk;
	private boolean celerity;
	private int healAlly;
	private boolean healAllAlly;
	private int buffAlly;
	private boolean buffAllAlly;
	private int debuffEnemy;
	private boolean debuffAllEnemies;
	
	private int cout;
	
	public CardEntity(){
		
	}
	
	public CardEntity(String name, String idImg, int power, int maxHitPoints, boolean canAtk, boolean celerity,
			int healAlly, boolean healAllAlly, int buffAlly, boolean buffAllAllies, int debuffEnemy,
			boolean debuffAllEnemies, int cout) {
		this.name = name;
		this.idImg = idImg;
		this.power = power;
		this.maxHitPoints = maxHitPoints;
		this.hitPoints = maxHitPoints;
		this.canAtk = canAtk;
		this.celerity = celerity;
		this.healAlly = healAlly;
		this.healAllAlly = healAllAlly;
		this.buffAlly = buffAlly;
		this.buffAllAlly = buffAllAllies;
		this.debuffEnemy = debuffEnemy;
		this.debuffAllEnemies = debuffAllEnemies;
		this.cout = cout;
	}
	public String getIdImg() {
		return idImg;
	}

	public void setIdImg(String idImg) {
		this.idImg = idImg;
	}

	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public int getLifeBuffs() {
		return lifeBuffs;
	}

	public void setLifeBuffs(int lifeBuffs) {
		this.lifeBuffs = lifeBuffs;
	}

	public boolean isCanAtk() {
		return canAtk;
	}

	public void setCanAtk(boolean canAttack) {
		this.canAtk = canAttack;
	}

	public boolean isCelerity() {
		return celerity;
	}

	public void setCelerity(boolean celerity) {
		this.celerity = celerity;
	}

	public int getHealAlly() {
		return healAlly;
	}

	public void setHealAlly(int healAlly) {
		this.healAlly = healAlly;
	}

	public boolean isHealAllAlly() {
		return healAllAlly;
	}

	public void setHealAllAlly(boolean healAllAlly) {
		this.healAllAlly = healAllAlly;
	}

	public int getBuffAlly() {
		return buffAlly;
	}

	public void setBuffAlly(int buffAlly) {
		this.buffAlly = buffAlly;
	}

	public boolean isBuffAllAlly() {
		return buffAllAlly;
	}

	public void setBuffAllAlly(boolean buffAllAllies) {
		this.buffAllAlly = buffAllAllies;
	}

	public int getDebuffEnemy() {
		return debuffEnemy;
	}

	public void setDebuffEnemy(int debuffEnemy) {
		this.debuffEnemy = debuffEnemy;
	}

	public boolean isDebuffAllEnemies() {
		return debuffAllEnemies;
	}

	public void setDebuffAllEnemies(boolean debuffAllEnemies) {
		this.debuffAllEnemies = debuffAllEnemies;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

}
