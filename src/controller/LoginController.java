package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.entidade.Usuario;
import model.servico.UsuarioServico;

@Named
@ViewScoped
public class LoginController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6983839857205389929L;

	@Inject
	private UsuarioServico usuarioServico;

	private Usuario usuario;

	private String login;

	private String senha;

	@PostConstruct
	private void init() {
		usuario = null;
	}

	public String efectuarLogin() {
		
		try {
			usuario = usuarioServico.buscarUsuarioPeloLoginESenha(login, senha);

			if (usuario != null) {
				JSFUtil.build().setRequestObject("loggedUser", usuario);
				return "produto";
			}

		} catch (Exception e) {
			JSFUtil.build().addErrorMessage("Autenticacao Falhou. Tente novamente");
		}
		return "login";
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
