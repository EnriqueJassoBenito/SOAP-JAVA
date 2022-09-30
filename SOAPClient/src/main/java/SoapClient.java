import utez.BeanPerson;
import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class SoapClient {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        String response = port.guessNumber(3);
        System.out.println(response);

        String response1 = port.getConsonants("jasso");
        System.out.println(response1);

        BeanPerson person = new BeanPerson();
        person.setName("Enrique");
        person.setPaterno("Osorio");
        person.setMaterno("Jasso");
        person.setDate("23-08-2003");
        String response2 = port.rfc(person);
        System.out.println(response2);
    }

}


/*
public static void main (String[] args){
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        String response = port.responseMessage("Henrry");
        System.out.println(response);
    }
 */