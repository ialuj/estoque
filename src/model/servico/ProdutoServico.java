package model.servico;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entidade.Produto;
import model.servico.exception.NegocioException;

@Stateless
public class ProdutoServico {

	@PersistenceContext
	private EntityManager entityManager;

	public Produto salvarProduto(Produto produto) {
		verificarSeDataFabricacaoEhMuitoAntiga(produto);
		produto = entityManager.merge(produto);
		return produto;
	}

	public List<Produto> pesquisarProduto() {

		List<Produto> produtos = entityManager.createNamedQuery("pesquisarProduto", Produto.class).getResultList();

		return produtos;
	}

	public void removerProduto(Produto produto) {
		if (!entityManager.contains(produto)) {
			produto = entityManager.find(Produto.class, produto.getId());
		}

		entityManager.remove(produto);
	}

	private void verificarSeDataFabricacaoEhMuitoAntiga(Produto produto) {
		LocalDate anoPassado = LocalDate.now().minusYears(1);
		if (produto.getDataFabricacao().isBefore(anoPassado)) {
			throw new NegocioException("Data fabricação muito antiga. Cadastro rejeitado.");
		}
	}

}
