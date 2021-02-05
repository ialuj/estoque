package model.servico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entidade.Usuario;

@Stateless
public class UsuarioServico {

	@PersistenceContext
	private EntityManager entityManager;

	public Usuario buscarUsuarioPeloLoginESenha(final String login, final String senha) {
		Usuario usuario = entityManager.createNamedQuery("pesquisarUsuarioPorLoginSenha", Usuario.class)
				.setParameter("login", login).setParameter("senha", senha).getSingleResult();
		return usuario;
	}
}
