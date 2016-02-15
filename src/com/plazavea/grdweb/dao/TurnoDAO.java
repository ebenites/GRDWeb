package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Turno;

@Repository
public class TurnoDAO  implements ITurnoDAO{

	protected static Logger log = Logger.getLogger(TurnoDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Turno> listar(){
		log.info("calling listar: ");
		
		String sql = "select * from turno";
		
		List<Turno> turnos = jdbcTemplate.query(sql, new RowMapper<Turno>() {
            public Turno mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Turno turno = new Turno();
            	turno.setId(rs.getInt("id"));
            	turno.setNombre(rs.getString("nombre"));
            	turno.setHorainicio(rs.getString("horainicio"));
            	turno.setHorafin(rs.getString("horafin"));
                return turno;
            }
        });
		
		log.info("Register found: " + turnos);
		
		return turnos;
	}
	
	public Turno obtener(Integer idturno){
		log.info("calling obtener: " + idturno);
		
		String sql = "select * from turno where id = ?";
		
		Turno turno = jdbcTemplate.queryForObject(sql, new RowMapper<Turno>() {
            public Turno mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Turno turno = new Turno();
            	turno.setId(rs.getInt("id"));
            	turno.setNombre(rs.getString("nombre"));
            	turno.setHorainicio(rs.getString("horainicio"));
            	turno.setHorafin(rs.getString("horafin"));
                return turno;
            }
        }, idturno);
		
		log.info("Register found: " + turno);
		
		return turno;
	}
	
}
