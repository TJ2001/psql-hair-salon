import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Stylist {
	public String artist;
	public String detail;
	private int id;

	public Stylist(String artist, String detail) {
		this.artist = artist;
		this.detail = detail;
	}

	public String getArtist() {
		return artist;
	}

	public String getDetail() {
		return detail;
	}

	public int getId() {
		return id;
	}

	public static List<Stylist> all() {
		String sql = "SELECT * FROM stylists ORDER BY artist;";
		try(Connection con = DB.sql2o.open()) {
			return con.createQuery(sql).executeAndFetch(Stylist.class);
		}
	}

	public List<Client> getClients() {
		try(Connection con = DB.sql2o.open()) {
			String sql = "SELECT * FROM clients where stylistId=:id;";
			return con.createQuery(sql)
			.addParameter("id", this.id)
			.executeAndFetch(Client.class);
		}
	}

	public static Stylist find(int id) {
		try(Connection con = DB.sql2o.open()) {
			String sql = "SELECT * FROM stylists WHERE id=:id;";
			Stylist stylist = con.createQuery(sql)
			.addParameter("id", id)
			.executeAndFetchFirst(Stylist.class);
			return stylist;
		}
	}

	public void save() {
		try(Connection con = DB.sql2o.open()) {
			String sql = "INSERT INTO stylists(artist, detail) VALUES (:artist, :detail);";
			this.id = (int) con.createQuery(sql, true)
			.addParameter("artist", this.artist)
			.addParameter("detail", this.detail)
			.executeUpdate()
			.getKey();
		}
	}

	@Override
	public boolean equals(Object otherStylist) {
		if(!(otherStylist instanceof Stylist)) {
			return false;
		} else {
			Stylist newStylist = (Stylist) otherStylist;
			return this.getArtist().equals(newStylist.getArtist()) &&
			this.getDetail().equals(newStylist.getDetail()) &&
			this.getId() == newStylist.getId();
		}
	}

	public void update(String artist, String detail) {
		try(Connection con = DB.sql2o.open()) {
			String sql = "UPDATE stylists SET artist = :artist WHERE id=:id; detail = :detail WHERE id=:id; UPDATE clients SET email = :email WHERE id=:id;";
			con.createQuery(sql)
			.addParameter("artist", artist)
			.addParameter("detail", detail)
			.addParameter("id", id)
			.executeUpdate();
		}
	}

	public void delete() {
		try(Connection con = DB.sql2o.open()) {
			String sql = "DELETE FROM stylists WHERE id=:id;";
			con.createQuery(sql)
			.addParameter("id", id)
			.executeUpdate();
		}
	}
}
