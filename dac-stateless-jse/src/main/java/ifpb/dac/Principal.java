package ifpb.dac;

import ifpb.dac.service.ServiceRemote;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 09/07/2018, 08:47:10
 */
public class Principal {

    public static void main(String[] args) {
        ServiceRemote service = new ServiceLocator().lookup();

        String transferencia = service.transferencia(1, 1);
        System.out.println("transferencia: " + transferencia);
    }
}
