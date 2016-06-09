package ayou.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import ayou.model.CardEntity;

public interface CardDao {

	@SqlUpdate("DROP TABLE IF EXISTS cards;")
	void deleteCardTable();
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS cards ("
			+ "id integer PRIMARY KEY"
			+ ", name varchar(64)"
			+ ", idImg varchar(64)"
			+ ", power integer"
			+ ", maxHitPoints integer"
			+ ", canAtk boolean"
			+ ", celerity boolean"
			+ ", healAlly integer"
			+ ", healAllAlly boolean"
			+ ", buffAlly integer"
			+ ", buffAllAlly boolean"
			+ ", debuffEnemy integer"
			+ ", debuffAllEnemies boolean"
			+ ", cout integer)")
	void createCardTable();

	@SqlUpdate("INSERT INTO cards (name, idImg, power, maxHitPoints, canAtk, celerity, healAlly, healAllAlly, buffAlly, buffAllAlly, debuffEnemy, debuffAllEnemies, cout) values (:name, :idImg, :power, :maxHitPoints, :canAtk, :celerity, :healAlly, :healAllAlly, :buffAlly, :buffAllAlly, :debuffEnemy, :debuffAllEnemies, :cout)")
	@GetGeneratedKeys
	int insert(@BindBean() CardEntity card);

	@SqlQuery("select * from cards where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	CardEntity findCardById(@Bind("id") int id);
	
	@SqlQuery("SELECT COUNT(*) FROM cards")
	@RegisterMapperFactory(BeanMapperFactory.class)
	int countCard();
	
	void close();
	
	@SqlQuery("select * from cards order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<CardEntity> allCards();
}
