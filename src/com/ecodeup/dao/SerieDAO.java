package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.model.Serie;

public class SerieDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	// guardar serie
	public boolean guardar(Serie serie) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO series (id, nombre, cantidad, precio, fecha_crear,fecha_actualizar) VALUES(?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, null);
			statement.setString(2, serie.getNombre());
			statement.setDouble(3, serie.getCantidad());
			statement.setDouble(4, serie.getPrecio());
			statement.setDate(5, serie.getFechaCrear());
			statement.setDate(6, serie.getFechaActualizar());

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// editar serie
	public boolean editar(Serie serie) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE series SET nombre=?, cantidad=?, precio=?, fecha_actualizar=? WHERE id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, serie.getNombre());
			statement.setDouble(2, serie.getCantidad());
			statement.setDouble(3, serie.getPrecio());
			statement.setDate(4, serie.getFechaActualizar());
			statement.setInt(5, serie.getId());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// eliminar serie
	public boolean eliminar(int idSerie) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM series WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSerie);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	// obtener lista de series
	public List<Serie> obtenerSeries() throws SQLException {
		ResultSet resultSet = null;
		List<Serie> listaSeries = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM series";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Serie p = new Serie();
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getDouble(3));
				p.setPrecio(resultSet.getDouble(4));
				p.setFechaCrear(resultSet.getDate(5));
				p.setFechaActualizar(resultSet.getDate(6));
				listaSeries.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaSeries;
	}

	// obtener serie
	public Serie obtenerSerie(int idSerie) throws SQLException {
		ResultSet resultSet = null;
		Serie p = new Serie();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM series WHERE id =?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSerie);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				p.setId(resultSet.getInt(1));
				p.setNombre(resultSet.getString(2));
				p.setCantidad(resultSet.getDouble(3));
				p.setPrecio(resultSet.getDouble(4));
				p.setFechaCrear(resultSet.getDate(5));
				p.setFechaActualizar(resultSet.getDate(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	// obtener conexion pool
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}
