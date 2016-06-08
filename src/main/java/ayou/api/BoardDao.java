package ayou.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import ayou.model.Board;

import java.util.List;

public interface BoardDao {
	@SqlUpdate("create table boards (id integer primary key autoincrement, int card1, int card2, int card3, int card4, int card5, int card6, int card7, int card8, int card9, int card10)")
	void createBoardTable();

	@SqlUpdate("insert into boards (card1, card2, card3, card4, card5, card6, card7, card8, card9, card10) values (null, null, null, null, null, null, null, null, null, null)")
	@GetGeneratedKeys
	int insert(@BindBean() Board board);

	@SqlUpdate("drop table if exists boards")
	void dropBoardsTable();

	@SqlQuery("select * from boards order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Board> allBoards();

	@SqlQuery("select * from boards where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Board findById(@Bind("id") int id);
	
	@SqlUpdate("insert into boards (card1, card2, card3, card4, card5, card6, card7, card8, card9, card10) values (null, null, null, null, null, null, null, null, null, null)")
	void insert(@Bind("idPlayer") int idPlayer);

	void close();
}
