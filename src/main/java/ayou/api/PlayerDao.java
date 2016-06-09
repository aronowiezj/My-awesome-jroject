package ayou.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import ayou.model.Board;
import ayou.model.Player;

public interface PlayerDao {
	@SqlUpdate("create table players(id integer primary key autoincrement, name varchar(50))")
	void createPlayersTable();

	@SqlUpdate("insert into players (name) values (:name)")
	@GetGeneratedKeys
	int insert(@BindBean() Player player);

	@SqlUpdate("drop table if exists players")
	void dropBoardsTable();

	@SqlQuery("select * from players order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Player> allPlayers();

	@SqlQuery("select * from players where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Board findById(@Bind("id") int id);

	void close();
}
