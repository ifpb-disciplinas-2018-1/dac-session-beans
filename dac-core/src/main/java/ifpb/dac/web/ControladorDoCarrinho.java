package ifpb.dac.web;

import ifpb.dac.carrinho.CarrinhoDeCompras;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/07/2018, 07:32:17
 */
@Named
@SessionScoped
public class ControladorDoCarrinho implements Serializable {

    @EJB
    private CarrinhoDeCompras carrinho;

    private String produto;

    public String add() {
        this.carrinho.adicionarProduto(produto);
        this.produto = "";
        return null;
    }

    public String excluir(String produto) {
        this.carrinho.removerProduto(produto);
        return null;
    }

    public String finalizar() {
        this.carrinho.finalizar();
        logout();
        return null;
    }
    
    private void logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.invalidate();
        
        try {
            externalContext.redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControladorDoCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<String> todosOsProdutos() {
        return this.carrinho.todosOsProdutos();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }


}
