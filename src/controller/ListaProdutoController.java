package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.entidade.Produto;
import model.servico.ProdutoServico;

@Named
@ViewScoped
public class ListaProdutoController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1370727606901726740L;

	@Inject
	private ProdutoServico produtoServico;

	private List<Produto> listaProduto;

	@PostConstruct
	public void init() {
		listaProduto = produtoServico.pesquisarProduto();
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public String editar(final Produto produtoSeleccionado) {
		JSFUtil.build().setRequestObject("produtoParaEditar", produtoSeleccionado);
		return "produto";
	}

	public void remover(final Produto produtoSeleccionado) {
		produtoServico.removerProduto(produtoSeleccionado);
		listaProduto = produtoServico.pesquisarProduto();
	}

	public String criar() {
		return "produto";
	}

}
