package tpo.zad4.zad1;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.Hashtable;
import java.util.Properties;

public class Server {
    public static void main(String[] args) {
        try {
        	Hashtable<String, String> env = new Hashtable<>(11);
    		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
    		env.put(Context.PROVIDER_URL, "tcp://localhost:3035/");
    		Context context = new InitialContext(env);
    		context.rebind("PhoneDirectoryService", new PhoneDirectory("Contacts.txt"));


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}