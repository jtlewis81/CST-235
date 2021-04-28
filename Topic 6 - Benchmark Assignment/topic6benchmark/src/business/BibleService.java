package business;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import beans.Verse;
import database.DataAccessInterface;

@Stateless
@Local(BibleServiceInterface.class)
@LocalBean
@Alternative
public class BibleService implements BibleServiceInterface {

	@Inject
	DataAccessInterface db;
	
	@Override
	public Verse getVerse(String book_name, int chapter, int verse) {
		return db.getVerse(book_name, chapter, verse);
	}

	@Override
	public List<Verse> getAllVerses() {
		return db.getAllVerses();
	}

	@Override
	public Verse findFirst(String term) {
		return db.findFirst(term);
	}

	@Override
	public int getCount(String term) {
		return db.getCount(term);
	}

}
