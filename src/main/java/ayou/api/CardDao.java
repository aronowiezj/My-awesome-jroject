package ayou.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CardDao {

	@SqlUpdate("DROP TABLE IF EXISTS cards;")
	void deleteCardTable();
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS cards (id Integer PRIMARY KEY, nom CHAR(20), ATK Integer, DEF Integer, ideffet1 Integer, ideffet2 Integer, cout Integer, Constraint fk_effet1 foreign key (ideffet1) references effet(id), Constraint fk_effet2 foreign key (ideffet2) references effet(id));")
	void createCardTable();

	@SqlUpdate("INSERT INTO cards VALUES (01, 'Kiran', 5, 15, 0, 0, 1), (02, 'Torren', 4, 10, 0, 0, 0), (03, 'Danir', 3, 8, 0, 0, 0), (04, 'Aponir', 15, 15, 0, 0, 2), (05, 'Balnar', 10, 12, 0, 0, 1),	 (06, 'Agrion', 11, 9, 0, 0, 1),(07, 'Norbert', 4, 4, 0, 0, 0),	 (08, 'Solas', 7, 6, 2, 0, 1),	 (09, 'Muilas', 5, 5, 2, 0, 0), (10, 'Nebin', 6, 5, 0, 0, 0), (11, 'Lego-Das', 4, 5, 1, 0, 0),(12, 'Nahial', 8, 8, 0, 0, 0),(13, 'Liddas', 7, 7, 0, 0, 0), (14, 'Zastal', 6, 8, 0, 0, 0), (15, 'Maro', 5, 5, 3, 0, 0),(16, 'Aper', 4, 5, 3, 0, 0),(17, 'Nepos', 5, 4, 3, 0, 0),(18, 'Grun', 10, 6, 1, 0, 1), (19, 'Herim', 8, 5, 1, 0, 0),(20, 'Corog', 8, 5, 1, 0, 0),(21, 'Fourmiz', 7, 20, 1, 0, 3), (22, 'LadyBio', 9, 9, 4, 3, 3),(23, 'Oushiwa', 20, 3, 5, 0, 3);")
	void fillCardTable();

	@SqlUpdate("DROP TABLE IF EXISTS effects;")
	void deleteEffectTable();
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS effects(id Integer Primary Key, nom Char(20));")
	void createEffectTable();

	@SqlUpdate("INSERT INTO effects VALUES (1, 'initiative'),(2, 'soin'),(3, 'ralliement'),(4, 'entrave'),(5, 'NonMépliiz');")
	void fillEffectTable();
	
	@SqlUpdate("Update cards set ATK = ATK + ")
	void updateCard(@Bind("id") int id, @Bind("buffATK") int buffATK, @Bind("debuffATK") int debuffATK, @Bind("buffDEF") int buffDEF, @Bind("debuffDEF") int debuffDEF);

	void close();
}
