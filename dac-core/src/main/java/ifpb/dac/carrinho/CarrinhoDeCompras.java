package ifpb.dac.carrinho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/07/2018, 07:23:50
 */
@Stateful
public class CarrinhoDeCompras {

    private List<String> produtos = new ArrayList<>();

    public void adicionarProduto(String produto) {
        this.produtos.add(produto);

    }

    public void removerProduto(String produto) {
        this.produtos.remove(produto);
    }

    @Remove
    public void finalizar() {
        System.out.println("--Produtos--");
        this.produtos.forEach(System.out::println);
    }

    public List<String> todosOsProdutos() {
        return Collections.unmodifiableList(produtos);
    }
}
