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

@Repository
public class CampanaDAO  implements ICampanaDAO{

	protected static Logger log = Logger.getLogger(CampanaDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Campana> listar(){
		log.info("calling listar: ");
		
		String sql = "select * from campana";
		
		List<Campana> campanas = jdbcTemplate.query(sql, new RowMapper<Campana>() {
            public Campana mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Campana campana = new Campana();
            	campana.setId(rs.getInt("id"));
            	campana.setNombre(rs.getString("nombre"));
            	campana.setFechainicio(rs.getString("fechainicio"));
            	campana.setFechafin(rs.getString("fechafin"));
            	campana.setEstado(rs.getString("estado"));
                return campana;
            }
        });
		
		log.info("Register found: " + campanas);
		
		return campanas;
	}
	
	public Campana obtener(Integer id){
		log.info("calling obtener: " + id);
		
		String sql = "select * from campana where id = ?";
		
		Campana campana = jdbcTemplate.queryForObject(sql, new RowMapper<Campana>() {
            public Campana mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Campana campana = new Campana();
            	campana.setId(rs.getInt("id"));
            	campana.setNombre(rs.getString("nombre"));
            	campana.setFechainicio(rs.getString("fechainicio"));
            	campana.setFechafin(rs.getString("fechafin"));
            	campana.setEstado(rs.getString("estado"));
                return campana;
            }
        }, id);
		
		log.info("Register found: " + campana);
		
		return campana;
	}
	
}
