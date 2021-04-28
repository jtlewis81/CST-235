package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Verse;

@Stateless
@Local(DataAccessInterface.class)
@LocalBean
@Alternative
public class DataAccessService implements DataAccessInterface {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String dbURL = "jdbc:mysql://localhost:3306/kjvbible?useSSL=false";
	String username = "root";
	String pword = "root";
	

	@Override
	public List<Verse> getAllVerses() {
		ArrayList<Verse> posts = new ArrayList<Verse>();
        try {
			conn = DriverManager.getConnection(dbURL, username, pword);
            stmt = conn.prepareStatement("SELECT * FROM bible");
            rs = stmt.executeQuery();
            while(rs.next()) {
            	Verse temp = new Verse();
            	temp.setBook_name(rs.getString("book"));
            	temp.setChapter(rs.getInt("chapter"));
            	temp.setVerse(rs.getInt("verse"));
            	temp.setText(rs.getString("text"));
            	posts.add(temp);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return posts;
	}
	
	@Override
	public Verse getVerse(String book_name, int c, int v) {
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("SELECT * FROM bible WHERE book = ? AND chapter = ? AND verse = ?");
	        stmt.setString(1, book_name);
	        stmt.setInt(2, c);
	        stmt.setInt(3, v);
	        rs = stmt.executeQuery();
        	Verse verse = new Verse();
	        while(rs.next()) {
	        	verse.setBook_name(book_name);
	        	verse.setChapter(c);
	        	verse.setVerse(v);
	        	verse.setText(rs.getString("text"));
	        }
	        System.out.println("Returning Verse " + verse.getText());
	        return verse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Verse findFirst(String term) {
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("SELECT * FROM bible WHERE text LIKE ?");
	        stmt.setString(1, "%" + term + "%");
	        rs = stmt.executeQuery();
        	Verse verse = new Verse();
	        if(rs.next()) {
	        	verse.setBook_name(rs.getString("book"));
	        	verse.setChapter(rs.getInt("chapter"));
	        	verse.setVerse(rs.getInt("verse"));
	        	verse.setText(rs.getString("text"));
	        }
	        return verse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount(String term) {
		try {
			conn = DriverManager.getConnection(dbURL, username, pword);
			stmt = conn.prepareStatement("SELECT * FROM bible WHERE text LIKE ?");
	        stmt.setString(1, "%" + term + "%");
	        rs = stmt.executeQuery();
	        int count = 0;
	        while(rs.next()) {
	        	count++;
	        }
	        return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// Useful for debugging
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
