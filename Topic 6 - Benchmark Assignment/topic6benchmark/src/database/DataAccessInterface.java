package database;

import java.util.List;

import javax.ejb.Local;
import beans.Verse;

@Local
public interface DataAccessInterface {

	public Verse getVerse(String book_name, int chapter, int verse);

	public List<Verse> getAllVerses();

	public Verse findFirst(String term);

	public int getCount(String term);
}
