package com.plazavea.grdweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.plazavea.grdweb.model.Campana;
import com.plazavea.grdweb.model.DetalleProgramacion;
import com.plazavea.grdweb.model.Programacion;
import com.plazavea.grdweb.model.Usuario;

@Repository
public class ProgramacionDAO  implements IProgramacionDAO{

	protected static Logger log = Logger.getLogger(ProgramacionDAO.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Programacion> listar(Integer idusuario){
		log.info("calling listar: ");
		
		String sql = "select p.id, p.fechainicio, p.fechafin, p.estado, c.nombre as campana_nombre, u.username "
				+ "from programacion p "
				+ "inner join campana c on c.id = p.campana_id "
				+ "inner join usuario u on u.id = p.usuario_id "
				+ "where u.id = ? "
				+ "order by c.fechainicio desc, p.fechainicio desc";
		
		List<Programacion> programaciones = jdbcTemplate.query(sql, new RowMapper<Programacion>() {
            public Programacion mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Programacion programacion = new Programacion();
            	programacion.setId(rs.getInt("id"));
            	programacion.setFechainicio(rs.getString("fechainicio"));
            	programacion.setFechafin(rs.getString("fechafin"));
            	programacion.setEstado(rs.getString("estado"));
            	
            	Usuario usuario = new Usuario();
            	usuario.setUsername(rs.getString("username"));
            	programacion.setUsuario(usuario);
            	
            	Campana campana = new Campana();
            	campana.setNombre(rs.getString("campana_nombre"));
            	programacion.setCampana(campana);
            	
                return programacion;
            }
        }, idusuario);
		
		log.info("Register found: " + programaciones);
		
		return programaciones;
	}
	
	public List<Programacion> buscar(Integer idusuario, String fecha1, String fecha2) throws Exception{
		log.info("calling fecha1: " + idusuario + ", " + fecha1 + ", " + fecha2);
		
		Date fecha1Date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
		Date fecha2Date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
		
		String sql = "select p.id, p.fechainicio, p.fechafin, p.estado, c.nombre as campana_nombre, u.username "
				+ "from programacion p "
				+ "inner join campana c on c.id = p.campana_id "
				+ "inner join usuario u on u.id = p.usuario_id "
				+ "where u.id = ? and p.fechainicio = ? and p.fechafin = ? "
				+ "order by c.fechainicio desc, p.fechainicio desc";
		
		List<Programacion> programaciones = jdbcTemplate.query(sql, new RowMapper<Programacion>() {
            public Programacion mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Programacion programacion = new Programacion();
            	programacion.setId(rs.getInt("id"));
            	programacion.setFechainicio(rs.getString("fechainicio"));
            	programacion.setFechafin(rs.getString("fechafin"));
            	programacion.setEstado(rs.getString("estado"));
            	
            	Usuario usuario = new Usuario();
            	usuario.setUsername(rs.getString("username"));
            	programacion.setUsuario(usuario);
            	
            	Campana campana = new Campana();
            	campana.setNombre(rs.getString("campana_nombre"));
            	programacion.setCampana(campana);
            	
                return programacion;
            }
        }, idusuario, fecha1Date, fecha2Date);
		
		log.info("Register found: " + programaciones);
		
		return programaciones;
	}
	
	public List<Programacion> pendientes(Integer idusuario){
		log.info("calling pendientes: ");
		
		String sql = "select p.id, p.fechainicio, p.fechafin, p.estado, c.nombre as campana_nombre, u.username "
				+ "from programacion p "
				+ "inner join campana c on c.id = p.campana_id "
				+ "inner join usuario u on u.id = p.usuario_id "
				+ "where p.estado='P' and u.id = ? "
				+ "order by c.fechainicio desc, p.fechainicio desc";
		
		List<Programacion> programaciones = jdbcTemplate.query(sql, new RowMapper<Programacion>() {
            public Programacion mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Programacion programacion = new Programacion();
            	programacion.setId(rs.getInt("id"));
            	programacion.setFechainicio(rs.getString("fechainicio"));
            	programacion.setFechafin(rs.getString("fechafin"));
            	programacion.setEstado(rs.getString("estado"));
            	
            	Usuario usuario = new Usuario();
            	usuario.setUsername(rs.getString("username"));
            	programacion.setUsuario(usuario);
            	
            	Campana campana = new Campana();
            	campana.setNombre(rs.getString("campana_nombre"));
            	programacion.setCampana(campana);
            	
                return programacion;
            }
        }, idusuario);
		
		log.info("Register found: " + programaciones);
		
		return programaciones;
	}
	
	public void registrar(Programacion programacion) throws Exception{
		log.info("calling registrar: " + programacion);
		
		Date fechainicio = new SimpleDateFormat("yyyy-MM-dd").parse(programacion.getFechainicio());
		Date fechafin = new SimpleDateFormat("yyyy-MM-dd").parse(programacion.getFechafin());
		
		String sql = "insert into programacion (fechainicio, fechafin, campana_id, usuario_id, estado) values(?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, fechainicio, fechafin, programacion.getCampana().getId(), programacion.getUsuario().getId(), programacion.getEstado());
		
		for (DetalleProgramacion detalle : programacion.getDetalles()) {
			log.info("Insertando detalle: " + detalle);
			
			Date fechaasignacion = new SimpleDateFormat("yyyy-MM-dd").parse(detalle.getFechaAsignacion());
			
			sql = "insert into programacion_detalle (programacion_id, item, tienda_id, area_id, personal_id, turno_id, caja_id, fechaasignacion) "
					+ "values(currval('programacion_id_seq'), ?, ?, ?, ?, ?, ?, ?)";
			
			jdbcTemplate.update(sql, detalle.getItem(), detalle.getArea().getTienda().getId(), detalle.getArea().getArea().getId(), detalle.getPersonal().getId(), detalle.getTurno().getId(), detalle.getCaja().getId(), fechaasignacion);
		}
		
	}
	
	public void eliminar(Integer id) {
		log.info("calling eliminar: " + id);
		
		String sql = "delete from programacion_detalle where programacion_id = ?";
		
		jdbcTemplate.update(sql, id);
		
		sql = "delete from programacion where id = ?";
		
		jdbcTemplate.update(sql, id);
		
	}
	
}
