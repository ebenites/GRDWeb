package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Area;
import com.plazavea.grdweb.model.Empleado;
import com.plazavea.grdweb.model.Tienda;
import com.plazavea.grdweb.model.TiendaArea;
import com.plazavea.grdweb.model.Usuario;

@Repository
public class UsuarioDAO  implements IUsuarioDAO{

	protected static Logger log = Logger.getLogger(UsuarioDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario obtener(Integer id){
		log.info("calling obtener: " + id);
		
		String sql = "select u.id, u.username, u.userpass, e.nombres, e.apellidos, e.direccion, e.telefono, e.estado, "
				+ "t.id as tienda_id, t.nombre as tienda_nombre, a.id as area_id, a.nombre as area_nombre, a.tipo as area_tipo "
				+ "from usuario u "
				+ "inner join empleado e on e.id = u.id "
				+ "inner join tienda_area ta on ta.tienda_id = e.tienda_id and ta.area_id = e.area_id "
				+ "inner join area a on a.id = e.area_id "
				+ "inner join tienda t on t.id = e.tienda_id "
				+ "where u.id = ?";
		
		Usuario usuario = jdbcTemplate.queryForObject(sql, new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Usuario usuario = new Usuario();
            	usuario.setId(rs.getInt("id"));
            	usuario.setUsername(rs.getString("username"));
            	usuario.setUserpass(rs.getString("userpass"));
            	
            	Tienda tienda = new Tienda();
            	tienda.setId(rs.getInt("tienda_id"));
            	tienda.setNombre(rs.getString("tienda_nombre"));
            	
            	Area area = new Area();
            	area.setId(rs.getInt("area_id"));
            	area.setNombre(rs.getString("area_nombre"));
            	area.setTipo(rs.getString("area_tipo"));
            	
            	TiendaArea tienda_area = new TiendaArea(tienda, area);
            	
            	Empleado empleado = new Empleado();
            	empleado.setId(rs.getInt("id"));
            	empleado.setNombres(rs.getString("nombres"));
            	empleado.setApellidos(rs.getString("apellidos"));
            	empleado.setDireccion(rs.getString("direccion"));
            	empleado.setTelefono(rs.getString("telefono"));
            	empleado.setEstado(rs.getString("estado"));
            	empleado.setTiendaArea(tienda_area);
            	
            	usuario.setEmpleado(empleado);
            	
                return usuario;
            }
        }, id);
		
		log.info("Register found: " + usuario);
		
		return usuario;
	}
	
}
