package business;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import beans.Verse;
import business.BibleServiceInterface;

@RequestScoped
@Path("/verses")
@Produces("application/json")
@Consumes("application/json")
public class BibleWebService {

	@Inject
	BibleServiceInterface bible;

	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/allverses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verse> getAllVerses() {
		return bible.getAllVerses();
	}
	
	
	/**
	 * 
	 * @param book_name
	 * @param chapter
	 * @param verse
	 * @return
	 */
	@GET
	@Path("/verse")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verse> getVerse(@QueryParam("book_name") String book_name, @QueryParam("chapter") int chapter, @QueryParam("verse") int verse) {
		ArrayList<Verse> requestedVerse = new ArrayList<Verse>();
		requestedVerse.add(bible.getVerse(book_name, chapter, verse));
		return requestedVerse;
	}
	
	/**
	 * 
	 * @param term
	 * @return
	 */
	@GET
	@Path("/first_result")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFirst(@QueryParam("term") String term) {
		Verse v = bible.findFirst(term);
		return v.getBook_name() + " " + v.getChapter() + ":" + v.getVerse();
	}
	
	/**
	 * 
	 * @param term
	 * @return
	 */
	@GET
	@Path("/result_count")
	@Produces(MediaType.APPLICATION_JSON)
	public int getCount(@QueryParam("term") String term) {
		return bible.getCount(term);
	}
}
