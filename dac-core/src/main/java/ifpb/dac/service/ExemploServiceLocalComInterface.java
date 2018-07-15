package ifpb.dac.service;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 09/07/2018, 08:10:42
 */
@Stateless
@Local(ServiceLocal.class)
public class ExemploServiceLocalComInterface implements ServiceLocal {

    @Override
    public String transferencia(int contaOrigem, int contaDestino) {
        return String.format(
                "ServiceLocal - Foi tranferido da conta: %d para a conta: %d", contaOrigem, contaDestino
        );
    }
}
