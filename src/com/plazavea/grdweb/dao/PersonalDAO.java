package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Campana;
import com.plazavea.grdweb.model.Personal;

@Repository
public class PersonalDAO  implements IPersonalDAO{

	protected static Logger log = Logger.getLogger(PersonalDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Personal> listar(Integer idcampana, Integer idtienda, Integer idarea){
		log.info("calling listar: " + idcampana + ", " + idtienda + ", " + idarea);
		
		String sql = "select e.id, e.nombres, e.apellidos, e.direccion, e.telefono, e.estado, p.campana_id "
				+ "from empleado e "
				+ "inner join personal p on p.id = e.id "
				+ "where p.campana_id = ? and  e.tienda_id = ? and e.area_id = ?";
		
		List<Personal> personales = jdbcTemplate.query(sql, new RowMapper<Personal>() {
            public Personal mapRow(ResultSet rs, int rowNum) throws SQLException{
            	
            	Personal personal = new Personal();
            	personal.setId(rs.getInt("id"));
            	personal.setNombres(rs.getString("nombres"));
            	personal.setApellidos(rs.getString("apellidos"));
            	personal.setDireccion(rs.getString("direccion"));
            	personal.setTelefono(rs.getString("telefono"));
            	personal.setEstado(rs.getString("estado"));
            	
            	Campana campana = new Campana();
            	campana.setId(rs.getInt("campana_id"));
            	
            	personal.setCampana(campana);
            	
                return personal;
            }
        }, idcampana, idtienda, idarea);
		
		log.info("Register found: " + personales);
		
		return personales;
	}
	
	@Override
	public Personal obtener(Integer idpersonal){
		log.info("calling obtener: " + idpersonal);
		
		String sql = "select e.id, e.nombres, e.apellidos, e.direccion, e.telefono, e.estado, p.campana_id "
				+ "from empleado e "
				+ "inner join personal p on p.id = e.id "
				+ "where p.id = ?";
		
		Personal pesonal = jdbcTemplate.queryForObject(sql, new RowMapper<Personal>() {
            public Personal mapRow(ResultSet rs, int rowNum) throws SQLException{
            	
            	Personal personal = new Personal();
            	personal.setId(rs.getInt("id"));
            	personal.setNombres(rs.getString("nombres"));
            	personal.setApellidos(rs.getString("apellidos"));
            	personal.setDireccion(rs.getString("direccion"));
            	personal.setTelefono(rs.getString("telefono"));
            	personal.setEstado(rs.getString("estado"));
            	
            	Campana campana = new Campana();
            	campana.setId(rs.getInt("campana_id"));
            	
            	personal.setCampana(campana);
            	
                return personal;
            }
        }, idpersonal);
		
		log.info("Register found: " + pesonal);
		
		return pesonal;
	}
	
}
