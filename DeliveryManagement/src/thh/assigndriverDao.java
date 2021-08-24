package thh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class assigndriverDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/afterpayment?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "19970521";

	private static final String INSERT_ASSIGN_DRIVERS = "INSERT INTO deliverywithdriver" + "  (drivername,time) VALUES "
			+ " ( ?, ?);";

	private static final String SELECT_ASSIGNS = "select deliveryid,drivername,time from deliverywithdriver where deliveryid =?";
	private static final String SELECT_ALL_ASSIGNS = "select * from deliverywithdriver";
	private static final String DELETE_ASSIGNS = "delete from deliverywithdriver where deliveryid = ?;";
	private static final String UPDATE_ASSIGNS = "update deliverywithdriver set drivername = ?,time= ? where deliveryid = ?;";

	public assigndriverDao () {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(DriverBean driverbean) throws SQLException {
		System.out.println(INSERT_ASSIGN_DRIVERS);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSIGN_DRIVERS)) {
			preparedStatement.setString(1, driverbean.getDrivername());
			preparedStatement.setString(2, driverbean.getTime());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public DriverBean selectUser(int deliveryid) {
		DriverBean driverbean = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSIGNS);) {
			preparedStatement.setInt(1, deliveryid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String drivername = rs.getString("drivername");
				String time = rs.getString("time");
				
				driverbean = new DriverBean(deliveryid,drivername,time);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return driverbean;
	}

	public List<DriverBean> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DriverBean> db = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSIGNS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int deliveryid = rs.getInt("deliveryid");
				String drivername = rs.getString("drivername");
				String time = rs.getString("time");
				
				db.add(new DriverBean(deliveryid,drivername,time));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return db;
	}

	public boolean deleteUser(int deliveryid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ASSIGNS);) {
			statement.setInt(1, deliveryid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(DriverBean driverbean) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ASSIGNS);) {
			statement.setString(1, driverbean.getDrivername());
			statement.setString(2, driverbean.getTime());
			
			statement.setInt(3, driverbean.getDeliveryid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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
