package it.epicode.web.mvc.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.epicode.web.mvc.model.Impiegato;

public class ImpiegatoRepository implements AbstractImpiegatoRepository {

	private static final String INSERT_EMPLOYEE = "insert into epic_schema.employee (id, firstname, lastname, role) values(?,?,?,?)";
	private static final String QUERY_LIST_EMPLOYEES = "select id, firstname, lastname, role from epic_schema.employee";

	@Override
	public Impiegato inserisciImpiegato(Impiegato nuovoImpiegato) throws DataException {
		try (Connection con = ConnectionSource.createConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE)) {
			ps.setLong(1, nuovoImpiegato.getId());
			ps.setString(2, nuovoImpiegato.getFirstname());
			ps.setString(3, nuovoImpiegato.getLastname());
			ps.setString(4, nuovoImpiegato.getRole());
			ps.executeUpdate();
			return nuovoImpiegato;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

	}

	@Override
	public List<Impiegato> listaImpiegati() throws DataException {
		try (Connection con = ConnectionSource.createConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(QUERY_LIST_EMPLOYEES)) {
			List<Impiegato> le = new ArrayList<>();
			while(rs.next()) {
				le.add(new Impiegato(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("role")));
			}
			return le;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

}
