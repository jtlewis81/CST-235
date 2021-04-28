package business;

import java.util.List;

import javax.ejb.Local;
import beans.Verse;

@Local
public interface BibleServiceInterface {

	public List<Verse> getAllVerses();
	public Verse getVerse(String book_name, int chapter, int verse);
	public Verse findFirst(String term);
	public int getCount(String term);

}
