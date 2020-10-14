package tpo.zad4.zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.io.IOException;
import java.util.Properties;


public class Client {
    private static Context context;
    private static Object remoteObject;
    private PhoneDirectoryInterface phoneDirectoryInterface;
    private static String replies[] = { "Request correct.", "Request incorrect.",
            "Contact not found.", "That contact already exists.",
            "Name doesn't exist in your contacts list.", "That is the current number." };

    public void requestHandle(int index){
        System.out.println("Code: "+index+" Reply: "+replies[index]);
    }
    public void requestHandle(int index, String message){
        System.out.println("Code: "+index+" Reply: "+replies[index] +" Message: "+message);
    }


    public void request(String request) throws IOException {

        String[] requestParts = request.split(" ");
        String command = requestParts[0];
//"bye","get imię","add imię numer","replace imię numer"

        switch(command){
            case "bye" :
                requestHandle(0, "bye");

            case "get":
                String number = phoneDirectoryInterface.getPhoneNumber(requestParts[1]);
                if(number!=null){
                    requestHandle(0, number);
                }else{
                    requestHandle(2);
                }
            case "add":
                boolean added = phoneDirectoryInterface.addPhoneNumber(requestParts[1], requestParts[2]);
                if(added){
                    requestHandle(0,"Contact added");
                }else{
                    requestHandle(3);
                }
            case "replace":
                boolean replaced = phoneDirectoryInterface.replacePhoneNumber(requestParts[1], requestParts[2]);
                if(replaced){
                    requestHandle(0,"Number replaced");
                }else{
                    requestHandle(4);
                }
            default:
                requestHandle(1);


        }

    }
    public static void main(String[] args) {
        try {
            Client client = new Client();
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
            properties.setProperty(Context.PROVIDER_URL, "iiop://localhost:50000");
            context = new InitialContext(properties);
            remoteObject = context.lookup("PhoneDirectoryService");
            client.phoneDirectoryInterface = (PhoneDirectoryInterface) PortableRemoteObject
                    .narrow(remoteObject, PhoneDirectoryInterface.class);


            client.request("get Sam");
            client.request("add Kylie 333-444-555");
            client.request("get Mary");
            client.request("replace Sam 456-123-321");
            client.request("get John");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}