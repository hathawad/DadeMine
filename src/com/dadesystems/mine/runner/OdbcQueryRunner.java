package com.dadesystems.mine.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.dadesystems.mine.MineProperties;
import com.dadesystems.mine.ResultWriter;

public class OdbcQueryRunner extends QueryRunner {
	private Connection connection;

	public OdbcQueryRunner(ResultWriter writer) {
		super(writer);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:"
					+ MineProperties.getOdbcQueryRunnerOdbcString());
		} catch (Exception e) {
			System.err.println("Error with OdbcQueryRunner initalization.");
			e.printStackTrace();
		}

	}

	@Override
	public void runQuery(String query) {
		ResultSet rs;

		try {
			Statement statement = connection.createStatement();
			// sql = "";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				for (String col : MineProperties
						.getOdbcQueryRunnerColumnOrder()) {
					writer.writeElement(rs.getString(col));
				}
				writer.endLine();
			}

		} catch (SQLException e) {

			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

}
