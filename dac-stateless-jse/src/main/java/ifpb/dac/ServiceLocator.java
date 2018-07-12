package ifpb.dac;

import ifpb.dac.service.ServiceRemote;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 21/06/2018, 08:23:01
 */
public class ServiceLocator {

    private static final String SERVICE_REMOTE = "java:global/dac-stateless/ExemploServiceRemoto";

    public <T> T lookup() {
        try {
            Properties properties = new Properties();
            properties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
                    "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            Context context = new InitialContext(properties);
            return (T) context.lookup(SERVICE_REMOTE);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
