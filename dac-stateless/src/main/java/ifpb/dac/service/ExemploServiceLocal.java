package ifpb.dac.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 09/07/2018, 07:28:43
 */
@Stateless
public class ExemploServiceLocal {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String transferencia(int contaOrigem, int contaDestino) {
        credito(contaOrigem, contaDestino);
        debito(contaDestino, contaOrigem);
        return String.format("Foi tranferido da conta: %d para a conta: %d", contaOrigem, contaDestino);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String credito(int contaOrigem, int contaDestino) {
        return "Kiko";
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String debito(int contaOrigem, int contaDestino) {
        // faill
        return "Kiko";
    }
}
