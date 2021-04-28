package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;

@ManagedBean
@SessionScoped
public class Verse implements Serializable {
	
	private static final long serialVersionUID = 1;
	@NotNull()
	private String book_name;
	@NotNull()
	private int chapter;
	@NotNull()
	private int verse;
	@NotNull()
	private String text;
	
	/**
	 * 
	 */
	public Verse() {
		
	}
	
	/**
	 * 
	 * @param v
	 * @param t
	 */
	public Verse(String book_name, int c, int v, String t) {
		this.book_name = book_name;
		this.chapter = c;
		this.verse = v;
		this.text = t;
	}
	
	/**
	 * @return the book_name
	 */
	public String getBook_name() {
		return book_name;
	}

	/**
	 * @param book_name the book_name to set
	 */
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	/**
	 * @return the chapter
	 */
	public int getChapter() {
		return chapter;
	}

	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	/**
	 * @return the verse
	 */
	public int getVerse() {
		return verse;
	}
	
	/**
	 * @param verse the verse to set
	 */
	public void setVerse(int verse) {
		this.verse = verse;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
