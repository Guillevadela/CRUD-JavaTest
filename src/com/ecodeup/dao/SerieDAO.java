package com.ecodeup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ecodeup.conexion.ConnectionManager;
import com.ecodeup.model.Serie;

public class SerieDAO {

	public ArrayList<Serie> getAll() {

		ArrayList<Serie> registros = new ArrayList<Serie>();

		String sql = "SELECT id, nombre FROM serie ORDER BY id DESC; ";

		// String SQL_INSERT = " INSERT INTO producto (nombre, imagen, precio , id_usuario) VALUES ( ? , ?, ? , 1 ) ; ";
		// String SQL_UPDATE = " UPDATE producto SET nombre = ?, imagen = ?, precio = ? WHERE id = ? ; ";
		// String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; ";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery();

		) {

			while (rs.next()) {

				// recuperar columnas del resultset
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				// crear pojo con datos del rs
				Serie serie = new Serie();
				serie.setId(id);
				serie.setNombre(nombre);

				// guardar en ArrayList
				registros.add(serie);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return registros;
	}

}
