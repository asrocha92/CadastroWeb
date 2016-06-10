package br.univel.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cadastroWeb.model.Cliente;

@Stateless
public class ClienteDao {

	@PersistenceContext(unitName = "cadastroWeb-persistence-unit")
	private EntityManager em;
	
	public void salvar(Cliente c){
		
		if(c.getNome().isEmpty()){
			throw new RuntimeException("Digíte o nome do cliente!");
		}
		em.persist(c);
		
	}

}
