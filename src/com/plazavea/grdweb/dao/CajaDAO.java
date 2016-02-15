package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Caja;

@Repository
public class CajaDAO  implements ICajaDAO{

	protected static Logger log = Logger.getLogger(CajaDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Caja> listar(Integer idtienda){
		log.info("calling listar: " + idtienda);
		
		String sql = "select * from caja where estado ='A' and tienda_id = ?";
		
		List<Caja> cajas = jdbcTemplate.query(sql, new RowMapper<Caja>() {
            public Caja mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Caja caja = new Caja();
            	caja.setId(rs.getInt("id"));
            	caja.setNumero(rs.getString("numero"));
            	
                return caja;
            }
        }, idtienda);
		
		log.info("Register found: " + cajas);
		
		return cajas;
	}
	
	public Caja obtener(Integer idcaja){
		log.info("calling obtener: " + idcaja);
		
		String sql = "select * from caja where id = ?";
		
		Caja caja = jdbcTemplate.queryForObject(sql, new RowMapper<Caja>() {
            public Caja mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Caja caja = new Caja();
            	caja.setId(rs.getInt("id"));
            	caja.setNumero(rs.getString("numero"));
            	
                return caja;
            }
        }, idcaja);
		
		log.info("Register found: " + caja);
		
		return caja;
	}
	
}
