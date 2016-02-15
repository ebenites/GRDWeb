package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Area;
import com.plazavea.grdweb.model.Tienda;
import com.plazavea.grdweb.model.TiendaArea;

@Repository
public class AreaDAO  implements IAreaDAO{

	protected static Logger log = Logger.getLogger(AreaDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<TiendaArea> listar(Integer idtienda){
		log.info("calling listar: " + idtienda);
		
		String sql = "select ta.area_id, a.nombre as area_nombre, a.tipo, ta.tienda_id, t.nombre as tienda_nombre, ta.capacidad "
				+ "from tienda_area ta  "
				+ "inner join tienda t on t.id = ta.tienda_id "
				+ "inner join area a on a.id = ta.area_id "
				+ "where ta.tienda_id = ?";
		
		List<TiendaArea> areas = jdbcTemplate.query(sql, new RowMapper<TiendaArea>() {
            public TiendaArea mapRow(ResultSet rs, int rowNum) throws SQLException{
            	
            	Tienda tienda = new Tienda();
            	tienda.setId(rs.getInt("tienda_id"));
            	tienda.setNombre(rs.getString("tienda_nombre"));
            	
            	Area area = new Area();
            	area.setId(rs.getInt("area_id"));
            	area.setNombre(rs.getString("area_nombre"));
            	area.setTipo(rs.getString("tipo"));
            	
            	TiendaArea tienda_area = new TiendaArea(tienda, area);
            	tienda_area.setCapacidad(rs.getInt("capacidad"));
            	
                return tienda_area;
            }
        }, idtienda);
		
		log.info("Register found: " + areas);
		
		return areas;
	}
	
	public TiendaArea obtener(Integer idtienda, Integer idarea){
		log.info("calling obtener: " + idtienda+ ", " + idarea);
		
		String sql = "select ta.area_id, a.nombre as area_nombre, a.tipo, ta.tienda_id, t.nombre as tienda_nombre, ta.capacidad "
				+ "from tienda_area ta  "
				+ "inner join tienda t on t.id = ta.tienda_id "
				+ "inner join area a on a.id = ta.area_id "
				+ "where ta.tienda_id = ? and ta.area_id = ?";
		
		TiendaArea area = jdbcTemplate.queryForObject(sql, new RowMapper<TiendaArea>() {
            public TiendaArea mapRow(ResultSet rs, int rowNum) throws SQLException{
            	
            	Tienda tienda = new Tienda();
            	tienda.setId(rs.getInt("tienda_id"));
            	tienda.setNombre(rs.getString("tienda_nombre"));
            	
            	Area area = new Area();
            	area.setId(rs.getInt("area_id"));
            	area.setNombre(rs.getString("area_nombre"));
            	area.setTipo(rs.getString("tipo"));
            	
            	TiendaArea tienda_area = new TiendaArea(tienda, area);
            	tienda_area.setCapacidad(rs.getInt("capacidad"));
            	
                return tienda_area;
            }
        }, idtienda, idarea);
		
		log.info("Register found: " + area);
		
		return area;
	}
	
}
