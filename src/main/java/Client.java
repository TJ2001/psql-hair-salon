import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
	private String name;
	private String detail;
	private String email;
	private String phoneNumber;
	private int id;
	private int stylistId;

	public Client(String name, String detail, String email, String phoneNumber, int stylistId) {
		this.name = name;
		this.detail = detail;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.stylistId = stylistId;
	}

	public String getName() {
		return name;
	}

	public String getDetail() {
		return detail;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getStylistId() {
		return stylistId;
	}

	public int getId() {
		return id;
	}

	public static List<Client> all() {
		String sql = "SELECT * FROM clients;";
		try(Connection con = DB.sql2o.open()) {
			return con.createQuery(sql).executeAndFetch(Client.class);
		}
	}

	public void save() {
		try(Connection con = DB.sql2o.open()) {
			String sql = "INSERT INTO clients(name, detail, email, phoneNumber, stylistId) VALUES (:name, :detail, :email, :phoneNumber, :stylistId);";
			this.id = (int) con.createQuery(sql, true)
			.addParameter("detail", this.detail)
			.addParameter("email", this.email)
			.addParameter("phoneNumber", this.phoneNumber)
			.addParameter("stylistId", this.stylistId)
			.addParameter("name", this.name)
			.executeUpdate()
			.getKey();
		}
	}

	public static Client find(int id) {
		try(Connection con = DB.sql2o.open()) {
			String sql = "SELECT * FROM clients WHERE id=:id;";
			Client client = con.createQuery(sql)
			.addParameter("id", id)
			.executeAndFetchFirst(Client.class);
			return client;
		}
	}

	public void delete() {
		try(Connection con = DB.sql2o.open()) {
			String sql = "DELETE FROM clients WHERE id=:id;";
			con.createQuery(sql)
			.addParameter("id", id)
			.executeUpdate();
		}
	}

	public void update(String detail, String email, String phoneNumber) {
		try(Connection con = DB.sql2o.open()) {
			String sql = "UPDATE clients SET detail = :detail WHERE id=:id; UPDATE clients SET email = :email WHERE id=:id; UPDATE clients SET phoneNumber = :phoneNumber WHERE id=:id";
			con.createQuery(sql)
			.addParameter("detail", detail)
			.addParameter("email", email)
			.addParameter("phoneNumber", phoneNumber)
			.addParameter("id", id)
			.executeUpdate();
		}
	}

	@Override
	public boolean equals(Object otherClient) {
		if(!(otherClient instanceof Client)) {
			return false;
		} else {
			Client newClient = (Client) otherClient;
			return this.getName().equals(newClient.getName()) &&
			this.getDetail().equals(newClient.getDetail()) &&
			this.getEmail().equals(newClient.getEmail()) &&
			this.getPhoneNumber().equals(newClient.getPhoneNumber()) &&
			this.getId() == newClient.getId() &&
			this.getStylistId() == newClient.getStylistId();
		}
	}
}
