package ifpb.dac.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 09/07/2018, 08:10:42
 */
@Stateless
@Remote(ServiceRemote.class)
public class ExemploServiceRemoto implements ServiceRemote {

    @Override
    public String transferencia(int contaOrigem, int contaDestino) {
        return String.format(
                "ServiceRemoto - Foi tranferido da conta: %d para a conta: %d", contaOrigem, contaDestino
        );
    }
}
