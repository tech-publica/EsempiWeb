package it.epicode.web.mvc.model;

public class Impiegato {
	private long id;
	private String firstname;
	private String lastname;
	private String role;

	public Impiegato() {
	}

	public Impiegato(long id, String firstname, String lastname, String role) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
