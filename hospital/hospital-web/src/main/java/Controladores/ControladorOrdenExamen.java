/**
 * 
 */
package Controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

import org.omnifaces.util.Messages;

import beans.EJBUsuario;
import beans.OrdenExamenEJB;
import entidades.CitaMedica;
import entidades.Examen;
import entidades.Medico;
import entidades.OrdenExamen;

/**
 * @author AlejandroM
 *
 */
@Named("OrdenEx")
@ViewScoped
public class ControladorOrdenExamen implements Serializable{

	
	@EJB
	OrdenExamenEJB ordenEJB;
	
	@EJB
	EJBUsuario usuarioEJB;
	
	private int id;
	
	private CitaMedica cita;
	private Examen examen;
	private Date fecha;
	private String descripcion;
	private Medico medico;
	
	
	private List<CitaMedica> listarCitas;
	private List<Examen> listaExamen;
	
	private List<OrdenExamen> listaOrden;
	private List<Medico> listaMedicos;
	
	
	@PostConstruct
	public void iniciar(){
		listarCitas = ordenEJB.listaCitas();
		listaOrden = ordenEJB.listaOrdenes();
		listaExamen = ordenEJB.listaExamen();
		listaMedicos = usuarioEJB.listarMedicos();
	}
	
	
	
	/**
	 * Metodo para crear una orden de un examen
	 */
	public void crear(){
	
		OrdenExamen orden = new OrdenExamen(cita, examen, fecha, descripcion, medico);
		ordenEJB.crear(orden);
		Messages.addFlashGlobalInfo("La orden del examen se ha creado exitosamente");
	}
	
	
	
	/**
	 * Metodo para eliminar una orden de examen
	 */
	public void eliminar(){
		OrdenExamen orden = new OrdenExamen();
		ordenEJB.eliminar(orden);
		Messages.addFlashGlobalInfo("La orden del examen se ha eliminado exitosamente");
	}
	
	/**
	 * Metodo para editar una orden de examen
	 */
	public void editar(){
		OrdenExamen or = ordenEJB.buscar(id);
		if (or!=null) {
			or.setCitaMedica(cita);
			or.setDescripcion(descripcion);
			or.setExamen(examen);
			or.setFechaRealizacion(fecha);
			or.setMedico(medico);
			ordenEJB.editar(or);
			Messages.addFlashGlobalInfo("La orden del examen se ha editado exitosamente");
		} else {
			Messages.addFlashGlobalInfo("No existe ningun orden con este numero");
		}

	}
	
	
	/**
	 * Metodo para buscar las ordenes de los medicamentos
	 */
	public void buscar() {
		OrdenExamen or = ordenEJB.buscar(id);
		System.out.println(or);
		if (or!=null) {
			cita = or.getCitaMedica();
			medico = or.getMedico();
			examen = or.getExamen();
			fecha = or.getFechaRealizacion();
			descripcion = or.getDescripcion();
			
		} else {
			Messages.addFlashGlobalInfo("No hay orden medica con estos datos");
		}
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<OrdenExamen> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<OrdenExamen> listaOrden) {
		this.listaOrden = listaOrden;
	}

	public CitaMedica getCita() {
		return cita;
	}
	public void setCita(CitaMedica cita) {
		this.cita = cita;
	}
	public Examen getExamen() {
		return examen;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	public List<CitaMedica> getListarCitas() {
		return listarCitas;
	}
	public void setListarCitas(List<CitaMedica> listarCitas) {
		this.listarCitas = listarCitas;
	}
	public List<Examen> getListaExamen() {
		return listaExamen;
	}
	public void setListaExamen(List<Examen> listaExamen) {
		this.listaExamen = listaExamen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
	
	
	
	
}
