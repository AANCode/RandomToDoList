import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean kjorer = true;
        Scanner sc  = new Scanner(System.in);

        List<String> todo = new ArrayList();

        String test = "test";
        todo.add("go to the gym");
        todo.add(test);


        System.out.println(todo);

        while (kjorer) {
            // TODO: legg til en sjekk som validerer om et nummer ble skrevet
            System.out.println("1: Vis listen \n" +
                    "2: Legg til i listen \n" +
                    "3: fjern fra listen \n" +
                    "4: fjern fra listen");

            int valg = Integer.parseInt(sc.nextLine());

            switch (valg) {
                case 1:
                    System.out.println(todo);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }

}