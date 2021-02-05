package controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.entidade.Produto;
import model.servico.ProdutoServico;
import model.servico.exception.NegocioException;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5227491759843739484L;

	@Inject
	private ProdutoServico produtoServico;

	private Produto produto;

	@PostConstruct
	private void init() {

		produto = (Produto) JSFUtil.build().getRequestObject("produtoParaEditar");

		if (produto == null) {
			produto = new Produto();
		}
	}

	public void salvarProduto() {
		try {
		produto = produtoServico.salvarProduto(produto);
		String msg = String.format("Produto cadastrado com sucesso: " + produto.getId() + " - " + produto.getDescricao()
				+ " - " + produto.getDataFabricacao());
		clearFields();
		JSFUtil.build().addInfoMessage(msg);
		}
		catch (NegocioException e) {
			// TODO: handle exception
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String irParaListaProduto() {
		return "lista-produto";
	}

	private void clearFields() {
		produto = new Produto();
	}

}
