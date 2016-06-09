package ayou.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import ayou.model.Board;

import java.util.List;

public interface BoardDao {
	@SqlUpdate("create table boards (id integer primary key autoincrement, j1 varchar(64) , listIdCardJ1 varchar(150), j2 varchar(64) , listIdCardJ2 varchar(150)")
	void createBoardTable();

	@SqlUpdate("drop table if exists boards")
	void dropBoardsTable();
	
	@SqlUpdate("insert into boards (j1, listIdCardJ1, j2, listIdCardJ2) values (null , null, null, null)")
	@GetGeneratedKeys
	int initialize();
	
	@SqlUpdate("update boards set j1 = :playerName where id = :idBoard")
	void insertJ1(@Bind("idBoard") int idBoard, @Bind("playerName") String playerName);
	
	@SqlUpdate("update boards set j2 = :playerName where id = :idBoard")
	void insertJ2(@Bind("idBoard") int idBoard, @Bind("playerName") String playerName);
	
	@SqlUpdate("update boards set listIdCardJ1 = :listName where id = :idBoard")
	void insertListIdCardsJ1(@Bind("idBoard") int idBoard, @Bind("listName") String listName);
	
	@SqlUpdate("update boards set listIdCardJ2 = :listName where id = :idBoard")
	void insertListIdCardsJ2(@Bind("idBoard") int idBoard, @Bind("listName") String listName);

	@SqlQuery("select * from boards order by id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Board> allBoards();

	@SqlQuery("select * from boards where id = :id")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Board findById(@Bind("id") int id);

	void close();
}
