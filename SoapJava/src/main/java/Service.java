import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;

@WebService(name = "Service",targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {

    @WebMethod(operationName = "guessNumber")
    public String responseMessage(@WebParam(name = "number")int number){

        if (number == new Random().nextInt(9)){
            return "The number is the same";
        }else{
            return "No today, try again";
        }
    }

    @WebMethod(operationName = "getConsonants")
    public String getConsonants(@WebParam(name = "nombre")String message){
        char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
        String con = "";

        for (int i = 0; i < message.length(); i++){
            for (int j = 0; j < consonantes.length; j++){
                if (message.charAt(i) == consonantes[j]){
                    con+=message.charAt(i);
                }
            }
        }
        return "Cadena Original " + message + " Consonantes " +con;
    }

    @WebMethod(operationName = "RFC")
    public String RFC(@WebParam(name = "person")BeanPerson person){
        String rfc = person.getPaterno().substring(0, 2).toUpperCase();
        rfc += person.getMaterno().substring(0, 1).toUpperCase();
        rfc += person.getName().substring(0,1).toUpperCase();
        rfc += person.getDate().substring(8).toUpperCase();
        rfc += person.getDate().substring(3, 5).toUpperCase();
        rfc += person.getDate().substring(0 ,2 ).toUpperCase();
        String letras = "abcdefghijklmnopqrstuvwxy";
        Random r = new Random();
        String aleatorio = letras.charAt(r.nextInt(letras.length() - 1)) + "";
        aleatorio += r.nextInt(9) + "" + r.nextInt(9);
        return "Nombre: "+person.getName()+"\n"+"Apellido paterno: "+person.getPaterno()+"\n"+"Apellido materno:"
                +person.getMaterno()+"\n"+"Fecha de cumpleaños: "+person.getDate()+"\n"+"RFC: "+rfc+aleatorio;
    }




    public static void main (String[] args){
        System.out.println("Initializing server...");
        Endpoint.publish("http://localhost:8080/Service", new Service());
        System.out.println("Waiting request....");
    }

}

/*
        if (message == null)
            return "Nothing was provided";
        return message.replaceAll("[aeiou]","");
 */

 /*
        char[] consonantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
        String con = "";

        for (int i = 0; i < nombre.length(); i++){
            for (int j = 0; j < consonantes.length; j++){
                if (nombre.charAt(i) == consonantes[j]){
                    con+=nombre.charAt(i);
                }
            }
        }
        return "Cadena Original " + nombre + "Consonantes " +con;

         */