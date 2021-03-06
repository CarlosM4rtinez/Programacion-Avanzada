package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.Persona;
import entidades.Quirofano;

/**
 * 
 * @author Sebastian
 *
 */
@LocalBean
@Stateless
public class QuirofanoEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Metodo para buscar un quirofano
	 * @param id
	 * @return
	 */
	public Quirofano buscar(int id){
		return em.find(Quirofano.class, id);
	}
	
	/**
	 * Metodo que lista todos los quirofanos
	 * @return, los quirofanos
	 */
	public List<Quirofano> listarQuirofano(){
		Query q = em.createNamedQuery(Quirofano.listarQuirofano);
		List<Quirofano> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * Buscar quirofano por nombre
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Quirofano buscarByNombre(String nombre){
		Query q = em.createNamedQuery(Quirofano.BYNOMBRE);
		q.setParameter(1, nombre);
		List<Quirofano> lista = q.getResultList();
		if(lista.size() > 0){
			return lista.get(0);
		}
		return null;
	}
	
	/**
	 * crear
	 */
	public void crear(Quirofano entidad){
		em.persist(entidad);
	}
	
	/**
	 * editar
	 */
	public void editar(Quirofano entidad){
		em.merge(entidad);
	}
	
	/**
	 * Eliminar
	 */
	public void eliminar(Quirofano entidad){
		em.remove(entidad);
	}
}
